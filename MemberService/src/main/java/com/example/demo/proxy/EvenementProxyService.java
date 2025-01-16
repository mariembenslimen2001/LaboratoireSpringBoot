package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.EvenementBean;

@FeignClient(name = "EVENEMENT")
public interface EvenementProxyService {

    @GetMapping("/evenements/{id}")
    public EvenementBean findEvenementById(@PathVariable(name="id") Long id) ;
}
