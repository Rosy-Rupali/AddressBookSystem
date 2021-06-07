package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Person;

/**
 * @author HEMANT
 *
 */
/**
 * This method add the person detail in ArrayList
 */
public class AddressBookMain {
	private static Scanner scanner = new Scanner(System.in);
	List<Person> personList = new ArrayList<>();
	Person person = new Person();

	public void add() {
		System.out.println("Enter your First Name: ");
		person.setFirstName(scanner.nextLine());
		System.out.println("Enter your Last Name: ");
		person.setLastName(scanner.nextLine());
		System.out.println("Enter your address: ");
		person.setAddress(scanner.nextLine());
		System.out.println("Enter your City: ");
		person.setCity(scanner.nextLine());
		System.out.println("Enter your State: ");
		person.setState(scanner.nextLine());
		System.out.println("Enter your Zip: ");
		person.setZip(scanner.nextInt());
		System.out.println("Enter your Phone Number: ");
		person.setPhoneNumber(scanner.nextInt());
		System.out.println("Enter your Email: ");
		person.setEmail(scanner.nextLine());

		personList.add(person);
		System.out.println(personList);

	}

	public static void main(String[] args) {
		
		AddressBookMain book = new AddressBookMain();
		System.out.println("Welcome to Address Book");
		
		boolean isExit = false;
		
		 while (!isExit) {
		      System.out.println("Enter options 1:Add\n2:Edit\n3:Delete\n4:Exit\n5:Show Contact");
		      int option = scanner.nextInt();
		      
		      switch (option) {
		        case 1: 
		        	book.add();
		        	break;
	        default:
	        	System.out.println("Invalid option");
		      }
		 }
	}
}
