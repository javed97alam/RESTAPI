package demo.boot.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Customer details documentation")
public class Customer {

	@ApiModelProperty(notes = "name should be atleast 2 characters")
	@Size(min = 3, message="name should have atleast 2 characters")
	String name;
	String location;
	
	@Email(regexp=".@.\\..*", message = "Email should be valid")
    private String email;
	
	public Customer(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", location=" + location + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	   public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	
	
}
