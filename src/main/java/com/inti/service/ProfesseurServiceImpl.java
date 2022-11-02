package com.inti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

import com.inti.HibernateUtil;
import com.inti.Model.Etudiant;
import com.inti.Model.Professeur;

public class ProfesseurServiceImpl implements ProfesseurService {

	@Override
	public List<Professeur> getProfesseurs() {
		List<Professeur> listeProfesseurs = new ArrayList<>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		listeProfesseurs = session.createSQLQuery("select * from professeur").addEntity(Professeur.class).list();

		session.getTransaction().commit();
		return listeProfesseurs;
	}

	@Override
	public String getProfesseur() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Précisez l'identifiant du professeur à retourner");
		int idP = scan.nextInt();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createSQLQuery("select * from professeur where idP = ?");
		query.setParameter(1, idP);
		query.executeUpdate();
		String rs = query.getResultList().get(0).toString();

		session.getTransaction().commit();
		return rs;
	}

	@Override
	public void saveProfesseur() {
		Scanner scan = new Scanner(System.in);
		Professeur prof;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Entrez l'identifiant du professeur");
		int idP = scan.nextInt();
		System.out.println("Entrez le nom du professeur");
		String nom = scan.next();
		System.out.println("Entrez le prénom du professeur");
		String prenom = scan.next();
		System.out.println("Entrez le salaire du professeur");
		double sal = scan.nextDouble();

		Query query = session.createSQLQuery("insert into professeur values (?,?,?,?)");
		query.setParameter(1, idP);
		query.setParameter(2, nom);
		query.setParameter(3, prenom);
		query.setParameter(4, sal);
		query.executeUpdate();
		System.out.println("Professeur inséré");

		session.getTransaction().commit();

	}

	@Override
	public void deleteProfesseur() {
		Scanner scan = new Scanner(System.in);
		Professeur prof;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println("Entrez l'identifiant du professeur à supprimer");
		int idP = scan.nextInt();
		Query query = session.createSQLQuery("delete from professeur where idP = ?");
		query.setParameter(1, idP);
		query.executeUpdate();
		System.out.println("Professeur supprimé");

		session.getTransaction().commit();

	}

}
