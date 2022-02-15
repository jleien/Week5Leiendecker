/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Jan 16, 2022
**/
package Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.AllTests;

/**
 * @author jake
 *
 */
public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestStandAssessment.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
	
	
}
