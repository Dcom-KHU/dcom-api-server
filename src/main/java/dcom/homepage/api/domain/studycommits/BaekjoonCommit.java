package dcom.homepage.api.domain.studycommits;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;


@Entity
@DiscriminatorValue("BAEKJOON_TYPE")
@Getter
@NoArgsConstructor
public class BaekjoonCommit extends StudyCommit {
    @Column(nullable = false)
    private Integer problemNo;

    @Builder
    public BaekjoonCommit(Long id, Date summitDate, User user, Study study, Integer problemNo) {
        super(id, summitDate, user, study);
        this.problemNo = problemNo;
    }
}
