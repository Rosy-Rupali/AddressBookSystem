
/**************************************************
 * Purpose : Address Book System is used to manage book details
 * @author Rosy Rupali
 * @since 22-06-2021
 *
 *************************************************/

package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Person;

public class AddressBookMain {

	private static List<Person> personList = new ArrayList<>();// contains all person details

	/**
	 * to get all the list of contacts in one book
	 */
	public void getPersonList() {
		System.out.println(personList);
	}

	/**
	 * to remove person from list
	 *
	 * @param person object of Person class
	 */
	public static void deleteContact(Person person) {
		personList.remove(person);
		System.out.println(personList);
	}

	/**
	 * edits the person details of selected name
	 */
	public static void editDetails() {
		Scanner scanner = new Scanner(System.in);
		try (Scanner scanner1 = new Scanner(System.in)) {
			System.out.println("Select option:" + "\n" + "1.first name" + "\n" + "2.last name" + "\n" + "3.address"
					+ "\n" + "4.city" + "\n" + "5.state" + "\n" + "6.email" + "\n" + "7.zip" + "\n" + "8.phone number"
					+ "\n" + "9.exit");

			switch (scanner.nextInt()) {
			case 1:
				System.out.println("Enter first name to change: ");
				Person.setFIRST_NAME(scanner1.nextLine());
				break;
			case 2:
				System.out.println("Enter last name to change: ");
				Person.setLAST_NAME(scanner1.nextLine());
				break;
			case 3:
				System.out.println("Enter new address to change: ");
				Person.setADDRESS(scanner1.nextLine());
				break;
			case 4:
				System.out.println("Enter new city to change: ");
				Person.setCITY(scanner1.nextLine());
				break;
			case 5:
				System.out.println("Enter new state to change: ");
				Person.setSTATE(scanner1.nextLine());
				break;
			case 6:
				System.out.println("Enter new email to change: ");
				Person.setEMAIL(scanner1.nextLine());
				break;
			case 7:
				System.out.println("Enter new zip to change: ");
				Person.setZIP(scanner1.nextInt());
				break;
			case 8:
				System.out.println("Enter new phone number to change: ");
				Person.setPHONE_NUMBER(scanner1.nextLong());
				break;
			default:
				System.out.println("Thank you!");
			}
		}

		System.out.println(personList);
	}

	/**
	 * takes details from the user and adds them to the Person. Then adds the Person
	 * to the list
	 */
	public static void addContact() {
		Person person = new Person();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first name");
		Person.setFIRST_NAME(scanner.next());
		scanner.nextLine();
		System.out.println("Enter last name");
		Person.setLAST_NAME(scanner.next());
		scanner.nextLine();
		System.out.println("Enter address");
		Person.setADDRESS(scanner.next());
		scanner.nextLine();
		System.out.println("Enter city");
		Person.setCITY(scanner.next());
		scanner.nextLine();
		System.out.println("Enter state");
		Person.setSTATE(scanner.next());
		scanner.nextLine();
		System.out.println("Enter email");
		Person.setEMAIL(scanner.next());
		scanner.nextLine();
		System.out.println("Enter zip");
		Person.setZIP(scanner.nextInt());

		System.out.println("Enter phone number");
		Person.setPHONE_NUMBER(scanner.nextLong());

		personList.add(person);
		System.out.println(personList);
	}

	/**
	 * to access the book
	 */
	public void accessContact() {
		boolean isExit = false;
		while (!isExit) {
			System.out.println("Select option: \n1.Add Contact\n2.Edit Contact\n3.Delete Contact\n4.Exit");
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				if (!isPersonExist(getName())) {
					addContact();
				} else {
					System.out.println("Person already exists!");
				}
				break;
			case 2:
				if (isPersonExist(getName())) {
					editDetails();
				} else {
					System.out.println("Person does not exists!");
				}
				break;
			case 3:
				String name = getName();
				if (isPersonExist(name)) {
					Person person = search(name);
					deleteContact(person);
				}
				break;
			default:
				System.out.println("Thanks!");
				isExit = true;
			}

		}
	}

	/**
	 * asks the user for name and returns it
	 *
	 * @return person name
	 */
	private static String getName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter person name");
		return scanner.nextLine();
	}

	/**
	 * To find if person exists or not
	 *
	 * @param name first or last name of the person
	 * @return true/false
	 */
	private static boolean isPersonExist(String name) {
		return personList.stream().anyMatch(personElement -> personElement.getFIRST_NAME().equals(name)
				|| personElement.getLAST_NAME().equals(name));
	}

	/**
	 * To search the person
	 *
	 * @param name first or last name of the person
	 * @return object of the Person (Person it self)
	 */
	private static Person search(String name) {
		Person foundPerson = personList.stream()
				.filter(contact -> contact.getFIRST_NAME().equals(name) || contact.getLAST_NAME().equals(name))
				.findFirst().orElse(null);
		return foundPerson;
	}
}
