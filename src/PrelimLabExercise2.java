import java.util.Scanner;

public class PrelimLabExercise2 {

	// create object of Scanner
	private static Scanner sc = new Scanner(System.in);
	// global integer array used for later
	private static int[] array;
	/*
	 * constant variables used to print warnings, provide the title and print
	 * operations
	 */
//	@formatter:off
	final private static String[] NOTICE_MSG = { "Choose if the user hasn't initialized an array",
												"DISABLED (Clear changes first to initialized again",
												" (It will only leave an \"X\" sign when you view it)", 
												"jhifting remaining elements in left side...." };
	
	final private static String PROGRAM_TITLE = "Welcome to Java Array Operations";
	final private static String[] PRINT_OPERATIONS = { "INITIALIZE", "REMOVE", "DISPLAY", "INSERT",
													"COMPRESS", "CLEAR ALL CHANGES", "EXIT PROGRAM" };
//	@formatter:on
	// boolean flags
	private static boolean repeatProcess = false;
	private static boolean disableOneChoice = false;

	/*
	 * Method to PRINT the introductory of the program has a parameter of an String
	 * array and a boolean ask the user to input the size validates if user input
	 * really passes the 1-6 choices range handles exception if user input a
	 * non-match data type
	 */

	public static int MenuDriven(String[] blueprint, boolean disableOneChoice) {

		boolean passed = false;
		int userPrompt = 0;
		while (!passed) {
			System.out.println("**********\"" + PROGRAM_TITLE + "\"**********" + ""
					+ "\n******************************************************");
			System.out.println("\tOPERATIONS");

			for (int i = 0; i < blueprint.length; i++) {
				if (i == 0 && !disableOneChoice) {
					System.out.println("\t=>" + "[" + (i + 1) + "]" + blueprint[i] + " (" + NOTICE_MSG[i] + ").");
					// if true disables the first operation
				} else if (i == 0 && disableOneChoice) {
					System.out.println("\t=>" + NOTICE_MSG[i + 1]);
				} else {
					System.out.println("\t=>" + "[" + (i + 1) + "]" + blueprint[i]);
				} // end if else
			} // end for
			System.out.print("Please Choose An Operation: ");

			userPrompt = sc.nextInt();
			// check if user already input between 1-7 ranges
			for (int i = 1; i <= blueprint.length; i++) {
				if (userPrompt == i) {
					passed = true;
					break;
				} // end if
			} // end if

			if (!passed) {
				System.out.println("Please type from 1-6 only!!!");
			} // end if

		} // end while
		return userPrompt;
	}// end method

	/*
	 * Method to send a warning before checking the other CRUD operations returns a
	 * true or false value
	 */

	public static boolean Initialized_First() {

		// boolean flag to check if array is not initialized
		boolean notInitialized = false;

		// condition statement to verify if array is equal to null
		if (array == null) {
			// set to true
			notInitialized = true;
			// displays warnings
			System.out.println("Initialized array first!!!");
		} // end if
			// return boolean state
		return notInitialized;
	}// end method

	public static void ClearAllChanges(int[] array, boolean getDisable_Switch) {

		// boolean flag indicate if array is switch back to null again
		boolean Deleted = false;
		// store input variable
		int clearPrompt;
		// while boolean is false
		while (!Deleted) {
			// prompt query
			System.out.println("You sure to clear all your changes?\n" + "[1] Clear it" + "\n[0] I Change my mind");
			// collects user input
			clearPrompt = sc.nextInt();
			// if equals to 1 then array will be null, boolean flag become true, disable the
			// initialize choice will be false again
			if (clearPrompt == 1) {
				Deleted = true;
				getDisable_Switch = false;
				array = null;
				// else terminate the operation and go back to main menu
			} else if (clearPrompt == 0) {
				System.out.println("Heading back to Main Menu!!!");
			} // end if else
		} // end while loop
	}// end method

	/*
	 * Method to locate index has a parameter of an integer array and an integer for
	 * the target element returns the index if found, else, returns -1
	 */

	public static int IndexLocate(int[] array, int indexToLocate) {
		// return current and search index, used on remove operation

		// -1 default
		int temp = -1;

		// iterate to find index
		for (int index = 0; index < array.length; index++) {
			if (indexToLocate == array[index]) {
				return index;
			}
		} // end for

		return temp;
	}// end method

	/*
	 * Method to initialized array has a parameter of an integer array ask the user
	 * to input the size
	 */

	public static int[] Initialized() {

		// ask user to Enter the size of array
		System.out.print("Enter size of the array: ");

		int arraySize = sc.nextInt();

		// Create an array of the specified size
		array = new int[arraySize];

		for (int index = 0; index < array.length; index++) {

			// checks input
			System.out.print("Enter a number for index " + index + ": ");
			if (sc.hasNextInt()) {
				array[index] = sc.nextInt();
			} else {
				--index;
				System.out.println("{Enter only integer} \n");
				sc.next();
			} // end if else`
		} // end for

		return array;
	}// end method

	/*
	 * Method to remove an element from the array has a parameter of an integer
	 * array ask the user to input the select which element to remove by asking the
	 * index
	 */

	public static void RemoveElements(int[] remove) {

		System.out.print("Enter the index you want to removed\n: ");
		int indexRemove = sc.nextInt();

		if (indexRemove > remove.length - 1 || indexRemove < 0) {
			System.out.println("{Invalid index!! Index does not exist!}");
			RemoveElements(remove);
		} else {
			if (remove[indexRemove] == -1) {
				System.out.println("There's no value to be deleted!");
			} else {
				remove[indexRemove] = -1;
				System.out.println("Element at index [" + indexRemove + "] was successfully deleted!");
				System.out.println(NOTICE_MSG[2]);
			}
		} // end if else
	}// end method

	/*
	 * Method to display the current state of elements in the array has a parameter
	 * of an integer array prints an "X" format when an index is vacated
	 */

	public static void DisplayArray(int[] display) {

		// prints head message
		System.out.println("Current Elements: ");

		for (int i = 0; i < display.length; i++) {
			// if neg 1 it will print X
			if (display[i] == -1) {
				System.out.printf("[X]");
			} else {
				// else convert integer to string for printing purposes
				System.out.print("[" + Integer.toString(display[i]) + "]");
			} // end if else
		} // end for

		// newline
		System.out.println();
	}// end method

	/*
	 * Method to insert an element in the array locates which index is vacated
	 * {deleted} insert the user preferred input there
	 */

	public static void InsertElement(int[] array) {

		// store user input
		sc = new Scanner(System.in);

		// iterate the array
		for (int index = 0; index < array.length; index++) {
			if (array[index] == -1) {
				System.out.println("Enter element to be inserted: ");
				array[index] = sc.nextInt();
				System.out.println("Element successfully inserted!");

				// call to display array
				DisplayArray(array);
				break;
			} // end if

			System.out.println("Array is full!");
		} // end for loop
	}// end method

	/*
	 * Shift element to left-side checks if array had a vacated index preserves
	 * their relating order
	 */

	public static void Shift_CompressElem(int[] array, int startCollectNegValue) {

		// Prints message
		System.out.println(NOTICE_MSG[3]);
		// boolean flag if swaps are made during loop
		boolean complete_Pass = false;
		// compression process, stops if there's no swap
		do {
			// loop through array
			for (int i = 0; i < array.length; i++) {

				// check if element is greater than -1
				if (array[i] > -1) {

					// swap non-negative to the nonNegVal variable
					int temp = array[i];
					array[i] = array[startCollectNegValue];
					array[startCollectNegValue] = temp;
					// increment nonNegVal to position next non-negative element
					startCollectNegValue++;
				} // end if
			} // end for

			// set to true, indicates complete pass or looping
			complete_Pass = true;
			// continue until the swapping stops
		} while (!complete_Pass);

		// prints message indicate compression process is complete
		System.out.println("Done compressing!!!");
	}// end method

	/*
	 * Prompts user to continues if not the program will be terminated
	 */

	public static void AskUserToContinue() {

		// integer variable used for user response storing
		int proceed = 0;
		// boolean to determine when to stop looping
		boolean repeatUntilNoError = false;
		while (!repeatUntilNoError) {

			// prompt a query for user if want to continue
			System.out.println("Do you want to continue?\n[1]\n[0]:");

			// stores user response
			proceed = sc.nextInt();

			// if 1, stop loop and go back to main menu
			if (proceed == 1) {

				System.out.println("Going Back to the Main Menu!!!");
				repeatUntilNoError = true;
				// if 0 terminate the application
			} else if (proceed == 0) {

				System.out.println("Leaving the Application");
				System.exit(0);
			} else {

				// else invalid input then loop query again
				System.out.println("Invalid Input!!!");
			} // end else if
		} // end while
	}// end method

	/*
	 * Method to properly make a condition between operations has a parameter of an
	 * integer for checking the input of user uses the method Initialized_First upon
	 * checking if array is not initialized first
	 */

	public static void Operation_Type(int input) {

		switch (input) {
		case 1:

			Initialized();
			AskUserToContinue();
			break;
		case 2:
			if (Initialized_First()) {
				break;
			}

			RemoveElements(array);
			AskUserToContinue();
			break;
		case 3:
			if (Initialized_First()) {
				break;
			}

			DisplayArray(array);
			AskUserToContinue();
			break;
		case 4:
			if (Initialized_First()) {
				break;
			}

			InsertElement(array);
			AskUserToContinue();
			break;
		case 5:
			if (Initialized_First()) {
				break;
			}

			// calling compress element with parameter of an int array and a int primary
			// used for counter later
			Shift_CompressElem(array, 0);
			AskUserToContinue();
			break;
		case 6:
			if (Initialized_First()) {
				break;
			}

			ClearAllChanges(array, disableOneChoice);
			break;
		case 7:
			System.out.println("Exiting Program!!!");
			System.exit(0);
			break;
		default:
			System.out.println("Something went wrong in Operation_Type method");
			break;
		}// end switch
	}// end method

	// Main Driver (Method)
	public static void main(String[] args) {

		// enable looping
		do {
			// store user choice between operations and also calling the menuDriven method
			int user_Choice = MenuDriven(PRINT_OPERATIONS, disableOneChoice);
			Operation_Type(user_Choice);
			// condition to validate if input is 1
			if (user_Choice == 1) {
				/*
				 * disable the INITIALIZED operation for the next iteration of loop (Disable
				 * since the initialized choice will be redundant if user already created an
				 * array) Use the clear all changes button to enable the INITIALIZED operation
				 * again
				 */
				disableOneChoice = true;
			} // end if
				// continue looping until boolean flag becomes true
		} while (!repeatProcess);
	}// end method

}// end class