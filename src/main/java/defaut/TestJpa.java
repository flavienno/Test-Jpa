package defaut;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque_TP2");
		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Emprunt> query = em.createQuery("select e from Emprunt e where e.id=1", Emprunt.class);
		Emprunt emprunt = query.getResultList().get(0);
		Set<Livre> livres = emprunt.getLivres();
		for (Livre l : livres) {
			System.out.println(l);
		}

		TypedQuery<Emprunt> query2 = em.createQuery("select e from Emprunt e where e.client.nom='Brigand'",
				Emprunt.class);
		Emprunt emprunt1 = query2.getResultList().get(0);
		System.out.println(emprunt1);

		em.close();
		entityManagerFactory.close();
	}

}
