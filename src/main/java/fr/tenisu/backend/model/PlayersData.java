package fr.tenisu.backend.model;

import java.util.List;

import fr.tenisu.backend.domain.Player;
import lombok.Data;

@Data
public class PlayersData {
	private List<Player> players;
}