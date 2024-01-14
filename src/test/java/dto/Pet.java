package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Pet {
    private int id;
    private String name;
    private String birthDate;
    private Type type;
    private Owner owner;
    @JsonIgnore
    private ArrayList<Visit> visits;

    public Pet()
    {
    	
    }

	public Pet(int id, String name, String birthDate, Type type, Owner owner, ArrayList<Visit> visits) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.type = type;
		this.owner = owner;
		this.visits = visits;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
    }



}
