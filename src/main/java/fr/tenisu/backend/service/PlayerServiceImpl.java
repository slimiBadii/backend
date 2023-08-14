package fr.tenisu.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.tenisu.backend.domain.Country;
import fr.tenisu.backend.domain.Player;
import fr.tenisu.backend.repository.PlayerDataRepository;
import fr.tenisu.backend.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private final PlayerRepository playerRepository;
	private final PlayerDataRepository playerDataRepository;
	
    public PlayerServiceImpl(PlayerRepository playerRepository,PlayerDataRepository playerDataRepository) {
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
	public Double calculateMedianHeight() {
		return playerDataRepository.calculateMedianHeight();
	}

	@Override
	public Double calculateAverageBMI() {
		return playerDataRepository.calculateAverageBMI();
	}

	@Override
	public Country findCountryWithHighestRatio() {
		return playerRepository.findCountryWithHighestRatio();
	}
}
