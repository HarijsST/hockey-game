package lv.euso.hockeystats.repository;

import lv.euso.hockeystats.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
