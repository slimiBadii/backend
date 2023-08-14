package fr.tenisu.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.tenisu.backend.domain.Player;
import fr.tenisu.backend.model.SatisticalDto;
import fr.tenisu.backend.repository.PlayerDataRepository;
import fr.tenisu.backend.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	private final PlayerRepository playerRepository;
	private final PlayerDataRepository playerDataRepository;

	public PlayerServiceImpl(PlayerRepository playerRepository, PlayerDataRepository playerDataRepository) {
		this.playerRepository = playerRepository;
		this.playerDataRepository = playerDataRepository;
	}

	@Override
	public List<Player> findAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Optional<Player> findById(Long id) {
		return playerRepository.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(List<Player> players) {
		playerRepository.saveAll(players);
	}

	@Override
	public List<Player> findAllByOrderByDataRankAsc() {
		return playerRepository.findAllByOrderByDataRankAsc();
	}

	@Override
	public List<Player> findAllByOrderByDataPointsDesc() {
		return playerRepository.findAllByOrderByDataPointsDesc();
	}

	@Override
	public Double calculateAverageHeight() {
		return playerDataRepository.calculateAverageHeight();
	}

	@Override
	public Double calculateAverageIMC() {
		return playerDataRepository.calculateAverageIMC();
	}

	@Override
	public String findCountryWithHighestRatio() {
		return playerRepository.findCountryWithHighestRatio();
	}

	//@formatter:off
	@Override
	public SatisticalDto getSatistical() {
	
//		String code = playerRepository.findCountryWithHighestRatio();
		String code = null;

		return SatisticalDto.builder()
				.highestRatioContryCode(code)
				.averageHeight(playerDataRepository.calculateAverageHeight())
				.averageImc(playerDataRepository.calculateAverageIMC())
				.build();
	}
	//@formatter:on

}
