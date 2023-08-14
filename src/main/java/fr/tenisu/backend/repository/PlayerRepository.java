package fr.tenisu.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.tenisu.backend.domain.Country;
import fr.tenisu.backend.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findAllByOrderByDataRankAsc();

	List<Player> findAllByOrderByDataPointsDesc();

	@Query("SELECT p.country.code FROM Player p WHERE (SUM(unnest(p.data.last)) * 1.0) / SIZE(p.data.last) = (SELECT MAX((SUM(pp.data.last) * 1.0) / SIZE(pp.data.last)) FROM Player pp)")
	String findCountryWithHighestRatio();
}
