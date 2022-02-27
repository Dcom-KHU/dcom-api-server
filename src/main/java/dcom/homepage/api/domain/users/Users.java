package dcom.homepage.api.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    private String userid;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 255, nullable = false)
    private String realname;

    @Column(length = 255, nullable = false)
    private String phone;

    @Column(length = 11, nullable = false)
    private Integer admissionyear;

    @Column(length = 11, nullable = false)
    private Integer confirm;

    @Column(length = 11, nullable = false)
    private Integer admin;

    @Column(length = 100)
    private String remember_token;

    private Date logintime;
    private Date created_at;
    private Date updated_at;

    @Builder
    public Users(Integer id, String userid, String email, String password, String realname, String phone, Integer admissionyear, Integer confirm, Integer admin, String remember_token, Date logintime, Date created_at, Date updated_at) {
        this.id = id;
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.admissionyear = admissionyear;
        this.confirm = confirm;
        this.admin = admin;
        this.remember_token = remember_token;
        this.logintime = logintime;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
