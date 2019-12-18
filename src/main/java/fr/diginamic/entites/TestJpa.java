package fr.diginamic.entites;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.Compte;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();

//		TypedQuery<Emprunt> query = em.createQuery("select e from Emprunt e where e.id=1", Emprunt.class);
//		Emprunt emprunt = query.getResultList().get(0);
//		Set<Livre> livres = emprunt.getLivres();
//		for (Livre l : livres) {
//			System.out.println(l);
//		}
//
//		TypedQuery<Emprunt> query2 = em.createQuery("select e from Emprunt e where e.client.nom='Brigand'",
//				Emprunt.class);
//		Emprunt emprunt1 = query2.getResultList().get(0);
//		System.out.println(emprunt1);

		Compte compte= new Compte();
		compte.setNumero("012345");
		compte.setSolde(2500.0);
		em.persist(compte);
		
		Client client = new Client();
		client.setNom("Chameau");
		client.setPrenom("Lolo");
		em.persist(client);
		
		em.close();
		entityManagerFactory.close();
	}

}
