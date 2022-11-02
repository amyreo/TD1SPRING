package com.inti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.Model.Professeur;
import com.inti.service.ProfesseurService;
import com.inti.service.ProfesseurServiceImpl;

@RestController
public class ProfesseurController {

	@RequestMapping(value = "/listeprofesseurs")
	public List<Professeur> getProfesseurs() {
		ProfesseurService is = new ProfesseurServiceImpl();
		return is.getProfesseurs();
	}

	@RequestMapping(value = "/soloprofesseur")
	public String getProfesseur() {
		ProfesseurService is = new ProfesseurServiceImpl();
		return is.getProfesseur();
	}

	@RequestMapping(value = "/saveprofesseur")
	public void saveProfesseur() {
		ProfesseurService is = new ProfesseurServiceImpl();
		is.saveProfesseur(); 
	}

	@RequestMapping(value = "/deleteprofesseur")
	public void deleteProfesseur() {
		ProfesseurService is = new ProfesseurServiceImpl();
		is.deleteProfesseur();
	}

}
