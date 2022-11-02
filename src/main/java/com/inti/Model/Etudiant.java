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
public class Etudiant {
	@Id
	private int id;
	private String nom;
	private String prenom;
	private String tel;
	private String mail;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Etudiant_Professeur", joinColumns = @JoinColumn(name = "Etudiant"), inverseJoinColumns = @JoinColumn(name = "Professeur"))
	private List<Professeur> professeur;

	public Etudiant(int id, String nom, String prenom, String tel, String mail) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
	}

	public Etudiant() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public List<Professeur> getProfesseur() {
		return professeur;
	}

	public void setProfesseur(List<Professeur> professeur) {
		this.professeur = professeur;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", mail=" + mail + "]";
	}

}
