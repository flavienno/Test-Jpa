package fr.diginamic.entites;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.Adresse;
import fr.diginamic.banque.Banque;
import fr.diginamic.banque.Client;
import fr.diginamic.banque.Compte;
import fr.diginamic.banque.Operation;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();

		Banque banque = new Banque();
		banque.setNom("Centrale");
		em.persist(banque);

		Compte compte = new Compte();
		compte.setNumero("012345");
		compte.setSolde(2500.0);
		em.persist(compte);

		Client client = new Client();
		client.setNom("Chameau");
		client.setPrenom("Lolo");
		client.setDateNaissance(LocalDate.of(2006, 03, 8));
		Adresse adresse = new Adresse(2, "rue de la poste", "Montpellier", 34000);
		client.setAdresse(adresse);
		client.setBanque(banque);
		client.getComptes().add(compte);
		em.persist(client);

		Operation operation = new Operation();
		operation.setDate(LocalDate.of(2019, 12, 18));
		operation.setMontant(3500.0);
		operation.setMotif("Etrennes");
		operation.setCompte(compte);
		em.persist(operation);

		et.commit();
		em.close();
		entityManagerFactory.close();
	}

}
