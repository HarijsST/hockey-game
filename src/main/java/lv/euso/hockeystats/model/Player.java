package lv.euso.hockeystats.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Players")
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamID")
    private Team team;
    private String name;
    private String lastName;
    private int overall;
}
