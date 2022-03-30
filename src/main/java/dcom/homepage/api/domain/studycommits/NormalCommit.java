package dcom.homepage.api.domain.studycommits;

import dcom.homepage.api.domain.study.Study;
import dcom.homepage.api.domain.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("NORMAL_TYPE")
@Getter
@NoArgsConstructor
public class NormalCommit extends StudyCommit {

    private String text;

    public NormalCommit(Long id, Date summitDate, User user, Study study, String text) {
        super(id, summitDate, user, study);
        this.text = text;
    }
}
