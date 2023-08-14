package fr.tenisu.backend.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "player")
@Data
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String shortname;
	private String sex;
	@OneToOne(cascade = CascadeType.ALL)
	private Country country;
	private String picture;
	@OneToOne(cascade = CascadeType.ALL)
	private PlayerData data;
}
