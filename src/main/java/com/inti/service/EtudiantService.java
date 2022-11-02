package com.inti.service;

import java.util.List;

import com.inti.Model.Etudiant;

public interface EtudiantService {
	
	public List<Etudiant> getEtudiants();
	
	public Etudiant getEtudiant(int id);
	
	public void saveEtudiant();
	
	public void deleteEtudiant();

}
