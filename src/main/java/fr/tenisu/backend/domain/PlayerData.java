package fr.tenisu.backend.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "data")
@Data
public class PlayerData{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private int rank;
    private int points;
    private int weight;
    private int height;
    private int age;
    private List<Integer> last;
}