import java.util.Scanner;

public class PrelimLabExercise2 {
	// create object of Scanner
	static Scanner sc = new Scanner(System.in);
	// global integer array used for later
	static int[] array;
	final static String[] NOTICE_MSG = { "Choose if the user hasn't initialized an array",
			"DISABLED (Clear changes first to initialized again)",
			" (It will only leave an \"X\" sign when you view it)" };
	final static String PROGRAM_TITLE = "Welcome to Java Array Operations";
	final static String[] PRINT_OPERATIONS = { "INITIALIZE", "REMOVE", "DISPLAY", "INSERT", "COMPRESS",
			"CLEAR ALL CHANGES", "EXIT PROGRAM" };
	// boolean flags
	static boolean repeatProcess = false;
	static boolean disableOneChoice = false;

	public static void MenuDriven(String[] blueprint, boolean disableOneChoice) {

		System.out.println("\tOPERATIONS");
		for (int i = 0; i < blueprint.length; i++) {
			if (i == 0 && !disableOneChoice) {
				System.out.println("\t=>" + "[" + (i + 1) + "]" + blueprint[i] + " (" + NOTICE_MSG[i] + ").");
				// if true disables the first operation
			} else if (i == 0 && disableOneChoice) {
				System.out.println("\t=>" + NOTICE_MSG[i + 1]);
			} else {
				System.out.println("\t=>" + "[" + (i + 1) + "]" + blueprint[i]);
			}
		}
		System.out.println("Please Choose An Operation:");
		Operation_Type();
	}

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
				System.out.println("Going back to Main Menu!!!");
			}

		}
	}

	public static void Initialized() {

		// ask user to Enter the size of array
		System.out.print("Enter the size of the array: ");
		int size = sc.nextInt();
		// Create an array of the specified size
		array = new int[size];

		// Loop to iterate over each index of the array
		for (int index = 0; index < size; index++) {
			System.out.print("Enter element at index " + index + ": ");
			// Read an element and store it at the current index
			array[index] = sc.nextInt();
		}
		System.out.println();

	}// end method

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
		}
		System.out.println();

	}

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
			}
		}
		// newline
		System.out.println("\n");
	}

	public static void InsertElement(int[] array) {

		sc = new Scanner(System.in);
		for (int index = 0; index < array.length; index++) {
			if (array[index] == -1) {
				System.out.println("Enter element to be inserted: ");
				array[index] = sc.nextInt();
				System.out.println("Element successfully inserted!");
				// *call display array here*
				break;
			} // end if

			System.out.println("Array is full!");

			// these are changes in testBranch
			System.out.println("test only branch");
		} // end for loop
	}// end method

	public static void Shift_CompressElem(int[] array) {
		// boolean flag if swaps are made during loop
		boolean valid = false;
		// provides as a position of index guide where the non-negative element to be
		// placed
		int nonNegVal = 0;
		// compression process, stops if there's no swap
		do {
			// loop through array
			for (int i = 0; i < array.length; i++) {
				// check if element is greater than -1
				if (array[i] > -1) {
					// swap non-negative to the nonNegVal variable
					int temp = array[i];
					array[i] = array[nonNegVal];
					array[nonNegVal] = temp;
					// increment nonNegVal to position next non-negative element
					nonNegVal++;
				}
			}
			// set to true, indicates complete pass or looping
			valid = true;
			// continue until the swapping stops
		} while (!valid);

		// prints message indicate compression process is complete
		System.out.println("Done compressing!!!");

	}

	public static void AskUserToContinue() {

		/*
		 * Prompts user to continues if not the program will be terminated
		 */
		/*
		 * kay landicho and cristopher ask the user if uulit loop if invalid response
		 *
		 */

	}

	public static void Operation_Type() {

		boolean inputValid = false;
		while (!inputValid) {
			String user_Choice = sc.nextLine();
			switch (user_Choice) {
			case "1":
				if (disableOneChoice) {
					System.out.println("Already Initialized!\n");
				} else {
					Initialized();
					disableOneChoice = true;
				}
				MenuDriven(PRINT_OPERATIONS, disableOneChoice);
				inputValid = true;
				break;
			case "2":
				if (disableOneChoice) {
					RemoveElements(array);
				} else {
					System.out.println("Initialized First!");
				}
				MenuDriven(PRINT_OPERATIONS, disableOneChoice);
				inputValid = true;
				break;
			case "3":
				if (disableOneChoice) {
					DisplayArray(array);
				} else {
					System.out.println("Initialized First!");
				}
				MenuDriven(PRINT_OPERATIONS, disableOneChoice);
				inputValid = true;
				break;
			case "4":
				if (disableOneChoice) {
					break;
				}
				inputValid = true;
				break;
			case "5":
				if (disableOneChoice) {
					break;
				}

				Shift_CompressElem(array);
				inputValid = true;
				break;
			case "6":
				if (disableOneChoice) {
					break;
				}
				inputValid = true;
				break;
			case "7":
				System.out.println("Exiting Program!!!");
				System.exit(0);
				break;
			case "":
				Operation_Type();
			default:
				System.out.println("Please type from 1-7 only!!!");
				Operation_Type();
				break;
			}
		}

	}

	// Main Driver (Method)
	public static void main(String[] args) {
		System.out.println("**********\"" + PROGRAM_TITLE + "\"**********" + ""
				+ "\n******************************************************");

		// enable looping
		do {
			System.out.println();
			MenuDriven(PRINT_OPERATIONS, disableOneChoice);
			// continue looping until boolean flag becomes true
		} while (!repeatProcess);

	}

}// end class