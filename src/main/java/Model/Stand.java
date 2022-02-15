/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Jan 16, 2022
**/
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jake
 *
 */
@Entity
@Table(name = "stands")
public class Stand {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "STARTCASH")
	private double startCash;
	@Column(name = "OPENSTATUS")
	private String open;

	public Stand() {
		setID(0);
		setName("Unassigned");
		setType("Empty Stand");
		setStartCash(0);
		setOpen("Closed");
	}

	public Stand(int ID, String name, String type, double startCash, String open) {
		setID(ID);
		setName(name);
		setType(type);
		setStartCash(startCash);
		setOpen(open);
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getStartCash() {
		return startCash;
	}

	public void setStartCash(double startCash) {
		this.startCash = startCash;
	}

	public Stand(String name, String type, Double startCash, String open) {
		this.name = name;
		this.type = type;
		this.startCash = startCash;
		this.open = open;
	}

	public String returnStandDetails() {
		return this.name + ": " + this.type + this.startCash + this.open;
	}
}
