package Controller;
/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 22, 2022
**/

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.StandManager;



/**
 * @author jake
 *
 */
public class StandManagerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CIS175Week2Leiendecker");

	public void insertStandManager(StandManager s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<StandManager> showAllStandManagers(){
		EntityManager em = emfactory.createEntityManager();
		List<StandManager> allStandManagers = em.createQuery("SELECT sm from StandManager sm").getResultList();
		return allStandManagers;
	}
	
	public StandManager findStandManager(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<StandManager> typedQuery = em.createQuery("select smh from StandManager smh where smh.managerName = :selectedName",StandManager.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		StandManager foundStandManager;
		try {
			foundStandManager = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundStandManager = new StandManager(nameToLookUp);
		}
		em.close();

		return foundStandManager;
	}
}
