
/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 2, 2022
**/

/**
 * @author jake
 *
 */

import java.util.List;
import java.util.Scanner;

import Controller.StandHelper;
import Model.Stand;

public class StartStandProgram {

	static Scanner in = new Scanner(System.in);
	static StandHelper sh = new StandHelper();

	private static void addAStand() {
		// TODO Auto-generated method stub
		System.out.print("Enter a stand name: ");
		String name = in.nextLine();

		System.out.print("Enter stand type: ");
		String type = in.nextLine();

		System.out.print("Enter stand status: ");
		String openStatus = in.nextLine();

		System.out.print("Enter stand starting cash: ");
		Double startCash = in.nextDouble();

		Stand toAdd = new Stand(name, type, startCash, openStatus);
		sh.insertStand(toAdd);

	}

	private static void deleteAStand() {
		// TODO Auto-generated method stub
		System.out.print("Enter the stand to delete: ");
		String name = in.nextLine();

		System.out.print("Confirm Stand Type: ");
		String type = in.nextLine();

		System.out.print("Confirm Stand Status: ");
		String openStatus = in.nextLine();

		System.out.print("Confirm Stand Starting Cash: ");
		Double startCash = in.nextDouble();

		Stand toDelete = new Stand(name, type, startCash, openStatus);

		String confirm = in.nextLine();
		sh.deleteStand(toDelete);
	}

	private static void editAStand() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Type");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Stand> foundStand;
		if (searchBy == 1) {
			System.out.print("Enter the stand name: ");
			String standName = in.nextLine();
			foundStand = sh.searchForStandByName(standName);

		} else {
			System.out.print("Enter the type: ");
			String standType = in.nextLine();
			foundStand = sh.searchForStandByType(standType);

		}
		// there is no reason to search for stand using the other two criteria
		if (!foundStand.isEmpty()) {
			System.out.println("Found Results.");
			for (Stand s : foundStand) {
				System.out.println(s.getID() + " : " + s.toString());
			}
			System.out.print("Which stand to edit: ");
			int standToEdit = in.nextInt();

			Stand toEdit = sh.searchForStandById(standToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getType() + toEdit.getStartCash()
					+ toEdit.getOpen());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Type");
			System.out.println("3 : Update Starting Cash");
			System.out.println("4 : Update Status");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Store: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Type: ");
				String newType = in.nextLine();
				toEdit.setType(newType);
			} else if (update == 3) {
				System.out.print("New Starting Cash: ");
				Double newCash = in.nextDouble();
				toEdit.setStartCash(newCash);
			} else if (update == 4) {
				System.out.print("New Status: ");
				String newStat = in.nextLine();
				toEdit.setOpen(newStat);
			}

			sh.updateStand(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to Stand Monitoring Program - SMP ---");
		while (goAgain) {
			System.out.println("*  Select an Option:");
			System.out.println("*  1 -- Add a Stand");
			System.out.println("*  2 -- Edit a Stand");
			System.out.println("*  3 -- Delete a Stand");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit SMP");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAStand();
			} else if (selection == 2) {
				editAStand();
			} else if (selection == 3) {
				deleteAStand();
			} else if (selection == 4) {
				viewTheList();
			} else {
				sh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Stand> allItems = sh.showAllStands();
		for (Stand singleItem : allItems) {
			System.out.println(singleItem.returnStandDetails());
		}

	}

}
