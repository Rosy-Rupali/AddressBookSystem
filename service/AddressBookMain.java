
/**************************************************
 * Purpose : Address Book System
 * @author Rosy Rupali
 * @since 07-06-2021
 *
 *************************************************/

package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Person;

public class AddressBookMain {

	private static Scanner scanner = new Scanner(System.in);
	ArrayList<Person> personList = new ArrayList<>();
	Person person = new Person();

	/**
	 * This method is used to add the person detail in a particular
	 * address book and check whether the same person details has not
	 * been entered multiple times. 
	 */
	public void add() {

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
		person.setPhoneNumber(scanner.nextLong());
		System.out.println("Enter your Email: ");
		person.setEmail(scanner.next());
		scanner.nextLine();

		personList.stream().forEach(n -> {
			if (n.getFirstName().equals(person.getFirstName())) {
				System.out.println("Duplicate entry is found!!");
			} else {
				personList.add(person);
			}
		});
		if (personList.size() == 0)
			personList.add(person);
		System.out.println(personList);
	}

	/**
	 * This method is used to edit the details in contact based on the entered First
	 * name
	 */
	public void edit() {

		System.out.println("Enter the 'First Name' of the record u want to Edit");
		String name = scanner.nextLine();
		if (personList.isEmpty()) {
			System.out.println("No records to edit");
			return;
		}

		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(name)) {
				System.out.println(name);
				System.out.println("Enter First name:");
				person.setFirstName(scanner.next());
				System.out.println("Enter last name:");
				person.setLastName(scanner.next());
				System.out.println("Enter your address:");
				person.setAddress(scanner.next());
				System.out.println("Enter your city:");
				person.setCity(scanner.next());
				System.out.println("Enter your state:");
				person.setState(scanner.next());
				System.out.println("Enter your ZIP code:");
				person.setZip(scanner.nextInt());
				System.out.println("Enter your phone number");
				person.setPhoneNumber(scanner.nextLong());
				personList.remove(i);
				personList.add(i, person);
				System.out.println(personList);
				break;
			}

		}
	}

	/**
	 * This method is used to delete the contact details of a particular record in
	 * ArrayList based on the entered first name
	 */
	public void delete() {
		System.out.println("Enter the First name of the record you want to delete");
		String name = scanner.nextLine();
		if (personList.isEmpty()) {
			System.out.println("No records to delete");
			return;
		}
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(name)) {
				personList.remove(i);
				break;
			}
		}
	}
}
