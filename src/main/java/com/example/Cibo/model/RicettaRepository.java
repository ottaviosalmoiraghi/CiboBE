package com.example.Cibo.model;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RicettaRepository extends JpaRepository<Ricetta,Integer>{
	
	@Query("SELECT P FROM Ricetta P WHERE P.portata = :estraiPortata")
	List<Ricetta> findRicettaByPortata(@Param("estraiPortata") String estraiPortata);
	
	@Query("SELECT DISTINCT R FROM Ricetta R JOIN R.mealpreps m")
	List<Ricetta> findRicetteByWeek();

}
