package dcom.homepage.api.domain.study;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dcom.homepage.api.domain.users.User;
import io.swagger.models.auth.In;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "study_group")
public class Study {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private StudyType type;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Date vacationStartDate;

    @Column(nullable = false)
    private Date vacationEndDate;

    @Column(nullable = true)
    private Integer cycle;

    @ManyToOne
    private User owner;

    @ManyToMany
    @JoinTable(name = "study_group_owner",
            joinColumns = @JoinColumn(name="study_group_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> admin = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "study_group_user",
            joinColumns = @JoinColumn(name="study_group_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "study_group_pending_user",
            joinColumns = @JoinColumn(name="study_group_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> pendingUsers = new HashSet<>();

    @Column
    @CreatedDate
    private Date createdAt;

    @Column
    @LastModifiedDate
    private Date updatedAt;
}
