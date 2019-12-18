package defaut;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque_TP2");
		EntityManager em = entityManagerFactory.createEntityManager();

		Livre livre = em.find(Livre.class, 1);
		if (livre != null) {
			System.out.println(livre);
		}

		TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.titre='Germinal'", Livre.class);
		Livre livre2 = query2.getResultList().get(0);
		System.out.println(livre2);
		em.close();
		entityManagerFactory.close();
	}

}
