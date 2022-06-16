package dcom.homepage.api.domain.jokbo;

import dcom.homepage.api.domain.users.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Jokbo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User writer;

    @Column
    private String professor;

    @Column
    private String course;

    @Column(name = "recent_upload")
    private LocalDateTime recentUpload;

    @Column
    private Integer contentCount;

    @OneToMany(mappedBy = "jokbo")
    private Set<JokboContent> contents = new HashSet<>();
}
