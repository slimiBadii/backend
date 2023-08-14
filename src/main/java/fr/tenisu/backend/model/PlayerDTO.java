package fr.tenisu.backend.model;

import lombok.Data;

@Data
public class PlayerDTO {
	private int id;
	private String firstname;
	private String lastname;
	private String shortname;
	private String sex;
	private CountryDTO country;
	private String picture;
	private PlayerDataDTO data;
}
