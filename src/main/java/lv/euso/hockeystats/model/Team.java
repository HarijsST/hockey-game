package lv.euso.hockeystats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "Teams")
public class Team {
    @Id
    @GeneratedValue
    Long teamID;
    String name;
    int overall;
}
