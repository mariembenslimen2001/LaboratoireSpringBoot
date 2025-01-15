package com.example.demo.proxy;

import com.example.demo.beans.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interface proxy pour la gestion des publications.
 */
@FeignClient(name = "publication-service", url = "${publication.service.url}")
public interface PublicationProxyService {

    /**
     * Récupère une publication par son identifiant.
     *
     * @param id l'identifiant de la publication.
     * @return une publication correspondante.
     */
    @GetMapping("/publications/{id}")
    PublicationBean getPublicationById(@PathVariable("id") Long id);
}