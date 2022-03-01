package dcom.homepage.api.domain.group;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "tech_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)
    private String imageName;

    @Column(nullable = false)
    private String imageUri;
}
