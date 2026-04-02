package com.example.Cibo.model;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface RicettaRepository extends JpaRepository<Ricetta,Integer>{
	
	@Query("SELECT P FROM Ricetta P WHERE P.portata = :estraiPortata")
	List<Ricetta> findRicettaByPortata(@Param("estraiPortata") String estraiPortata);
	
	@Modifying
	@Transactional
	@Query("UPDATE Ricetta P SET P.giorno = NULL, P.pasto = NULL")
	void deletePrepMeal();
	
	@Modifying
	@Transactional
	@Query("UPDATE Ricetta P SET P.giorno = :estraiGiorno, P.pasto = :estraiPasto WHERE P.progRicetta = :estraiProgRicetta")
	void updatePrepMealById(@Param("estraiGiorno") String estraiGiorno, @Param("estraiPasto") String estraiPasto, @Param("estraiProgRicetta") int estraiProgRicetta);

}
