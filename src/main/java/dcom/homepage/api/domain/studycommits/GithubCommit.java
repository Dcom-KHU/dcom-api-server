package dcom.homepage.api.domain.studycommits;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("GITHUB_TYPE")
@Getter
@NoArgsConstructor
public class GithubCommit extends StudyCommit {

    @Builder
    public GithubCommit(Long id, Date summitDate, User user, Study study) {
        super(id, summitDate, user, study);
    }
}
