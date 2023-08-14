package fr.tenisu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.tenisu.backend.domain.PlayerData;

@Repository
public interface PlayerDataRepository extends JpaRepository<PlayerData, Long>{

	 @Query("SELECT AVG(p.height) FROM PlayerData p")
	 Double calculateAverageHeight();
	 
	 @Query("SELECT AVG((p.weight/1000) / (p.height / 100.0 * p.height / 100.0)) FROM PlayerData p")
	 Double calculateAverageIMC();
	 
}
