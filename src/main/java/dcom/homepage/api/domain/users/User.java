package dcom.homepage.api.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dcom.homepage.api.domain.group.Group;
import dcom.homepage.api.domain.study.Study;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User implements UserDetails {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(length = 255, nullable = false, name = "userid", unique = true)
    private String userId;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 255, nullable = false, name = "realname")
    private String realName;

    @Column(length = 255, nullable = false)
    private String phone;

    @Column(nullable = false, name = "admissionyear")
    private Integer admissionYear;

    @Column(nullable = false)
    private Integer confirm;

    @Column(nullable = false)
    private Integer admin;

    @Column(length = 100, name = "remember_token")
    private String rememberToken;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @Column(nullable = true)
    private String github;

    @Column(nullable = true)
    private String homepage;

    @Column(nullable = true)
    private String baekjoon;

    @OneToMany
    private Set<Study> ownStudies = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tech_group_user",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name="group_id"))
    private Set<Group> groups = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "study_group_owner",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="study_group_id"))
    private Set<Study> managingStudies = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "study_group_user",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="study_group_id"))
    private Set<Study> studies = new HashSet<>();

    @ElementCollection
    private List<SimpleGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> auth = new HashSet<>();
        if (this.confirm == 1) {
            auth.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
        }
        if (this.admin == 1) {
            auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return auth;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.confirm == 1;
    }
}
