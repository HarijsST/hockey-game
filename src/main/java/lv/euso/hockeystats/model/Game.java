package lv.euso.hockeystats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Games")
public class Game {
    @Id
    @GeneratedValue
    Long id;
    Long homeTeamID;
    Long awayTeamID;
    int homeScore;
    int awayScore;
}
