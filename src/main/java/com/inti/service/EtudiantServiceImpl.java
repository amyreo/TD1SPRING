package com.inti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

import com.inti.HibernateUtil;
import com.inti.Model.Etudiant;

public class EtudiantServiceImpl implements EtudiantService {

	@Override
	public List<Etudiant> getEtudiants() {
		List<Etudiant> listeEtudiants = new ArrayList<>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		listeEtudiants = session.createSQLQuery("select * from etudiant").addEntity(Etudiant.class).list();

		session.getTransaction().commit();
		return listeEtudiants;
	}

	@Override
	public Etudiant getEtudiant(int id) {
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("Précisez l'identifiant de l'étudiant à retourner");
//		int idE = scan.nextInt();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Etudiant rs = session.get(Etudiant.class, id);

//		Query query = session.createSQLQuery("select * from etudiant where id = ?").addEntity(Etudiant.class);
//		query.setParameter(1, id);
//		query.executeUpdate();
//		Etudiant rs = (Etudiant) query.getResultList().get(0);

		session.getTransaction().commit();
		return rs;
	}

	@Override
	public void saveEtudiant() {
		Scanner scan = new Scanner(System.in);
		Etudiant etu;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Entrez le numéro d'étudiant");
		int id = scan.nextInt();
		System.out.println("Entrez le nom de l'étudiant");
		String nom = scan.next();
		System.out.println("Entrez le prénom de l'étudiant");
		String prenom = scan.next();
		System.out.println("Entrez le téléphone de l'étudiant");
		String tel = scan.next();
		System.out.println("Entrez l'email de l'étudiant");
		String email = scan.next();

		Query query = session.createSQLQuery("insert into etudiant values (?,?,?,?,?)");
		query.setParameter(1, id);
		query.setParameter(2, nom);
		query.setParameter(3, prenom);
		query.setParameter(4, tel);
		query.setParameter(5, email);
		query.executeUpdate();
		System.out.println("Etudiant inséré");

		session.getTransaction().commit();
	}

	@Override
	public void deleteEtudiant() {
		Scanner scan = new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println("Entrez le numéro de l'étudiant à supprimer");
		int id = scan.nextInt();
		Query query = session.createSQLQuery("delete from etudiant where id = ?");
		query.setParameter(1, id);
		query.executeUpdate();
		System.out.println("Etudiant supprimé");
		
		session.getTransaction().commit();

	}

}
