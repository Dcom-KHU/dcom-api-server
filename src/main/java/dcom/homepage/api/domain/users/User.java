package dcom.homepage.api.domain.users;

import dcom.homepage.api.domain.group.Group;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.*;

@Builder
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false, name = "userid")
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

    @Column(length = 100)
    private String rememberToken;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(nullable = true)
    private String github;

    @Column(nullable = true)
    private String homepage;

    @ManyToMany
    @JoinTable(name = "tech_group_user",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name="group_id"))
    private Set<Group> groups = new HashSet<>();

    @Builder
    public User(Integer id, String userId, String email, String password, String realName, String phone, Integer admissionYear, Integer confirm, Integer admin, String rememberToken, Date loginTime, Date createdAt, Date updatedAt, String github, String homepage, Set<Group> groups) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.realName = realName;
        this.phone = phone;
        this.admissionYear = admissionYear;
        this.confirm = confirm;
        this.admin = admin;
        this.rememberToken = rememberToken;
        this.loginTime = loginTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.github = github;
        this.homepage = homepage;
        this.groups = groups;
    }
}
