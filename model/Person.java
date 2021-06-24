/**************************************************
 * Purpose : It is a POJO concept program to store contact details
 * @author Rosy Rupali
 * @since 07-06-2021
 *
 *************************************************/
package model;

import java.util.Objects;

public class Person {
	private static String FIRST_NAME;
	private static String LAST_NAME;
	private static String ADDRESS;
	private static String CITY;
	private static String STATE;
	private static String EMAIL;
	private static int ZIP;
	private static long PHONE_NUMBER;

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	@Override
	public String toString() {
		return "Person [FIRST_NAME =" + getFIRST_NAME() + ", LAST_NAME =" + getLAST_NAME() + ", ADDRESS ="
				+ getADDRESS() + ", CITY =" + getCITY() + ", STATE =" + getSTATE() + ", EMAIL =" + getEMAIL()
				+ ", ZIP =" + getZIP() + ", PHONE_NUMBER =" + getPHONE_NUMBER() + "]";
	}

	public static void setFIRST_NAME(String FIRST_NAME) {
		Person.FIRST_NAME = FIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public static void setLAST_NAME(String LAST_NAME) {
		Person.LAST_NAME = LAST_NAME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public static void setADDRESS(String ADDRESS) {
		Person.ADDRESS = ADDRESS;
	}

	public String getCITY() {
		return CITY;
	}

	public static void setCITY(String CITY) {
		Person.CITY = CITY;
	}

	public String getSTATE() {
		return STATE;
	}

	public static void setSTATE(String STATE) {
		Person.STATE = STATE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public static void setEMAIL(String EMAIL) {
		Person.EMAIL = EMAIL;
	}

	public int getZIP() {
		return ZIP;
	}

	public static void setZIP(int ZIP) {
		Person.ZIP = ZIP;
	}

	public long getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public static void setPHONE_NUMBER(long PHONE_NUMBER) {
		Person.PHONE_NUMBER = PHONE_NUMBER;
	}

	@Override
	public int hashCode() {
		return Objects.hash(FIRST_NAME, LAST_NAME);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Person person = (Person) obj;
		return Objects.equals(FIRST_NAME, Person.FIRST_NAME) && Objects.equals(LAST_NAME, Person.LAST_NAME);
	}

}
