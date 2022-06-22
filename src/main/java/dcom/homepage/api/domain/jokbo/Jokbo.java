package dcom.homepage.api.domain.jokbo;

import dcom.homepage.api.domain.users.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(uniqueConstraints ={
        @UniqueConstraint(columnNames = {"professor", "course"})
})
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

    @Column(name = "content_count")
    @ColumnDefault("0")
    private Integer contentCount;

    @OneToMany(mappedBy = "jokbo")
    private Set<JokboContent> contents = new HashSet<>();
}
