package com.example.demo.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entities.Publication;


@RepositoryRestController
@RestResource

public interface PublicationRepository extends JpaRepository<Publication, Long> {

	public List<Publication> findByTitreStartingWith(String titre);
    public List<Publication> findByTitre(String titre);
    public List<Publication> findByType(String type);
    List<Publication> findByDateBetween(Date date1, Date date2);
	

}
