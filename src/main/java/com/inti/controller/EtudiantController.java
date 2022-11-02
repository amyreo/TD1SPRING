package com.inti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.Model.Etudiant;
import com.inti.service.EtudiantService;
import com.inti.service.EtudiantServiceImpl;

@RestController
public class EtudiantController {
	
	EtudiantService is = new EtudiantServiceImpl();
	
	@RequestMapping(value = "/listeetudiants")
	public List<Etudiant> getEtudiants() {
		return is.getEtudiants();
	}
	
	@RequestMapping(value = "/soloetudiant")
	public Etudiant getEtudiant(@RequestParam("id") int id) {
		return is.getEtudiant(id);
	}
	
	@RequestMapping(value = "/saveetudiant")
	public void saveEtudiant() {
		is.saveEtudiant();
	}
	
	@RequestMapping(value = "/deleteetudiant")
	public void deleteEtudiant() {
		is.deleteEtudiant();
	}
}
