package lv.euso.hockeystats.repository;

import lv.euso.hockeystats.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
