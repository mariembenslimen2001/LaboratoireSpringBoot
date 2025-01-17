package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OutilRestController {

	@Autowired
    IOutilService outilService; // Use the Outil service interface.

	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public List<Outil> findOutils() {
		return outilService.findAll();
	}

	@GetMapping(value = "/tools/{id}")
	public Outil findOneMemberById(@PathVariable Long id) {
		return outilService.findOutil(id);
	}

	@PostMapping(value = "/tools/create")
	public Outil addOutil(@RequestBody Outil p) {
		return outilService.addOutil(p);
	}

	@DeleteMapping(value = "/tools/{id}/delete")
	public void deleteOutil(@PathVariable Long id) {
		outilService.deleteOutil(id);
	}

	@PutMapping(value = "/tools/{id}/update")
	public Outil updateOutil(@PathVariable Long id, @RequestBody Outil p) {
		p.setId(id);
		return outilService.updateOutil(p);
	}
}
