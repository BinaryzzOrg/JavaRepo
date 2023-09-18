import java.util.Scanner;

public class PrelimLabExercise2 {

	// create object of Scanner
	static Scanner sc = new Scanner(System.in);
	// global integer array used for later
	static int[] array;
	/*
	 * constant variables used to print warnings, provide the title and print
	 * operations
	 */
	final static String[] NOTICE_MSG = { "Choose if the user hasn't initialized an array",
			"DISABLED (Clear changes first to initialized again",
			" (It will only leave an \"X\" sign when you view it)" };
	final static String PROGRAM_TITLE = "Welcome to Java Array Operations";
	final static String[] PRINT_OPERATIONS = { "INITIALIZE", "REMOVE", "DISPLAY", "INSERT", "COMPRESS",
			"CLEAR ALL CHANGES", "EXIT PROGRAM" };
	// boolean flags
	static boolean repeatProcess = false;
	static boolean disableOneChoice = false;

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
				}
			}
			System.out.println("Please Choose An Operation:");

			userPrompt = sc.nextInt();
			// check if user already input between 1-7 ranges
			for (int i = 1; i <= blueprint.length; i++) {
				if (userPrompt == i) {
					passed = true;
					break;
				}
			}

			if (!passed) {
				System.out.println("Please type from 1-6 only!!!");
			}

		}
		return userPrompt;
	}
	/*
	 * Method to send a warning before checking the other CRUD operations returns a
	 * true or false value
	 */

	public static void Initialized_First() {

		/*
		 * kay Landicho change it from void to boolean magrereturn ng true or false if
		 * di pa initialized also send a warning message
		 */

	}

	public static void ClearAllChanges() {

		/*
		 * kay reyes
		 *
		 */

	}

	/*
	 * Method to locate index has a parameter of an integer array and an integer for
	 * the target element returns the index if found, else, returns -1
	 */

	public static void IndexLocate() {

		/*
		 * return current and search index (change void) gagamitin sa remove operation
		 * lagyan ng target int na parameter return the index if found if not return -1
		 */

	}

	/*
	 * Method to initialized array has a parameter of an integer array ask the user
	 * to input the size
	 */
	public static void Initialized() {
		/*
		 * kay nilberto ask si user ng size then get all user input elements magrereturn
		 * ng array which is ung initialized na (change ung void)
		 */

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

		// Call the DisplayArray method to display the content of the arrays
		DisplayArray();

	}// end method

	/*
	 * Method to remove an element from the array has a parameter of an integer
	 * array ask the user to input the select which element to remove by asking the
	 * index
	 */

	public static void RemoveArray() {

		/*
		 * kay saymo ask si user kung ano tatangalin used the indexLocate ni nadela then
		 * provide notice na imbis ireremove literally is magforformat ng X which means
		 * vacated use yung notice_Msg na array index 2 if nagremove is just replace the
		 * value of the removed to -1
		 *
		 *
		 */

	}
	/*
	 * Method to display the current state of elements in the array has a parameter
	 * of an integer array prints an "X" format when an index is vacated
	 */

	public static void DisplayArray() {

		/*
		 * kay cristopher display sa array pwedeng may parameter or just called the
		 * array variable na static check muna kung yung Initialized code ni nilbert is
		 * nagbabalik ng new initialized int[] array prints ng X pag -1 yung value ng
		 * element which is mababago sa remove method ni saymo
		 */

	}

	/*
	 * Method to insert an element in the array locates which index is vacated
	 * {deleted} insert the user preferred input there
	 */

	public static void InsertElement(int[] array) {

		sc = new Scanner(System.in);

		for (int index = 0; index < array.length; index++) {
			if (array[index] == -1) {
				System.out.println("Enter element to be inserted: ");
				break;
			} // end if
		} // end for loop

		/*
		 * kay nadela and nilbert ask ano iinput condition check if -1 si value then
		 * palitan ung -1 value ng na ask na value
		 *
		 */

	}

	/*
	 * Shift element to left-side checks if array had a vacated index
	 */

	public static void CompressElementtoLeft() {

		/*
		 * reyes and saymo pwede recursive method or diff algo
		 *
		 *
		 */

	}
	/*
	 * Prompts user to continues if not the program will be terminated
	 */

	public static void AskUserToContinue() {

		/*
		 * kay landicho and cristopher ask the user if uulit loop if invalid response
		 *
		 */

	}

	/*
	 * Method to properly make a condition between operations has a parameter of an
	 * integer for checking the input of user uses the method Initialized_First upon
	 * checking if array is not initialized first
	 */

	public static void Operation_Type(int input) {
		switch (input) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:
			System.out.println("Exiting Program!!!");
			System.exit(0);
			break;

		}

	}

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
			}
			// continue looping until boolean flag becomes true
		} while (!repeatProcess);

	}

}// end class
