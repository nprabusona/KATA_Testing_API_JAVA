package dto;

import java.util.ArrayList;


public class Vet {

	private String firstName;
	private String lastName;
	private int id;
	private ArrayList<Type> specialties;

	public Vet()
	{

	}

	public Vet(String firstName, String lastName, int id, ArrayList<Type> specialties) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.specialties = specialties;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Type> getspecialties() {
		return specialties;
	}

	public void setspecialties(ArrayList<Type>	 specialties) {
		this.specialties = specialties;
	}

}
