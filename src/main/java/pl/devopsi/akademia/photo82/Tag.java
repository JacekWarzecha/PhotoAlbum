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
@Table(name="tag")
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;


    @ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
    private Set<Photo> photos;


}
