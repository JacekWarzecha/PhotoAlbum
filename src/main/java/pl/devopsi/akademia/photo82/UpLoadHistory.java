package pl.devopsi.akademia.photo82;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="UpLoadHistory")
public class UpLoadHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Date date;


    @OneToOne
    private Photo photo;

}
