/**************************************************
 * Purpose : Address Book System is used to manage book details
 * @author Rosy Rupali
 * @since 22-06-2021
 *
 *************************************************/

package service;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Persons;

public class AddressBook {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Persons> contactList;
	public HashMap<String, ArrayList<Persons>> personByState;
	public HashMap<String, ArrayList<Persons>> personByCity;

	public AddressBook() {
		personByCity = new HashMap<String, ArrayList<Persons>>();
		personByState = new HashMap<String, ArrayList<Persons>>();
		contactList = new ArrayList<Persons>();
	}

	/**
	 * This method add person to the contact list
	 * 
	 * @return : details of person in the list
	 */
	public ArrayList<Persons> addContactDetails() {
		System.out.println("Enter the Details of ContactDetails");
		System.out.println("Enter the first name");
		String firstName = sc.next();
		if (checkDuplicate(firstName)) {
			System.out.println("Person is already exist");
		} else {
			System.out.println("Enter the Last name");
			String lastName = sc.next();
			sc.nextLine();
			System.out.println("Enter the Address");
			String address = sc.next();
			sc.nextLine();
			System.out.println("Enter the City");
			String city = sc.next();
			sc.nextLine();
			System.out.println("Enter the State");
			String state = sc.next();
			sc.nextLine();
			System.out.println("Enter the email");
			String email = sc.next();
			sc.nextLine();
			System.out.println("Enter the ZipCode");
			int zip = sc.nextInt();
			System.out.println("Enter the contact number...");
			long phoneNumber = sc.nextLong();
			Persons contactofPerson = new Persons(firstName, lastName, address, city, state, email, zip, phoneNumber);
			contactList.add(contactofPerson);
			if (!personByState.containsKey(state)) {
				personByState.put(state, new ArrayList<Persons>());
			}
			personByState.get(state).add(contactofPerson);

			if (!personByCity.containsKey(city)) {
				personByCity.put(city, new ArrayList<Persons>());
			}
			personByCity.get(city).add(contactofPerson);

		}
		return contactList;
	}

	/**
	 * This method is use to edit the contact list according to person name
	 * 
	 * @param Name : name of person that user want to edit
	 * @return : edited contact list
	 */
	public boolean editContactDetails(String Name) {
		int flag = 0;
		for (Persons contact : contactList) {
			if (contact.getFirstName().equals(Name)) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Address: ");
				String address = sc.next();
				contact.setAddress(address);
				sc.nextLine();
				System.out.println("Enter City: ");
				String city = sc.next();
				contact.setCity(city);
				sc.nextLine();
				System.out.println("Enter State: ");
				String state = sc.next();
				contact.setState(state);
				sc.nextLine();
				System.out.println("Enter Email: ");
				String email = sc.next();
				contact.setEmail(email);
				sc.nextLine();
				System.out.println("Enter Phone Number:");
				long phoneNumber = sc.nextLong();
				contact.setPhoneNumber(phoneNumber);
				System.out.println("Enter Zip Code: ");
				int zip = sc.nextInt();
				contact.setZip(zip);
				flag = 1;
			}
		}
		return flag == 1;
	}

	/**
	 * This method is use to delete the contact list according to person name
	 * 
	 * @param name : name of the person that user want to delete
	 * @return : deleted contact list
	 */
	public boolean deleteContact(String name) {
		int flag = 0;
		for (Persons contact : contactList) {
			if (contact.getFirstName().equals(name)) {
				contactList.remove(contact);
				flag = 1;
				break;
			}
		}
		return flag == 1;
	}

	/**
	 * This method is use to check any duplicate person is present in the contact
	 * list
	 * 
	 * @param fname : name of person that user want
	 * @return duplicated person if present
	 */
	public boolean checkDuplicate(String fname) {
		int flag = 0;
		for (Persons p : contactList) {
			if (p.getFirstName().equals(fname)) {
				flag = 1;
				break;
			}
		}
		return flag == 1;
	}

	/**
	 * This method is to find person name if present that particular state
	 * 
	 * @param State : name of state given by user
	 */
	public void getPersonNameByState(String State) {
		List<Persons> list = contactList.stream().filter(contactName -> contactName.getState().equals(State))
				.collect(Collectors.toList());
		for (Persons contact : list) {
			System.out.println("First Name: " + contact.getFirstName());
			System.out.println("Last Name: " + contact.getLastName());
		}

	}

	/**
	 * This method is to find person name if present that particular city
	 * 
	 * @param cityName : name of city given by user
	 */
	public void getPersonNameByCity(String cityName) {
		List<Persons> list = contactList.stream().filter(contactName -> contactName.getCity().equals(cityName))
				.collect(Collectors.toList());
		for (Persons contact : list) {
			System.out.println("First Name: " + contact.getFirstName());
			System.out.println("Last Name: " + contact.getLastName());
		}
	}

	/**
	 * writes contact book to file Contacts.txt
	 * 
	 * @param addressBookMain
	 */
	public static void writeData(AddressBookMain addressBookMain) {
		StringBuffer personBuffer = new StringBuffer();
		contactList.forEach(person -> {
			String personDataString = person.toString().concat("\n");
			personBuffer.append(personDataString);
		});
		try {
			Files.write(Paths.get("Contactstxt"), personBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * reads contact book to file Contacts.txt and print them on console
	 * 
	 * @param addressBookMain
	 */
	public static void readData(AddressBookMain addressBookMain) {
		try {
			Files.lines(new File("Contacts.txt").toPath()).map(String::trim).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * writing a data into CSV file
	 * 
	 * @throws IOException
	 * @throws CsvRequiredFieldEmptyException
	 * @throws CsvDataTypeMismatchException
	 */
	public static void writeDataToCSV()
			throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
		try (Writer writer = Files.newBufferedWriter(Paths.get("Contacts.csv"));) {
			StatefulBeanToCsvBuilder<Persons> builder = new StatefulBeanToCsvBuilder<>(writer);
			StatefulBeanToCsv<Persons> beanWriter = builder.build();
			beanWriter.write(contactList);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reading a data into CSV file
	 * 
	 * @throws IOException
	 */
	public static void readDataFromCSV() throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get("Contacts.csv"));
				CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				System.out.println("First Name = " + nextRecord[3]);
				System.out.println("Last Name = " + nextRecord[4]);
				System.out.println("Address = " + nextRecord[0]);
				System.out.println("City = " + nextRecord[1]);
				System.out.println("State = " + nextRecord[6]);
				System.out.println("Email = " + nextRecord[2]);
				System.out.println("Phone Number = " + nextRecord[5]);
				System.out.println("Zip Code = " + nextRecord[7]);
			}
		}
	}

	
	/**
	 * This method writes contacts to a json file.
	 * 
	 * @throws IOException
	 */
	public static void convertToJson() throws IOException {
		String result = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(contactList);
			for (Persons person : contactList) {
				mapper.writeValue(new File("Contacts.json"), person);
			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			System.out.println(result);
		}
	}
}
