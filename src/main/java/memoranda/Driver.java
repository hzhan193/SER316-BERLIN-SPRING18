package main.java.memoranda;

public class Driver {
	private int id;
	private String name;
	private String phoneNumber;
	
	// Constructors
	public Driver(int idVar, String nameVar, String phoneNumberVar) {
		id = idVar;
		name = nameVar;
		phoneNumber = phoneNumberVar;
	}
	
	public Driver() {
		id = 0;
		name = "";
		phoneNumber = "";
	}
	
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	// Setters
	public void setId(int idVar) {
		id = idVar;
	}
	
	public void setName(String nameVar) { 
		name = nameVar;
	}
	
	public void setPhoneNumber(String phoneNumberVar) {
		phoneNumber = phoneNumberVar;
	}

}
