package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Stand;

/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 2, 2022
**/

/**
 * @author jake
 *
 */

public class StandHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CIS175Week2Leiendecker");

	public void insertStand(Stand sl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(sl);
		em.getTransaction().commit();
		em.close();
	}

	public List<Stand> showAllStands() {
		EntityManager em = emfactory.createEntityManager();
		List<Stand> allItems = em.createQuery("SELECT i FROM Stand i").getResultList();
		return allItems;

	}

	public void deleteStand(Stand toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Stand> typedQuery = em.createQuery(
				"SELECT s FROM Stand s WHERE s.name = :selectedName AND s.type = :selectedType", Stand.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedType", toDelete.getType());

		typedQuery.setMaxResults(1);
		Stand result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Stand searchForStandById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Stand found = em.find(Stand.class, idToEdit);
		em.close();
		return found;
	}

	public void updateStand(Stand toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Stand> searchForStandByName(String standName) {
//			TODO	Auto-generated	method	stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Stand> typedQuery = em.createQuery("select s from Stand s where s.name=:selectedName", Stand.class);
		typedQuery.setParameter("selectedName", standName);

		List<Stand> foundItems = typedQuery.getResultList();
		em.close();

		return foundItems;
	}

	public List<Stand> searchForStandByType(String standType) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Stand> typedQuery = em.createQuery("select s from Stand s where s.type=:selectedType", Stand.class);
		typedQuery.setParameter("selectedType", standType);

		List<Stand> foundItems = typedQuery.getResultList();
		em.close();

		return foundItems;
	}

	public void cleanUp() {
		emfactory.close();
	}
}