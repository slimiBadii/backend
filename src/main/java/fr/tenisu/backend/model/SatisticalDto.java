package fr.tenisu.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SatisticalDto {
	
private String highestRatioContryCode ;
private double averageHeight;
private double averageImc;


}
