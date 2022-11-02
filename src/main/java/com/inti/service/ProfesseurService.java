package com.inti.service;

import java.util.List;

import com.inti.Model.Professeur;


public interface ProfesseurService {
	
	
	public List<Professeur> getProfesseurs();
	
	public String getProfesseur();
	
	public void saveProfesseur();
	
	public void deleteProfesseur();
}
