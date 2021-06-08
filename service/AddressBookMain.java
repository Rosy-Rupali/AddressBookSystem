/**************************************************
 * Purpose : Address Book System
 * @author Rosy Rupali
 * @since 07-06-2021
 *
 *************************************************/

package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Person;

public class AddressBookMain {

	private static Scanner scanner = new Scanner(System.in);
	List<Person> personList = new ArrayList<>();
	Person person = new Person();

	/**
	 * This method is used to add the new person detail in ArrayList
	 * and display the list.
	 */
	public void addNewContact() {
		System.out.println("Enter your First Name: ");
		person.setFirstName(scanner.next());
		scanner.nextLine();
		System.out.println("Enter your Last Name: ");
		person.setLastName(scanner.next());
		scanner.nextLine();
		System.out.println("Enter your address: ");
		person.setAddress(scanner.next());
		scanner.nextLine();
		System.out.println("Enter your City: ");
		person.setCity(scanner.next());
		scanner.nextLine();
		System.out.println("Enter your State: ");
		person.setState(scanner.next());
		scanner.nextLine();
		System.out.println("Enter your Zip: ");
		person.setZip(scanner.nextInt());
		System.out.println("Enter your Phone Number: ");
		person.setPhoneNumber(scanner.nextInt());
		System.out.println("Enter your Email: ");
		person.setEmail(scanner.next());
		scanner.nextLine();

		personList.add(person);
		System.out.println(personList);

	}

	/**
	 * This method is used to edit the details in contact based on the entered First name
	 */
	public void edit() {

		System.out.println("Enter the name of the record which we want to Edit");
		String name = scanner.next();
		if (personList.isEmpty()) {
			System.out.println("No records to edit");
			return;
		}

		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(name)) {
				System.out.println("Enter First name:");
				person.setFirstName(scanner.next());
				scanner.nextLine();
				System.out.println("Enter Last name:");
				person.setLastName(scanner.next());
				scanner.nextLine();
				System.out.println("Enter your address:");
				person.setAddress(scanner.next());
				scanner.nextLine();
				System.out.println("Enter your city:");
				person.setCity(scanner.next());
				scanner.nextLine();
				System.out.println("Enter your state:");
				person.setState(scanner.next());
				scanner.nextLine();
				System.out.println("Enter your ZIP code:");
				person.setZip(scanner.nextInt());
				System.out.println("Enter your phone number");
				person.setPhoneNumber(scanner.nextInt());
				System.out.println("Enter your email");
				person.setEmail(scanner.next());
				scanner.nextLine();

				personList.remove(i);
				personList.add(i, person);
				System.out.println(personList);
			}
		}
	}

	/**
	 * This method is used to delete the contact details of a particular record in
	 * ArrayList based on the entered first name
	 */
	public void delete() {

		System.out.println("Enter the name you want to delete from the record");
		String name = scanner.next();
		if (personList.isEmpty()) {
			System.out.println("No records to delete");
			return;
		}
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(name)) {
				personList.remove(i);
			}
		}
		System.out.println(personList);
	}

	/**
	 * The main method is adding the new contact if user wanted to add
	 * multiple contact details in address book
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to Address Book");
		AddressBookMain book = new AddressBookMain();

		boolean isExit = false;
		while (!isExit) {
			System.out.println("Do You Want to Add New Contact(Y/N)");
			char choice = scanner.next().charAt(0);
			if ((choice == 'Y') || (choice == 'y')) {
				book.addNewContact();
			} else {
				isExit = true;
				break;

			}
		}
	}
}