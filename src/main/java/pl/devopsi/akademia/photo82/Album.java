package pl.devopsi.akademia.photo82;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="album")

public class Album {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String Description;
    private String view;

    @OneToMany(mappedBy="album", cascade=CascadeType.ALL)
    private Set<Photo> photos;



}
