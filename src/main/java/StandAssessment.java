/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Jan 16, 2022
**/


import Model.Stand;

/**
 * @author jake
 *
 */
public class StandAssessment {
	
	
	public boolean checkIfOpen(Stand stand) {
		if (stand.getOpen() == "Open") {
			return true;
		} else {
			return false;
		}

	}
	
	public double needCash(Stand stand) {
		double cashReturn = 0;
		double cash = 0;
		cash = stand.getStartCash();
		if(stand.getStartCash()==500) {
			 cashReturn = 0;
			//500 is a good amount of bills to open a register. 
		}else {
			cashReturn = 500 - cash;
			//you shouldn't start a stand with more than 500. it throws ending count off
		}
		return cashReturn;
	}
}
