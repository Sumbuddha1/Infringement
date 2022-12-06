
//Sumbuddha Bhandari
//18875209
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assesment2Demo_18875209 {
	static Scanner kb = new Scanner(System.in);
	static ArrayList<Driver_18875209> D = new ArrayList<Driver_18875209>();
	static float totalRev;
	static int demeritP;
	static int suspendNum;
	static boolean suspend;
	static int totalinfig;
	static String changes;

	/*
	 * This is the main method where the program is executing
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice;
		int i = 0;

		/*
		 * this is the program for the option 1
		 */
		try {
			File inFile = new File("Driver.txt");
			Scanner inputFile = new Scanner(inFile);
			String str;

			String[] tokens;
			ArrayList<Driver_18875209> D = new ArrayList<Driver_18875209>();
			menu();
			choice = userChoice();
			while (inputFile.hasNext()) {
				str = inputFile.nextLine();
				tokens = str.split(",");
				D.add(new Driver_18875209(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5],
						Integer.parseInt(tokens[7]), tokens[8]));// this is the driver object
			}
			/*
			 * loop for the main manue
			 */
			while (choice <= 5) {
				if (choice == 5)// if else statement that execute according to user choice
				{
					char chose;
					System.out.println("Changes will be lost do you still want to quit. \n Please answer in y or n ");
					chose = kb.next().charAt(0);

					while (chose != 'y' && chose != 'n') {
						System.out.println("Please answer in y or n");
						chose = kb.next().charAt(0);
					}
					if (chose == 'y') {
						System.exit(1);
					}
				} else if (choice == 1) {
					printDrivers(D);
				}else if (choice == 2) {
					applyPenalty(D);
					System.out.println("the total revenue from fines correctly applied to drivers " + totalRev);
					System.out.println("total License suspended are " + suspendNum);
					System.out.println("Total number of infringements are " + totalinfig);
				} else if (choice == 3) {
					System.out.println("Suspended License: ");
					System.out.println("           ");
					for (i = 0; i < D.size(); i++) {
						if ("Suspended".equals(D.get(i).getLicenceStatus())) {
							System.out.println("License Number:" + D.get(i).getLicenceNum());
							System.out.println("First Name:" + D.get(i).getFirstName());
							System.out.println("Last Name:" + D.get(i).getLastName());
							System.out.println("Suburb:" + D.get(i).getSuburb());
							System.out.println("Demerit Points:" + D.get(i).getDemeritPoints());
							System.out.println("Licence Status:" + D.get(i).getLicenceStatus());
							System.out.println("===========================");
						}
					}
				} else {

				}
				menu();
				choice = userChoice();
			}
			// System.out.println(D.size());
			inputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	/*
	 * this method displays the values of Driver file in appropriate format
	 */
	public static void printDrivers(ArrayList<Driver_18875209> D) {
		for (int j = 0; j < D.size(); j++) {
			for (int i = D.get(j).getDemeritPoints(); i >= 0; i--) {
				System.out.println("License Number:" + D.get(i).getLicenceNum());
				System.out.println("First Name:" + D.get(i).getFirstName());
				System.out.println("Last Name:" + D.get(i).getLastName());
				System.out.println("Suburb:" + D.get(i).getSuburb());
				System.out.println("Demerit Points:" + D.get(i).getDemeritPoints());
				System.out.println("Licence Status:" + D.get(i).getLicenceStatus());
				System.out.println("===========================");
			}
		}
	}

	/*
	 * this is the method that shows the total number of infringements and pass the
	 * value in int return type
	 */
	public static int totalInfrig(String infFile) {
		int totalinfig = 0;
		try {
			File infragFile = new File(infFile);
			Scanner nextFile = new Scanner(infragFile);
			String stri;
			String checkFile[];
			while (nextFile.hasNext()) {
				stri = nextFile.nextLine();
				checkFile = stri.split(",");
				totalinfig = Integer.parseInt(checkFile[0]);
			}
			nextFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return totalinfig;
	}

	/*
	 * This is the method which reades the data from infringements files it also
	 * compare the licenses in driver and Infringements file which will provide link
	 * between two files
	 */
	public static void applyPenalty(ArrayList<Driver_18875209> D) {
		String infFile;

		int infrag = 0;
		infFile = importInfringement();
		int excesspeed;
		int[] nextexcess = SpeedingPenalty_18875209.getExcessSpeed();
		int[] dmPoint = SpeedingPenalty_18875209.getDemeritPoints();
		float[] fine = SpeedingPenalty_18875209.getFine();
		boolean[] suspension = SpeedingPenalty_18875209.getLicenceSuspension();
		int i = 0;
		totalinfig = totalInfrig(infFile);
		try {
			File infragFile = new File(infFile);
			Scanner nextFile = new Scanner(infragFile);
			String stri;
			String checkFile[];

			while (nextFile.hasNext()) {
				stri = nextFile.nextLine();
				checkFile = stri.split(",");
				for (i = 0; i < D.size(); i++) {
					if (Integer.parseInt(D.get(i).getLicenceNum()) == Integer.parseInt(checkFile[1])) {
						excesspeed = Integer.parseInt(checkFile[3]);
						demeritP = D.get(i).getDemeritPoints();
						calculation(excesspeed, nextexcess, dmPoint, fine, suspension);
					}
				}
			}
			nextFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

	/*
	 * This method does the calculation to find out the revenue, dimerites points
	 * and suspension report
	 */
	public static void calculation(int exsped, int speed[], int point[], float fine[], boolean suspence[]) {
		boolean suspens;
		byte ind;
		if (exsped > speed[0] && exsped < speed[1]) {
			ind = SpeedingPenalty_18875209.findPenaltyIndex(exsped);
			totalRev = totalRev + fine[ind];
			demeritP = demeritP + point[ind];
			suspens = suspence[ind];
		} else if (exsped > speed[1] && exsped < speed[2]) {
			ind = SpeedingPenalty_18875209.findPenaltyIndex(exsped);
			totalRev = totalRev + fine[ind];
			demeritP = demeritP + point[ind];
			suspens = suspence[ind];
		} else if (exsped > speed[2] && exsped < speed[3]) {
			ind = SpeedingPenalty_18875209.findPenaltyIndex(exsped);
			totalRev = totalRev + fine[ind];
			demeritP = demeritP + point[ind];
			suspens = suspence[ind];
		} else if (exsped > speed[3] && exsped < speed[4]) {
			ind = SpeedingPenalty_18875209.findPenaltyIndex(exsped);
			totalRev = totalRev + fine[ind];
			demeritP = demeritP + point[ind];
			suspens = suspence[ind];
		} else {
			ind = SpeedingPenalty_18875209.findPenaltyIndex(exsped);
			totalRev = totalRev + fine[ind];
			demeritP = demeritP + point[ind];
			suspens = suspence[ind];
		}
		if (demeritP >= 13 || suspens == true) {
			suspendNum = suspendNum + 1;
			// suspend=true;
			for (int i = 0; i < D.size(); i++) {
				System.out.println(D.get(i).getFirstName());
			}
		}
	}

	/*
	 * this method ask from user to provide infringements file
	 */
	public static String importInfringement() {
		String str;
		System.out.println("Please enter the infringement file that you want to be imported");
		str = kb.next();
		return str;

	}

	/*
	 * this method shows users the main menu option to choose from
	 */
	public static void menu() {
		System.out.println(
				"\n1. Display Drivers\n2. Import Infringement File\n3. Generate Suspension Report\n4. Save Driver Records\n5. Exit Program");
	}

	/*
	 * Use of this method enables users to choose form the main menu
	 */
	public static int userChoice() {
		int choice;
		System.out.println("\nEnter Your Choice:");// user input for the choice
		choice = kb.nextInt();
		while (choice > 6 || choice < 1)// validates the choice to be between 1 to 4
		{
			System.out.println("ERROR. Choice should be between 1 to 5 Please try again:  ");
			choice = kb.nextInt();
		}
		return choice;
	}

}
