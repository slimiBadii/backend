package fr.tenisu.backend.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.tenisu.backend.domain.Country;
import fr.tenisu.backend.domain.Player;
import fr.tenisu.backend.exception.DataNotFoundException;
import fr.tenisu.backend.model.PlayersData;
import fr.tenisu.backend.model.SatisticalDto;
import fr.tenisu.backend.service.PlayerService;
import lombok.extern.slf4j.Slf4j;

@RestController(value = "/api")
@Slf4j
public class PlayerController {

	
	@Value("${dataNotFound}")
	private String dataNotFound;
	
	private final PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	/**
	 * Get all Teams in the data store.
	 *
	 * @return all Teams in the data store
	 */
	@GetMapping(value = "/players/rank")
	public Collection<Player> getAllPlayersByRank() {
		return playerService.findAllByOrderByDataRankAsc();
	}

	@GetMapping(value = "/players/points")
	public Collection<Player> getAllPlayersByPoints() {
		return playerService.findAllByOrderByDataPointsDesc();
	}
	
	@GetMapping(value = "/players/avg/heigth")
	public Double calculateAverageHeight() {
		return playerService.calculateAverageHeight();
	}

	@GetMapping(value = "/players/avg/imc")
	public Double calculateAverageBMI() {
		return playerService.calculateAverageIMC();
	}

	
	
	@GetMapping(value = "/players/statistic")
	public SatisticalDto searchStatistic() {
		
		return playerService.getSatistical();
	}

	
	@GetMapping(value = "/players/pipeline")
	public String test() {
		return "test pipeline";
	}

	/**
	 * Get the Team with the given key.
	 *
	 * @param key the key of the Team to find
	 * @return the Team with the given key
	 * @throws DataNotFoundException 
	 */
	@GetMapping(value = "/player/{id}")
	public Player getByKey(@PathVariable(value = "id") Long key) throws DataNotFoundException {
		Optional<Player> player = playerService.findById(key);
		if (player.isPresent()) {
			return player.get();
		}
			
		 throw new DataNotFoundException(dataNotFound);
	}

	@GetMapping(value = "/import/json")
	public void importJson() throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		
		File file = ResourceUtils.getFile("classpath:headtohead.json");
		log.info("File can read {}",file.canRead());
		PlayersData players = objectMapper.readValue(file, PlayersData.class);
		playerService.save(players.getPlayers());
		log.info("Players {} ",players);
	}
}