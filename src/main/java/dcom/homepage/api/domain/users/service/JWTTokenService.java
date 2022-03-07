package dcom.homepage.api.domain.users.service;


import dcom.homepage.api.domain.users.dto.Token;
import dcom.homepage.api.domain.users.dto.UserTokenDto;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
@Slf4j
public class JWTTokenService implements TokenService {
    @Value("${jwt.secret.base64.access}")
    private String accessSecretKey;
    @Value("${jwt.secret.base64.refresh}")
    private String refreshSecretKey;
    @Value("${jwt.expiration-seconds.access}")
    private long accessTokenExpirationSeconds;
    @Value("${jwt.expiration-seconds.refresh}")
    private long refreshTokenExpirationSeconds;

    private static final String AUTHORITIES_ID = "userId";
    private static final String AUTHORITIES_NAME = "realName";

    private String newToken(String userId, String realName, boolean isAccessToken) {
        long now = (new Date()).getTime();
        Date validity = (isAccessToken) ? new Date(now + this.accessTokenExpirationSeconds * 1000) :
                new Date(now + this.refreshTokenExpirationSeconds*1000);
        String key = (isAccessToken) ? this.accessSecretKey : this.refreshSecretKey;

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .claim(AUTHORITIES_ID, userId)
                .claim(AUTHORITIES_NAME, realName)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, this.generateKey(key))
                .compact();

    }

    private byte[] generateKey(String secretKey) {
        byte[] key = null;
        try {
            key = secretKey.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return key;
    }

    @Override
    public UserTokenDto verifyToken(String token, boolean isAccess) {
        String key = (isAccess) ? this.accessSecretKey : this.refreshSecretKey;
        String message = "";
        try {
            Jwts.parser().setSigningKey(this.generateKey(key)).parseClaimsJws(token);
            Claims claims = Jwts.parser().setSigningKey(this.generateKey(key))
                    .parseClaimsJws(token).getBody();
            return UserTokenDto.builder()
                    .userId(claims.get(AUTHORITIES_ID).toString())
                    .realName(claims.get(AUTHORITIES_NAME).toString())
                    .build();
        } catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {0}", e);
            message = e.getMessage();
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {0}", e);
            message = e.getMessage();
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {0}", e);
            message = e.getMessage();
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {0}", e);
            message = e.getMessage();
        } catch (JwtException e) {
            log.info("JWT token are invalid.");
            log.trace("JWT token are invalid trace: {0}", e);
            message = e.getMessage();
        }
        throw new RuntimeException(message);
    }

    @Override
    public Token generateToken(UserTokenDto userDto) {
        String userId = userDto.getUserId();
        String realName = userDto.getRealName();
        return Token.builder()
                .accessToken(newToken(userId, realName, true))
                .refreshToken(newToken(userId, realName, false))
                .build();
    }


}
