package Controller;
/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 22, 2022
**/

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Event;



/**
 * @author jake
 *
 */
public class EventHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CIS175Week2Leiendecker");

	public void insertNewEvent(Event e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Event> showAllEvents(){
		EntityManager em = emfactory.createEntityManager();
		List<Event> allDetails = em.createQuery("SELECT e FROM Event e").getResultList();
		return allDetails;
	}

	public Event searchForEventById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Event found = em.find(Event.class, tempId);
		em.close();
		return found;
	}

	public void deleteEvent(Event eventToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Event> typedQuery = em.createQuery("SELECT detail from Event detail where detail.id= :selectedId", Event.class);
		typedQuery.setParameter("selectedId", eventToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		Event result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateEvent(Event toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}