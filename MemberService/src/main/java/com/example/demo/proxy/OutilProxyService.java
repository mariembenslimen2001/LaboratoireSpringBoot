package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.OutilBean;

@FeignClient(name = "OUTILSERVICE")
public interface OutilProxyService {

    @GetMapping("/outils/{id}")
    public OutilBean findOutil(@PathVariable(name="id") Long id) ;
}
