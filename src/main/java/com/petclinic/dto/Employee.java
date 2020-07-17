package com.petclinic.dto;
import java.lang.annotation.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;


public class Employee{ 
	@NotEmpty
	@Email
	private String username;
	@NotEmpty
	private String password;

		public Employee(){
		}

		public Employee(String username,String password ){
			this.username = username;
			this.password = password;

		}

		public void setUsername(String username){
		
			this.username = username;
		}

		public String getUsername(){
			
			return username;
		}

		public void setPassword(String password){
		
			this.password = password;
		
		}

		public String getPassword(){
		
			return password;
		} 

		public boolean equals(Object o){
		
			if(o instanceof Employee)
				return ((Employee)o).getUsername()==username;
			else
				return false;
		}
}
