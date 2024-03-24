package lv.euso.hockeystats.repository;

import lv.euso.hockeystats.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
