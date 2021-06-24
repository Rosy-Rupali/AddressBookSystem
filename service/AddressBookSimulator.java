/**************************************************
 * Purpose : Address Book Simulator class is to maintain multiple contact books
 * @author Rosy Rupali
 * @since 22-06-2021
 *
 *************************************************/
package service;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookSimulator {

	private static HashMap<String, AddressBookMain> booksMap = new HashMap<>();

	/**
	 * main method
	 */
	public static void main(String[] args) {
		boolean isExit = false;
		while (!isExit) {
			System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact\\\n4.Exit");
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter the name of new book");
				Scanner scanner1 = new Scanner(System.in);
				String bookName = scanner1.nextLine();
				booksMap.put(bookName, new AddressBookMain());
				break;
			case 2:
				System.out.println("Enter the name of the book to access it");
				Scanner scanner2 = new Scanner(System.in);
				Object bookName1 = scanner2.nextLine();
				if (booksMap.containsKey(bookName1)) {
					AddressBookMain bookManager = booksMap.get(bookName1);
					bookManager.accessContact();
					bookManager.getPersonList();
				}
				break;
			case 3:
				System.out.println("Enter the name to search");
				Scanner scanner3 = new Scanner(System.in);
				String name = scanner3.nextLine();
				System.out.println(booksMap.values().stream()
						.flatMap(book -> book.getPersonList().stream()
						.filter(person -> person.getSTATE().equals(name) || person.getCITY().equals(name)))
						.collect(Collectors.toList()));
				break;
			default:
				System.out.println("Thanks for using Address Book Simulator!");
				isExit = true;
				scanner.close();
			}
		}
	}
}
