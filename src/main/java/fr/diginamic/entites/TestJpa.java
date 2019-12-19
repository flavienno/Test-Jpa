package fr.diginamic.entites;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.Adresse;
import fr.diginamic.banque.AssuranceVie;
import fr.diginamic.banque.Banque;
import fr.diginamic.banque.Client;
import fr.diginamic.banque.Compte;
import fr.diginamic.banque.LivretA;
import fr.diginamic.banque.Operation;
import fr.diginamic.banque.Virement;

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

		AssuranceVie assuranceVie = new AssuranceVie();
		assuranceVie.setNumero("555555");
		assuranceVie.setSolde(2000.0);
		assuranceVie.setDateFin(LocalDate.of(2050, 01, 01));
		assuranceVie.setTauxAv(1.2);
		em.persist(assuranceVie);

		LivretA livretA = new LivretA();
		livretA.setNumero("111111");
		livretA.setSolde(4000.0);
		livretA.setTauxLa(0.5);
		em.persist(livretA);

		Client client = new Client();
		client.setNom("Chameau");
		client.setPrenom("Lolo");
		client.setDateNaissance(LocalDate.of(2006, 03, 8));
		Adresse adresse = new Adresse(2, "rue de la poste", "Montpellier", 34000);
		client.setAdresse(adresse);
		client.setBanque(banque);
		client.getComptes().add(compte);
		em.persist(client);

		Client client1 = new Client();
		client1.setNom("Chamelle");
		client1.setPrenom("Lala");
		client1.setDateNaissance(LocalDate.of(2000, 01, 01));
		Adresse adresse1 = new Adresse(3, "rue de la paix", "Montpellier", 34070);
		client1.setAdresse(adresse1);
		client1.setBanque(banque);
		client1.getComptes().add(compte);
		em.persist(client1);

		Client client2 = new Client();
		client2.setNom("Dromadaire");
		client2.setPrenom("Lili");
		client2.setDateNaissance(LocalDate.of(2001, 02, 02));
		Adresse adresse2 = new Adresse(4, "rue de la rose", "Sete", 34200);
		client2.setAdresse(adresse1);
		client2.setBanque(banque);
		client2.getComptes().add(assuranceVie);
		client2.getComptes().add(livretA);
		em.persist(client2);

		Operation operation = new Operation();
		operation.setDate(LocalDate.of(2019, 12, 18));
		operation.setMontant(3500.0);
		operation.setMotif("Etrennes");
		operation.setCompte(compte);
		em.persist(operation);

		Virement virement2 = new Virement();
		virement2.setMontant(234.0);
		virement2.setDate(LocalDate.of(2019, 11, 18));
		virement2.setMotif("Cadeaux");
		virement2.setCompte(compte);
		em.persist(virement2);

		et.commit();
		em.close();
		entityManagerFactory.close();
	}

}
