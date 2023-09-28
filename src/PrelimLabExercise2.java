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
												"[1]INITIALIZED (not recommended)",
												"(It will only leave an \"X\" sign when you view it)",
												"Shifting remaining elements in left side...", "{Nothing to Compress here!}" };

	final private static String PROGRAM_TITLE = "Welcome to Java Array Operations";
	final private static String[] PRINT_OPERATIONS = { "INITIALIZE", "REMOVE", "DISPLAY", "INSERT",
													"COMPRESS", "EXIT PROGRAM" };
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

	public static void MenuDriven(String[] blueprint, boolean disableOneChoice) {

		System.out.println("\tOPERATIONS");
		for (int i = 0; i < blueprint.length; i++) {
			if (i == 0 && !disableOneChoice) {
				System.out.println("\t=>" + "[" + (i + 1) + "]" + blueprint[i] + " (" + NOTICE_MSG[i] + ")");
				// if true disables the first operation
			} else if (i == 0 && disableOneChoice) {
				System.out.println("\t=>" + NOTICE_MSG[i + 1]);
			} else {
				System.out.println("\t=>" + "[" + (i + 1) + "]" + blueprint[i]);
			} // end if else
		} // end for
		System.out.print("Please Choose An Operation: ");
		Operation_Type();
	}// end method

	public static void ClearAllChanges() {

		// boolean flag indicate if array is switch back to null again
		boolean Deleted = false;
		// store input variable
		int clearPrompt;
		// while boolean is false
		while (!Deleted) {
			// prompt query
			System.out.print("You sure to clear all your changes?\n" + "[1] Clear it" + "\n[0] I Change my mind\n:");
			// collects user input
			clearPrompt = sc.nextInt();
			// if equals to 1 then array will be null, boolean flag become true, disable the
			// initialize choice will be false again
			if (clearPrompt == 1) {
				Deleted = true;
				disableOneChoice = false;
				array = null;
				// else terminate the operation and go back to main menu
			} else if (clearPrompt == 0) {
				System.out.println("Going back to Main Menu...\n");
				MenuDriven(PRINT_OPERATIONS, disableOneChoice);
				Deleted = true;
			} // end if else
		} // end for
	}// end method

	/*
	 * Method to initialized array has a parameter of an integer array ask the user
	 * to input the size
	 */

	public static void Initialized() {

		// ask user to Enter the size of array
		System.out.print("Enter size of the array: ");

		int size = sc.nextInt();

		// Create an array of the specified size
		array = new int[size];
		// Loop to iterate over each index of the array
		for (int index = 0; index < size; index++) {
			System.out.print("Enter element at index " + index + ": ");
			// Read an element and store it at the current index
			array[index] = sc.nextInt();
		} // end for

		System.out.println();
	}// end method

	/*
	 * Method to remove an element from the array has a parameter of an integer
	 * array ask the user to input the select which element to remove by asking the
	 * index
	 */

	public static void RemoveElements(int[] remove) {

		// ask user to enter the index
		System.out.print("\nEnter the index you want to removed: ");
		int indexRemove = sc.nextInt();
		// if index out of bounds send error message
		if (indexRemove > remove.length - 1 || indexRemove < 0) {
			System.out.println("{Invalid index!! Index does not exist!}");
			RemoveElements(remove);
		} else {// if index is valid
			// if index value is vacant or empty print error message
			if (remove[indexRemove] == -1) {
				System.out.println("{There's no value to be deleted!} \n");
			} else {// if index value is not empty
				// make the index empty
				remove[indexRemove] = -1;
				// display message
				System.out.println("\nElement at index [" + indexRemove + "] was successfully deleted!");
				System.out.println(NOTICE_MSG[2] + "\n");
			} // end if else
		} // end if else
	}// end method

	/*
	 * Method to display the current state of elements in the array has a parameter
	 * of an integer array prints an "X" format when an index is vacated
	 */

	public static void DisplayArray(int[] display, int counter) {

		// prints header msg
		System.out.println("Displaying Elements...");
		// print indeces label

		System.out.println();
		// print the elements label
		System.out.print("Elements: ");
		// for each loop to print the array prints an X if element is vacated
		for (int element : display) {
			// if vacant
			if (element == -1) {
				// print "{X}"
				System.out.print("{X}");
			} else {
				System.out.print("{" + element + "}");

			} // end if
		} // end for loop

		// newLine
		System.out.println();

		System.out.print("Indeces:  ");
		// prints the corresponding indices of elements
		for (int i = 0; i < display.length; i++) {
			System.out.print("[" + i + "]");
		} // end for loop
			// newLine
		System.out.println("\n");
	}// end method

	/*
	 * Method to insert an element in the array locates which index is vacated
	 * {deleted} insert the user preferred input there
	 */

	public static void InsertElement(int[] array) {

		// store user input
		sc = new Scanner(System.in);

		boolean IsArrayFull = true;
		// iterate the array
		for (int index = 0; index < array.length; index++) {

			if (array[index] == -1) {
				System.out.print("\nEnter element to be inserted: ");
				array[index] = sc.nextInt();
				System.out.println("Element successfully inserted! \n");
				IsArrayFull = false;
				break;
			} // end if
		} // end for loop

		// detect that array is full
		if (IsArrayFull) {
			System.out.println("{Array is full!}\n");
		} // end if
	}// end method

	/*
	 * // Method to provide a position of index where the non-negative element to be
	 * placed also to shift rest of negative value to right
	 */

	public static void Shift_CompressElem(int[] array, int NonNegIndex) {

		// validates if there's needing to compress
		if (CheckIf_NoCompress(array, 0)) {
			System.out.println("{Please remove some elements in order to compress!}\n");
		} else {

			// loop through array
			for (int i = 0; i < array.length; i++) {
				// check if element is greater than -1
				if (array[i] > -1) {

					// swap non-negative to the nonNegVal variable
					int temp = array[i];
					array[i] = array[NonNegIndex];
					array[NonNegIndex] = temp;
					// increment nonNegVal to position next non-negative element
					NonNegIndex++;
				} // end if
			} // end for

			// prints message indicate compression process is complete
			System.out.println(NOTICE_MSG[3]);
			// print shifted elements
			DisplayArray(array, 0);
		} // end if else
	}// end method

	/*
	 * check if all values are not vacated provides warning message
	 */

	public static boolean CheckIf_NoCompress(int[] array, int pos_Elem) {

		// loop to validate and collect counter of positive values
		for (int i = 0; i < array.length; i++) {
			if (array[i] != -1) {
				pos_Elem++;
			}
		}
		// if reaches the array size
		if (pos_Elem == array.length) {
			// prints msg
			System.out.println(NOTICE_MSG[4]);
			// return no vacant (true)
			return true;
		} // end if

		// there's vacant
		return false;
	}// end method

	/*
	 * Method to properly make a condition between operations has a parameter of an
	 * integer for checking the input of user uses the method Initialized_First upon
	 * checking if array is not initialized first
	 */

	public static void Operation_Type() {

		boolean inputValid = false;
		while (!inputValid) {
			String user_Choice = sc.nextLine();
			switch (user_Choice) {
			case "1":
				if (disableOneChoice) {
					ClearAllChanges();
				} else {
					Initialized();
					disableOneChoice = true;
				}
				MenuDriven(PRINT_OPERATIONS, disableOneChoice);
				inputValid = true;
				break;
			case "2":
				OperationErrorMsg(2);
				break;
			case "3":
				OperationErrorMsg(3);
				break;
			case "4":
				OperationErrorMsg(4);
				break;
			case "5":
				OperationErrorMsg(5);
				break;
			case "6":
				System.out.println("Exiting Program...");
				System.exit(0);
				break;
			case "":
				Operation_Type();
			default:
				System.out.println("{Please type from 1-6 only!}");
				Operation_Type();
				break;
			}// end switch
		} // end while
	}// end method

	/*
	 * Method to get the user input and use a specific algorithm assigned to each
	 * input choice
	 */

	public static boolean OperationErrorMsg(int choice) {
		String errorMsg = "{Initialized First!}\n";
		if (disableOneChoice && choice == 2) {
			RemoveElements(array);
		} else if (disableOneChoice && choice == 3) {
			DisplayArray(array, 0);
		} else if (disableOneChoice && choice == 4) {
			InsertElement(array);
		} else if (disableOneChoice && choice == 5) {
			Shift_CompressElem(array, 0);
		} else {
			System.out.println(errorMsg);
		} // end if else
		MenuDriven(PRINT_OPERATIONS, disableOneChoice);
		return true;
	}// end method

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
	}// end method
}// end class