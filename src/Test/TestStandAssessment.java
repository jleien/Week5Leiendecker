/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Jan 16, 2022
**/
package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Stand;
import Model.StandAssessment;


/**
 * @author jake
 *
 */
public class TestStandAssessment{
	StandAssessment StandA = new StandAssessment();
	Stand stand = new Stand(1, "NEBrand", "Concessions - Popcorn", 500, "Open");
	//this is the stand my brother or I run at ISU Mens BB games
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testStartCashGood() {
		stand.setStartCash(500);
		double cashReturn = StandA.needCash(stand);
		assertEquals(0, cashReturn, 0.0);
	}
	
	@Test
	public void testStartCashTooMuch() {
		stand.setStartCash(700);
		double cashReturn = StandA.needCash(stand);
		assertEquals(-200, cashReturn, 0.0);
	}
	
	@Test
	public void testStartCashTooLittle() {
		stand.setStartCash(300);
		double cashReturn = StandA.needCash(stand);
		assertEquals(200, cashReturn, 0.0);
	}
	
	@Test 
	public void standsNeedAName() {
		assertNotNull(stand.getName());
	}
	
	@Test
	public void standsNeedToBeOpen() {
		assertTrue(StandA.checkIfOpen(stand));
	}


}
