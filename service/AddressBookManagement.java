/**************************************************
 * Purpose : Address Book System
 * @author Rosy Rupali
 * @since 22-06-2021
 *
 *************************************************/
package service;

import java.util.Scanner;

public class AddressBookManagement {

	/**
	 * This is a main method from where we can add, delete and edit the contact details of a person
	 * @param args 
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		AddressBookMain object = new AddressBookMain();
		Scanner scanner = new Scanner(System.in);
		boolean isExit = false;
		while (!isExit) {
			System.out.println("Choose any one option :\n1:addContact\n2:editContact\n3:deleteContact\n4:exit");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				object.add();
				break;
			case 2:
				object.edit();
				break;
			case 3:
				object.delete();
				break;
			case 4:
				isExit = true;
				break;
			}
		}
		scanner.close();
	}
}
