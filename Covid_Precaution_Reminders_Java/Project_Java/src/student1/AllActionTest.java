package student1;

import java.util.Scanner;

public class AllActionTest {
	/*
   main class Load an array of Action objects of various types
   In this file, you are required to write code for your part Part 3. 
   The reason for this class is to demonstrate the Action class and subclasses.
   You must fill an array of action objects (hint: check the sample output file provided for you) with
   different action activities. A user of this system should be able to input a date of their choice and
   retrieve an output of all activities that would occur on that date.
   You should reuse the Action class and RegularAction classes from Part I of your solution
   and then the OccasionalAction and RareAction classes from your Part 2.
*/
	 
	public static void main(String[] args) {

		Action[] act = new Action[3];
		// Load an array of Action objects of various types
		act[0] = new RegularAction();
		act[1] = new OccasionalAction();
		act[2] = new RareAction();

		System.out.println("SAMPLE OUTPUT FOR PART 3");

		Scanner scanner = new Scanner((System.in));
		for (int x = 0; x < 4; x++) {
			int year, month, days; // declaration
			// prompt the user to enter
			System.out.print("Enter a date (like 2019 02 31): ");
			/**
			 * taking value of year,month and day respectively from user
			 */
			year = scanner.nextInt();
			month = scanner.nextInt();
			days = scanner.nextInt();
			System.out.println("These are your Actions on " + month + "/" + days + "/" + year + ":");

			/**
			 * printing Actions for user on the date entered by user..
			 */

			/**
			 * Using for loop starting from index 0 that will go all Actions and print them
			 */
			for (int index = 0; index < act.length; index++) {

				if (act[index].occursOn(year, month, days)) {

					// print the action index in to string

					System.out.println(act[index].toString());

				}
			}

		}

		scanner.close(); // closing scanner class
	}
}
