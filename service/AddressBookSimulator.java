/**************************************************
 * Purpose : Address Book Simulator class is to maintain multiple contact books
 * @author Rosy Rupali
 * @since 22-06-2021
 *
 *************************************************/
package service;

import java.util.HashMap;

public class AddressBookSimulator {

	HashMap<String, AddressBookMain> booksMap = new HashMap<>();

	/**
	 * main method
	 */
	public static void main(String[] args) {
		ScannerForUserInput scannerForUserInput = new ScannerForUserInput();
		AddressBookSimulator addressBookSimulator = new AddressBookSimulator();
		boolean isExit = false;
		while (!isExit) {
			System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact by first/last name\n"
					+ "4.Search contact by city/state\n5.Find number of contacts\n6.Exit");
			int option = scannerForUserInput.scannerInitializer().nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter the name of new book");
				String bookName = scannerForUserInput.scannerInitializer().nextLine();
				addressBookSimulator.booksMap.put(bookName, new AddressBookMain());
				break;
			case 2:
				System.out.println("Enter the name of new book to access it");
				Object bookName1 = scannerForUserInput.scannerInitializer().nextLine();
				if (addressBookSimulator.booksMap.containsKey(bookName1)) {
					AddressBookMain contactManager = addressBookSimulator.booksMap.get(bookName1);
					contactManager.accessContact();
				}
				break;
			case 3:
				System.out.println("Enter the first/last name to search");
				String contactName = scannerForUserInput.scannerInitializer().nextLine();
				addressBookSimulator.booksMap.entrySet().forEach(entry -> {
					System.out.println(entry.getKey());
					System.out.println(entry.getValue().getPersonList().stream()
											.filter(person -> person.getFIRST_NAME().equals(contactName) || person.getLAST_NAME().equals(contactName))
											.findFirst().orElse(null));
				});
				break;
			case 4:
				System.out.println("Enter the city/state name to search");
				String placeName = scannerForUserInput.scannerInitializer().nextLine();
				addressBookSimulator.booksMap.entrySet().forEach(entry -> {
					System.out.println(entry.getKey());
					System.out.println(entry.getValue().getPersonList().stream()
							.filter(person -> person.getCITY().equals(placeName) || person.getSTATE().equals(placeName))
							.findFirst().orElse(null));
				});
				break;
			case 5:
				System.out.println("Enter the city/state name to search number of contacts");
				String placeName2 = scannerForUserInput.scannerInitializer().nextLine();
				addressBookSimulator.booksMap.entrySet().forEach(entry -> {
					System.out.println(entry.getKey());
					System.out.println("same cities or states: " + entry.getValue().getPersonList().stream().filter(
							person -> person.getCITY().equals(placeName2) || person.getSTATE().equals(placeName2))
							.count());
				});
				break;
			default:
				isExit = true;
				System.out.println("Thanks for using Address Book Simulator!");
				scannerForUserInput.scannerInitializer().close();
			}
		}
	}
}