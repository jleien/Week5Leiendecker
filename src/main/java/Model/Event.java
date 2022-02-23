/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 22, 2022
**/
package Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author jake
 *
 */
@Entity
public class Event {
	@Id
	@GeneratedValue
	private int id;
	private String eventType;
	private LocalDate eventDate;
	@ManyToOne (cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private StandManager standManager;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Stand> listOfStands;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(int id, String eventType, LocalDate eventDate, StandManager standManager, List<Stand> listOfStands) {
		super();
		this.id = id;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.standManager = standManager;
		this.listOfStands = listOfStands;
	}
	public Event(String eventType, LocalDate eventDate, StandManager standManager, List<Stand> listOfStands) {
		super();
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.standManager = standManager;
		this.listOfStands = listOfStands;
	}
	public Event(String eventType, LocalDate eventDate, StandManager standManager) {
		super();
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.standManager = standManager;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public StandManager getStandManager() {
		return standManager;
	}
	public void setStandManager(StandManager standManager) {
		this.standManager = standManager;
	}
	public List<Stand> getListOfStands() {
		return listOfStands;
	}
	public void setListOfStands(List<Stand> listOfStands) {
		this.listOfStands = listOfStands;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventType=" + eventType + ", eventDate=" + eventDate + ", standManager=" + standManager
				+ ", listOfStands=" + listOfStands + "]";
	}

}
