package pl.devopsi.akademia.photo82;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Photo")
public class Photo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String privacy;
    private String upLoaderName;
    private String upLoaderPhoneNum;
    private String email;
    private String address;
    private String view;

    @OneToOne(mappedBy ="photo", cascade = CascadeType.ALL)
    private UpLoadHistory upLoadHistory;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @ManyToOne(cascade = CascadeType.ALL)
    private Album album;

    @ManyToMany(cascade =CascadeType.ALL)
    private Set<Tag>tags;


}
