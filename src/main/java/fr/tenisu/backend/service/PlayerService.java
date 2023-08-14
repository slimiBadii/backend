package fr.tenisu.backend.service;

import java.util.List;
import java.util.Optional;

import fr.tenisu.backend.domain.Country;
import fr.tenisu.backend.domain.Player;
import fr.tenisu.backend.model.SatisticalDto;

public interface PlayerService {

	List<Player> findAllPlayers();

	List<Player> findAllByOrderByDataRankAsc();

	List<Player> findAllByOrderByDataPointsDesc();

	Optional<Player> findById(Long id);

	void save(List<Player> players);

	Double calculateAverageHeight();

	Double calculateAverageIMC();
	
	String findCountryWithHighestRatio();
	
	SatisticalDto  getSatistical();
}
