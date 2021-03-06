import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


class mainFile {

	public static boolean choiceValidator(String rawChoice, int start, int end) {

		int choice;

		try {
			choice=Integer.parseInt(rawChoice);

			if (choice>=start && choice<=end) {
				return true;
			}
			else {
				throw new java.lang.RuntimeException();
			}
		}

		catch(Exception e) {
			return false;
		}
		//return false;
	}

	public static boolean addRecords() {
		System.out.print("\033\143");

		System.out.println("Choose from the following options:");
		System.out.println("1. Add a new patient.");
		System.out.println("2. Add a new medicine.");

		Scanner read = new Scanner(System.in);
		
		String rawChoice=read.nextLine();
		//int choice=4;

		boolean validEntry=choiceValidator(rawChoice,1,2);

		while (!validEntry) {

			validEntry=choiceValidator(rawChoice,1,2);

			if (validEntry) {
				break;
			}

			System.out.println("Invalid input. Try again.");
			rawChoice=read.nextLine();
		}

		// boolean validEntry=choiceValidator(rawChoice,1,2);

		// while (!validEntry) {
		// 	rawChoice=read.nextLine();
		// 	validEntry=choiceValidator(rawChoice,1,2);
		// }

		int choice=Integer.parseInt(rawChoice);

		if (choice==1) {
			System.out.println("Enter the patient name:");
			String name=read.nextLine();

			System.out.println("Enter the problem:");
			String problem=read.nextLine();

			System.out.println("Enter contact number:");
			String contactNumber=read.nextLine();

			patient p=new patient(name,problem,contactNumber);

			try {
				FileOutputStream f=new FileOutputStream(new File("patients.txt"));
				ObjectOutputStream o=new ObjectOutputStream(f);

				o.writeObject(p);

				o.close();
				f.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found");
			} 

			catch (IOException e) {
				System.out.println("Error initializing stream");
			} 

			// catch (ClassNotFoundException e) {
			// 	// TODO Auto-generated catch block
			// 	e.printStackTrace();
			// }
		}

		else if (choice==2) {
			System.out.println("Enter the medicine name:");
			String name=read.nextLine();

			System.out.println("Enter the type:");
			String type=read.nextLine();

			System.out.println("Enter stock quantity:");
			int stockQty=read.nextInt();
			read.nextLine();

			medicine m=new medicine(name,type,stockQty);
		}

		read.close();

		return true;
	}

	public static boolean updateRecords() {
		System.out.print("\033\143");
		return true;
	}

	public static boolean displayRecords() {
		System.out.print("\033\143");

		System.out.println("Choose from the following options:");
		System.out.println("1. View the patients' list.");
		System.out.println("2. View the medicine list.");

		Scanner read = new Scanner(System.in);
		
		String rawChoice=read.nextLine();
		//int choice=4;

		boolean validEntry=choiceValidator(rawChoice,1,2);

		while (!validEntry) {

			validEntry=choiceValidator(rawChoice,1,2);

			if (validEntry) {
				break;
			}

			System.out.println("Invalid input. Try again.");
			rawChoice=read.nextLine();
		}

		// boolean validEntry=choiceValidator(rawChoice,1,2);

		// while (!validEntry) {
		// 	rawChoice=read.nextLine();
		// 	validEntry=choiceValidator(rawChoice,1,2);
		// }

		int choice=Integer.parseInt(rawChoice);

		if (choice==1) {

			try {
				FileInputStream fi=new FileInputStream(new File("patients.txt"));
				ObjectInputStream oi=new ObjectInputStream(fi);

				patient p=(patient) oi.readObject();

				System.out.println(p.toString());

				oi.close();
				fi.close();

			}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		else if (choice==2) {

		}

		read.close();
		return true;
	}

	public static void main(String[] args) {

		System.out.println("Welcome to the Clinic Management System. Press enter key to proceed.");

		Scanner read = new Scanner(System.in);
		
		read.nextLine();
		System.out.print("\033\143"); //to clear the console (for Linux only)

		System.out.println("Choose any of the options below:");
		System.out.println("1. Add records.");
		System.out.println("2. Update records");
		System.out.println("3. Display records.");

		//boolean validEntry=false;
		String rawChoice=read.nextLine();
		//int choice=4;

		boolean validEntry=choiceValidator(rawChoice,1,3);

		while (!validEntry) {

			validEntry=choiceValidator(rawChoice,1,3);

			if (validEntry) {
				break;
			}

			System.out.println("Invalid input. Try again.");
			rawChoice=read.nextLine();
		}
			// System.out.println(validEntry);

			// try {

			// 	rawChoice=read.nextLine();
			// 	choice=Integer.parseInt(rawChoice);

			// 	//read.nextLine();
				
			// 	if (choice>=1 && choice<=3) {
			// 		validEntry=true;
			// 	}
			// 	else {
			// 		// System.out.println("Enter a valid input. Please try again.");
			// 		// continue;
			// 		throw new java.lang.RuntimeException();

			// 	}

			// }

			// catch(Exception e) {
			// 	System.out.println("Enter a valid input. Please try again.");
			// 	//read.nextLine(); // I don't know how but this fixes the infinite loop I was getting on inputting a letter.
			// 	continue;
			// }

		
		int choice=Integer.parseInt(rawChoice);

		switch(choice) {
			case 1: //add records
			boolean ans=addRecords();
			if (ans) {
				System.out.println("Record added successfully.");
			}

			break;

			case 2: //update records
			;
			break;

			case 3: //display records
			boolean ans2=displayRecords();
			break;

			default: //somehow choice got affected
			;
		}

		read.close();

		System.out.println("--EOP--");

	}
}