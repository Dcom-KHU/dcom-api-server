package dcom.homepage.api.domain.jokbo;

import dcom.homepage.api.domain.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JokboContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "jokbo_writer")
    private User writer;

    @Column
    private Integer year;

    @Column
    private Integer semester;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "jokbo_id")
    private Jokbo jokbo;
}
