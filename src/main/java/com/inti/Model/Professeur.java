package com.inti.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Professeur {
	@Id
	private int idP;
	private String nomP;
	private String prenomP;
	private double salaire;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Etudiant_Professeur", joinColumns = @JoinColumn(name = "Professeur"), inverseJoinColumns = @JoinColumn(name = "Etudiant"))
	private List<Etudiant> etudiant;

	public Professeur() {
		super();
	}

	public Professeur(int idP, String nomP, String prenomP, double salaire) {
		super();
		this.idP = idP;
		this.nomP = nomP;
		this.prenomP = prenomP;
		this.salaire = salaire;
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public String getPrenomP() {
		return prenomP;
	}

	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public List<Etudiant> getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "Professeur [idP=" + idP + ", nomP=" + nomP + ", prenomP=" + prenomP + ", salaire=" + salaire + "]";
	}

}
