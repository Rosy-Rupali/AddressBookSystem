
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
	 * This method add the person detail in ArrayList
	 */
	public void add() {
		System.out.println("Enter your First Name: ");
		person.setFirstName(scanner.next());
		System.out.println("Enter your Last Name: ");
		person.setLastName(scanner.next());
		System.out.println("Enter your address: ");
		person.setAddress(scanner.next());
		System.out.println("Enter your City: ");
		person.setCity(scanner.next());
		System.out.println("Enter your State: ");
		person.setState(scanner.next());
		System.out.println("Enter your Zip: ");
		person.setZip(scanner.nextInt());
		System.out.println("Enter your Phone Number: ");
		person.setPhoneNumber(scanner.nextInt());
		System.out.println("Enter your Email: ");
		person.setEmail(scanner.next());

		personList.add(person);
		System.out.println(personList);

	}
	
	/**
	 * This method is used to edit the details in contact based on the entered name
	 */
	public void edit() {
		String name=null;
		System.out.println("Enter the name of the record which we want to Edit");
		name = scanner.next();
		if(personList.isEmpty())
		{
			System.out.println("No records to edit");
			return;
		}
		
			for(int i=0;i<personList.size();i++)
			{
				if((personList.get(i).getFirstName().equals(name)) || (personList.get(i).getLastName().equals(name)))
				{
					System.out.println("Enter First name:");
					person.setFirstName(scanner.next());
					System.out.println("Enter Last name:");
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
					person.setPhoneNumber(scanner.nextInt());
					
					personList.remove(i);
					personList.add(i, person);
				}
				
			}
		
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book");
		AddressBookMain book = new AddressBookMain();
		boolean isExit = false;
		while (!isExit) {

			System.out.println("Enter options 1:Add\n2:Edit\n3:Delete\n4:Exit\n5:Show Contact");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				book.add();
				break;
			case 2:
				book.edit();
				break;
			default:
				System.out.println("Invalid option");
			}
		}
	}
}
