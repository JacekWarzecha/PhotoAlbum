package pl.devopsi.akademia.photo82;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comment")

public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String postDate;
    private String content;


    @ManyToOne
    private Photo photo;

}
