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
@DiscriminatorValue("URL_TYPE")
@Getter
@NoArgsConstructor
public class UrlCommit extends StudyCommit {
    private String url;

    @Builder
    public UrlCommit(Long id, Date summitDate, User user, Study study, String url) {
        super(id, summitDate, user, study);
        this.url = url;
    }
}
