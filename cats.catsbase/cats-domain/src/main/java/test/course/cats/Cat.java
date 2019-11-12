package test.course.cats;

import java.util.Date;

public class Cat 
{
	
	private String name;
	private Float weight;
	private Date dateOfBirth;
	private String ownerName;
	
	public Cat() {
		this.name = "no name";
		this.weight = null;
		this.dateOfBirth = new Date();
		this.ownerName = "no owner";
	}
	
	public String getName() { 
		return this.name; 
	}
	public void setName(String name) { 
		this.name = name; 
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String owner) {
		this.ownerName = owner;
	}	
	
	
	public String getInfo() {
		return "Kot ma na imię "+name+", urodził się "+dateOfBirth+", waży "+weight+", a opiekuje się nim " + ownerName;
	}
    
}
