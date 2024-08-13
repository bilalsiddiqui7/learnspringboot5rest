package com.example.learnspringboot5rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnspringboot5rest.dao.AlienRepo;
import com.example.learnspringboot5rest.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo alienRepo;

	@GetMapping(value = "/aliens/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		Optional<Alien> alien = alienRepo.findById(aid);
		return alien;
	}

	@GetMapping(value = "/aliens")
	public List<Alien> getAllAliens() {
		return alienRepo.findAll();
	}

	@PostMapping(value = "/addalien", consumes = { "application/json" })
	public Alien addAlien(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}

	@PutMapping(value = "/updatealien")
	public Alien updateOrAddAlien(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}

	@DeleteMapping(value = "/deletealien")
	public String deleteAlien(@RequestBody Alien alien) {
		alienRepo.delete(alien);
		return "deleted";
	}

	@DeleteMapping(value = "/deletealien/{aid}")
	public String deleteAlienById(@PathVariable("aid") int aid) {
		Alien alien = alienRepo.getOne(aid);
		alienRepo.delete(alien);
		return "deleted";
	}
}
