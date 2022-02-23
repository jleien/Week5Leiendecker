/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 22, 2022
**/
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jake
 *
 */
@Entity
@Table(name = "standmanager")
public class StandManager {
	@Id
	@GeneratedValue
	private int id;
	private String managerName;

	public StandManager() {
		super();
	}

	public StandManager(int id, String managerName) {
		super();
		this.id = id;
		this.managerName = managerName;
	}

	public StandManager(String managerName) {
		super();
		this.managerName = managerName;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getmanagerName() {
		return managerName;
	}

	public void setmanagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return "manager [id=" + id + ", managerName=" + managerName + "]";
	}
}
