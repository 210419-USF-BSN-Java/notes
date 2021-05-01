package com.revature;

// imports package/classes from a different location
// java.util.* => can use * to import everything in a package
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		/*
		 * System.out.println("Please enter a sentence:"); String input = sc.nextLine();
		 * // reads the entire line
		 * 
		 * System.out.println("You entered: " + input);
		 * 
		 * String[] words = input.split(" ");
		 * 
		 * for(String s: words) { System.out.println(s); }
		 * 
		 * System.out.println("Please enter an integer:"); int x = sc.nextInt(); // Only
		 * reading part of the input, the next .nextLine() grabs the leftover input
		 * 
		 * System.out.println("You entered " + x); sc.nextLine(); // grabbing the
		 * leftover
		 * 
		 * int y = Integer.parseInt(sc.nextLine()); System.out.println("You entered " +
		 * y);
		 * 
		 * System.out.println("Please enter your name: "); String name = sc.nextLine();
		 * 
		 * System.out.println("Your name is: " + name);
		 */

		/*
		 * TODO Implement a menu that has multiple options: (Want to loop back to main
		 * menu until application is exited out of) - returns a number - returns hello -
		 * exits the application
		 */

		int x = 0;
		do {
			System.out.println("Please enter a number 1-3: ");
			x = Integer.parseInt(sc.nextLine());
			switch (x) {
			case 1:
				System.out.println("Here is a random number " + Math.random());
				break;
			case 2:
				System.out.println("Hello");
				break;
			case 3:
				System.out.println("Thanks! Bye!");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (x != 3);
		
		// Close scanner pls.
		sc.close();
	}

}
