/**************************************************
 * Purpose : Address Book Simulator class is to maintain multiple contact books
 * @author Rosy Rupali
 * @since 22-06-2021
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


	/**
	 * main method
	 */
	public static void main(String args[]) {
		ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
		AddressBookSimulator addressBookSimulator = new AddressBookSimulator();

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
				System.out.println("Enter the name of new book");
				String bookName = scannerForAddressBook.scannerProvider().nextLine();
				addressBookSimulator.booksMap.put(bookName, new AddressBook());
				break;
			case 2:
				System.out.println("Enter the name of the book to access it");
				Object bookName1 = scannerForAddressBook.scannerProvider().nextLine();
				if (addressBookSimulator.booksMap.containsKey(bookName1)) {
					AddressBook addressBook = addressBookSimulator.booksMap.get(bookName1);
					addressBook.accessContact();
					System.out.println("sorted contacts: " + addressBookSimulator.booksMap.toString());
				}
				break;
			case 3:
				System.out.println("Enter the first/last name to search");
				String contactName = scannerForAddressBook.scannerProvider().nextLine();
				addressBookSimulator.booksMap.entrySet().forEach(entry -> {
					System.out.println(entry.getKey());
					System.out.println(entry.getValue().getPersonList().stream()
											.filter(person -> person.getFirstName().equals(contactName) || person.getLastName().equals(contactName))
											.findFirst().orElse(null));
				});
				break;
			case 4:
				System.out.println("Enter the city/state name to search contact");
				String placeName = scannerForAddressBook.scannerProvider().nextLine();
				addressBookSimulator.booksMap.entrySet().forEach(entry -> {
					System.out.println(entry.getKey());
					System.out.println(entry.getValue().getPersonList().stream()
							.filter(person -> person.getCity().equals(placeName) || person.getState().equals(placeName))
							.findFirst().orElse(null));
				});
				break;
			case 5:
				System.out.println("Enter the city name to search contacts");
				String city = scannerForAddressBook.scannerProvider().nextLine();
				List<List<Persons>> listOfCityContactsList = new ArrayList<>();
				List<Persons> cityContactList;
				for (Map.Entry<String, AddressBook> entry : addressBookSimulator.booksMap.entrySet()) {
					cityContactList = entry.getValue().getPersonList().stream()
							.filter(person -> person.getCity().equals(city)).collect(Collectors.toList());
					listOfCityContactsList.add(cityContactList);
				}
				addressBookSimulator.cityPersonMap.put(city, listOfCityContactsList);
				System.out.println(addressBookSimulator.cityPersonMap);
				break;
			case 6:
				System.out.println("Enter the state name to search contacts");
				String state = scannerForAddressBook.scannerProvider().nextLine();
				List<List<Persons>> listOfStateContactsList = new ArrayList<>();
				List<Persons> statetContactList;
				for (Map.Entry<String, AddressBook> entry : addressBookSimulator.booksMap.entrySet()) {
					statetContactList = entry.getValue().getPersonList().stream()
							.filter(person -> person.getState().equals(state)).collect(Collectors.toList());
					listOfStateContactsList.add(statetContactList);
				}
				addressBookSimulator.statePersonMap.put(state, listOfStateContactsList);
				System.out.println(addressBookSimulator.statePersonMap);
				break;
			case 7:
				System.out.println("Enter the city/state name to search number of contacts");
				String placeName2 = scannerForAddressBook.scannerProvider().nextLine();
				addressBookSimulator.booksMap.entrySet().forEach(entry -> {
					System.out.println(entry.getKey());
					System.out.println("Contacts in a city/state: " + entry.getValue().getPersonList().stream().filter(
							person -> person.getCity().equals(placeName2) || person.getState().equals(placeName2))
							.count());
				});
				break;
			case 8:
				addressBookSimulator.booksMap.entrySet().forEach(entry -> {
					System.out.println("sorted contacts by first name: " + entry.getValue().getPersonList().stream()
							.sorted(Comparator.comparing(Persons::getFirstName)).collect(Collectors.toList()));
				});
				break;
			default:
				isExit = true;
				System.out.println("Thanks for using Address Book Simulator!");
				scannerForAddressBook.scannerProvider().close();// closing scanner
			}
		}
	}
}