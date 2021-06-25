/**************************************************
 * Purpose : Address Book Simulator class is to maintain multiple contact books
 * @author Rosy Rupali
 * @since 24-06-2021
 *
 *************************************************/
package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Persons;

public class AddressBookSimulator {

	public static Map<String, AddressBook> booksMap = new HashMap<>();
	public static Map<String, List<List<Persons>>> cityPersonMap = new HashMap<>();
	public static Map<String, List<List<Persons>>> statePersonMap = new HashMap<>();
	private static AddressBookSimulator addressBookSimulator = new AddressBookSimulator();
	ScannerForAddressBook scannerForAddressBook = initializeScanner();

	/**
	 * main method
	 */
	public static void main(String args[]) {
		ScannerForAddressBook scannerForAddressBook = initializeScanner();

		System.out.println("Welcome to address book simulator!");

		boolean isExit = false;
		while (!isExit) {
			System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact by first/last name"
					+ "\n4.Search contact by city/state\n5.Show the contacts by city"
					+ "\n6.Show the contacts by state\n7.Find number of contacts in a city/state"
					+ "\n8.Sort the contacts by name\n9.Exit");
			int option = scannerForAddressBook.scannerProvider().nextInt();
			switch (option) {
			case 1:
				addressBookSimulator.addBook();
				break;
			case 2:
				addressBookSimulator.accessBook();
				break;
			case 3:
				addressBookSimulator.searchByName();

				break;
			case 4:
				addressBookSimulator.searchContactByCityOrState();

				break;
			case 5:
				addressBookSimulator.showPersonsByCity();
				break;
			case 6:
				addressBookSimulator.showPersonsByState();
				break;
			case 7:
				addressBookSimulator.countPersonsByCityOrState();
				break;
			case 8:
				addressBookSimulator.sortingOptions();
				break;
			default:
				isExit = true;
				System.out.println("Thanks for using Address Book Simulator!");
				scannerForAddressBook.scannerProvider().close();// closing scanner
			}
		}
	}

	/**
	 * initializes scanner class
	 */
	public static ScannerForAddressBook initializeScanner() {
		ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
		return scannerForAddressBook;
	}
	/**
	 * add new Book
	 */
	public void addBook() {
		System.out.println("Enter the name of new book");
		String bookName = scannerForAddressBook.scannerProvider().nextLine();
		if (AddressBookSimulator.booksMap.containsKey(bookName)) {
			System.out.println("Book already exists!");
		} else {
			AddressBookSimulator.booksMap.put(bookName, new AddressBook());
		}
	}

	/**
	 * Access existing Book
	 */
	public void accessBook() {
		System.out.println("Enter the name of the book to access it");
		Object bookName1 = scannerForAddressBook.scannerProvider().nextLine();
		if (AddressBookSimulator.booksMap.containsKey(bookName1)) {
			AddressBook addressBook = AddressBookSimulator.booksMap.get(bookName1);
			addressBook.accessContact();
			System.out.println("sorted contacts: " + AddressBookSimulator.booksMap.toString());
		}
	}

	/**
	 * Search person by first/last name
	 */
	public void searchByName() {
		System.out.println("Enter the first/last name to search");
		String contactName = scannerForAddressBook.scannerProvider().nextLine();
		AddressBookSimulator.booksMap.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue().getPersonList().stream()
					.filter(person -> person.getFirstName().equals(contactName) || person.getLastName().equals(contactName))
					.findFirst().orElse(null));
		});
	}

	/**
	 * Search person by city/state
	 */
	public void searchContactByCityOrState() {
		System.out.println("Enter the city/state name to search contact");
		String placeName = scannerForAddressBook.scannerProvider().nextLine();
		AddressBookSimulator.booksMap.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue().getPersonList().stream()
					.filter(person -> person.getCity().equals(placeName) || person.getState().equals(placeName))
					.findFirst().orElse(null));
		});
	}

	/**
	 * Show the persons of the city
	 */
	public void showPersonsByCity() {
		System.out.println("Enter the city name to search contacts");
		String city = scannerForAddressBook.scannerProvider().nextLine();
		List<List<Persons>> listOfCityContactsList = new ArrayList<>();
		List<Persons> cityContactList;
		for (Map.Entry<String, AddressBook> entry : AddressBookSimulator.booksMap.entrySet()) {
			cityContactList = entry.getValue().getPersonList().stream()
					.filter(person -> person.getCity().equals(city))
					.collect(Collectors.toList());
			listOfCityContactsList.add(cityContactList);
		}
		AddressBookSimulator.cityPersonMap.put(city, listOfCityContactsList);
		System.out.println(AddressBookSimulator.cityPersonMap);
	}

	/**
	 * Show the persons of the state
	 */
	public void showPersonsByState() {
		System.out.println("Enter the state name to search contacts");
		String state = scannerForAddressBook.scannerProvider().nextLine();
		List<List<Persons>> listOfStateContactsList = new ArrayList<>();
		List<Persons> statetContactList;
		for (Map.Entry<String, AddressBook> entry : AddressBookSimulator.booksMap.entrySet()) {
			statetContactList = entry.getValue().getPersonList().stream()
					.filter(person -> person.getState().equals(state))
					.collect(Collectors.toList());
			listOfStateContactsList.add(statetContactList);
		}
		AddressBookSimulator.statePersonMap.put(state, listOfStateContactsList);
		System.out.println(AddressBookSimulator.statePersonMap);
	}

	/**
	 * Find number of persons in a city/state
	 */
	public void countPersonsByCityOrState() {
		System.out.println("Enter the city/state name to search number of contacts");
		String placeName2 = scannerForAddressBook.scannerProvider().nextLine();
		AddressBookSimulator.booksMap.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println("Contacts in a city/state: " + entry.getValue().getPersonList().stream()
					.filter(person -> person.getCity().equals(placeName2) || person.getState().equals(placeName2))
					.count());
		});
	}

	/**
	 * sorting options
	 */
	public void sortingOptions() {
		ScannerForAddressBook scannerForAddressBook = initializeScanner();
		boolean isExit = false;
		while (!isExit) {
			System.out.println(
					"Select the option: \n1.Sort by first name\n2.Sort by city\n3.Sort by state\n4.Sort by zip\n5.Exit");
			try {
				int option = scannerForAddressBook.scannerProvider().nextInt();
				switch (option) {
				case 1:
					addressBookSimulator.sortByFirstName();
					break;
				case 2:
					addressBookSimulator.sortPersonByCity();
					break;
				case 3:
					addressBookSimulator.sortPersonByState();
					break;
				case 4:
					addressBookSimulator.sortPersonByZip();
					break;
				default:
					isExit = true;
					System.out.println("Thank you!");
				}
			} catch (Exception e) {
				System.out.println("Invalid option selected!, Please select from the given.");
			}
		}
	}

	/**
	 * sort by first name of person
	 */
	public void sortByFirstName() {
		AddressBookSimulator.booksMap.entrySet().forEach(entry -> {
			System.out.println("sorted contacts by first name: " + entry.getValue().getPersonList().stream()
					.sorted(Comparator.comparing(Persons::getFirstName))
					.collect(Collectors.toList()));
		});
	}

	/**
	 * sort persons by city name
	 */
	public void sortPersonByCity() {
		AddressBookSimulator.booksMap.entrySet().forEach(entry -> {
			System.out.println("sorted contacts by city: " + entry.getValue().getPersonList().stream()
					.sorted(Comparator.comparing(Persons::getCity))
					.collect(Collectors.toList()));
		});
	}

	/**
	 * sort persons by state name
	 */
	public void sortPersonByState() {
		AddressBookSimulator.booksMap.entrySet().forEach(entry -> {
			System.out.println("sorted contacts by state: " + entry.getValue().getPersonList().stream()
					.sorted(Comparator.comparing(Persons::getState))
					.collect(Collectors.toList()));
		});
	}

	/**
	 * sort persons by zip
	 */
	public void sortPersonByZip() {
		AddressBookSimulator.booksMap.entrySet().forEach(entry -> {
			System.out.println("sorted contacts by zip: " + entry.getValue().getPersonList().stream()
					.sorted(Comparator.comparing(Persons::getZip))
					.collect(Collectors.toList()));
		});
	}
}