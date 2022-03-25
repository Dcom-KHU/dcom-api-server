package dcom.homepage.api.domain.study;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dcom.homepage.api.domain.users.User;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
}
