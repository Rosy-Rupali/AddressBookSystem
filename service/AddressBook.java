
/**************************************************
 * Purpose : Address Book System is used to manage book details
 * @author Rosy Rupali
 * @since 22-06-2021
 *
 *************************************************/

package service;

import java.util.ArrayList;
import java.util.List;
import model.Persons;

public class AddressBook {

	public static List<Persons> personList = new ArrayList<>();// contains all person details
	ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();

	/**
	 * to get all the list of persons in one book
	 */
	public List<Persons> getPersonList() {
		return personList;
	}

	@Override
	public String toString() {
		return "AddressBookMain{" + "personList = " + personList + '}';
	}

	/**
	 * takes details from the user and adds them to the Person. Then adds the Person
	 * to the list
	 */
	public void addContact() {
		Persons persons = new Persons();

		System.out.println("Enter first name");
		persons.setFirstName(scannerForAddressBook.scannerProvider().nextLine());

		System.out.println("Enter last name");
		persons.setLastName(scannerForAddressBook.scannerProvider().nextLine());

		System.out.println("Enter address");
		persons.setAddress(scannerForAddressBook.scannerProvider().nextLine());

		System.out.println("Enter city");
		persons.setCity(scannerForAddressBook.scannerProvider().nextLine());

		System.out.println("Enter state");
		persons.setState(scannerForAddressBook.scannerProvider().nextLine());

		System.out.println("Enter email");
		persons.setEmail(scannerForAddressBook.scannerProvider().nextLine());

		System.out.println("Enter zip");
		persons.setZip(scannerForAddressBook.scannerProvider().nextInt());

		System.out.println("Enter phone number");
		persons.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLong());

		personList.add(persons);

	}

	/**
	 * edits the person details of selected name
	 */
	public void editDetails() {
		String name = getName();
		if (isPersonExist(name) == true) {
			Persons person = getPerson(name);
			boolean isExit = false;
			while (!isExit) {
				System.out.println("Select option:" + "\n" + "1.first name" + "\n" + "2.last name" + "\n" + "3.address"
						+ "\n" + "4.city" + "\n" + "5.state" + "\n" + "6.email" + "\n" + "7.zip" + "\n"
						+ "8.phone number" + "\n" + "9.exit");
				switch (scannerForAddressBook.scannerProvider().nextInt()) {
				case 1:
					System.out.println("Enter new first name to change: ");
					person.setFirstName(scannerForAddressBook.scannerProvider().nextLine());
					break;
				case 2:
					System.out.println("Enter new last name to change: ");
					person.setLastName(scannerForAddressBook.scannerProvider().nextLine());
					break;
				case 3:
					System.out.println("Enter new address to change: ");
					person.setAddress(scannerForAddressBook.scannerProvider().nextLine());
					break;
				case 4:
					System.out.println("Enter new city to change: ");
					person.setCity(scannerForAddressBook.scannerProvider().nextLine());
					break;
				case 5:
					System.out.println("Enter new state to change: ");
					person.setState(scannerForAddressBook.scannerProvider().nextLine());
					break;
				case 6:
					System.out.println("Enter new email to change: ");
					person.setEmail(scannerForAddressBook.scannerProvider().nextLine());
					break;
				case 7:
					System.out.println("Enter new zip to change: ");
					person.setZip(scannerForAddressBook.scannerProvider().nextInt());
					break;
				case 8:
					System.out.println("Enter new phone number to change: ");
					person.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLong());
					break;
				default:
					System.out.println("Thank you!");
					isExit = true;
				}
			}

		} else {
			System.out.println("Person does not exists!");
		}
	}

	/**
	 * to remove person from list
	 *
	 * @param person object of Person class
	 */
	public void deleteContact(Persons person) {
		personList.remove(person);
		System.out.println(personList);
	}

	/**
	 * asks the user for name and returns it
	 *
	 * @return person name
	 */
	private String getName() {
		System.out.println("Enter person name");
		return scannerForAddressBook.scannerProvider().nextLine();
	}

	/**
	 * To find if person exists or not
	 *
	 * @param name first or last name of the person
	 * @return true/false
	 */
	private boolean isPersonExist(String name) {
		return personList.stream().anyMatch(
				personElement -> personElement.getFirstName().equals(name) || personElement.getLastName().equals(name));
	}

	/**
	 * To search the person
	 *
	 * @param name first or last name of the person
	 * @return object of the Person (Person it self)
	 */
	private Persons getPerson(String name) {
		Persons foundPerson = personList.stream()
				.filter(person -> person.getFirstName().equals(name) || person.getLastName().equals(name)).findFirst()
				.orElse(null);
		return foundPerson;
	}

	/**
	 * asks the user for name and returns it
	 *
	 * @return the name of city or state
	 */
	private String getCityOrStateName() {
		System.out.println("Enter city/state name");
		return scannerForAddressBook.scannerProvider().nextLine();
	}

	/**
	 * checks the list for city/state
	 * 
	 * @param name city/state name given by user
	 * @return true/false
	 */
	private boolean isCityOrStateExist(String name) {
		return personList.stream().anyMatch(
				personElement -> personElement.getCity().equals(name) || personElement.getState().equals(name));
	}

	/**
	 * to find person by city/state
	 * @param name city/state name given by user
	 * @return the person is found or not
	 */
	private Persons searchByCityOrState(String name) {
		Persons foundPerson = personList.stream()
				.filter(person -> person.getState().equals(name) || person.getCity().equals(name)).findFirst()
				.orElse(null);
		return foundPerson;
	}

	/**
	 * finds the person by various by it's name or city/state.
	 */
	private void findContactOptions() {
		System.out.println("Select the option: \n1.find by contact name\n2.find by city/state\n3.exit");
		int option = scannerForAddressBook.scannerProvider().nextInt();

		switch (option) {
		case 1:
			String name1 = getName();
			if (isPersonExist(name1)) {
				Persons person1 = getPerson(name1);
				System.out.println("Person " + name1 + ": " + person1);
			} else {
				System.out.println("Person does not exists!");
			}
			break;
		case 2:
			String name2 = getCityOrStateName();
			if (isCityOrStateExist(name2)) {
				Persons person = searchByCityOrState(name2);
				System.out.println("Person from city/state " + name2 + ": " + person);
			} else {
				System.out.println("City/State does not exists!");
			}
			break;
		default:
			System.out.println("Thank you!");
		}
	}

	/**
	 * to access the address book
	 */
	public void accessContact() {
		boolean isExit = false;
		while (!isExit) {
			System.out.println(
					"Select option: \n1.Add Contact\n2.Edit Contact\n3.Delete Contact\n4.Find contact\\n5.Exit");
			int option = scannerForAddressBook.scannerProvider().nextInt();
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
					Persons person = getPerson(name);
					deleteContact(person);
				} else {
					System.out.println("Person does not exist");
				}
				break;
			case 4:
				findContactOptions();
				break;
			default:
				System.out.println("Thanks!");
				isExit = true;
			}

		}
	}
}
