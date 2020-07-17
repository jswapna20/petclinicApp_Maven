package com.petclinic.entity;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="PetOwner")
public class PetOwner{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="oid")
	private int oid;

	@NotEmpty(message="Owner name may not be empty")
	@Column(name="ownerName")
	private String ownerName;

	@Column(name="telephone", unique=true, nullable=false)
	private String telephone;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch=FetchType.EAGER)/* later change fetchType.eager to fetchType.lazy*/
	@JoinColumn(name="PetOwner_id")
	private Collection<Pet> pet;

	public PetOwner(){

	}

	public PetOwner(final int oid, final String ownerName,final String address, final String city, final String telephone, final Collection<Pet> pet){
		this.oid = oid;
		this.ownerName = ownerName;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pet = pet;
	}

	public PetOwner(final String ownerName, final String address, final String city, final String telephone, final Collection<Pet> pet){
		this.ownerName = ownerName;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pet = pet;
	}

	public void setOid(int oid){
		this.oid = oid;
	}
	public int getOid(){
		return oid;
	}

	public void setOwnerName(String ownerName){
		this.ownerName = ownerName;
	}
	public String getOwnerName(){
		return ownerName;
	}

	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	public String getTelephone(){
		return telephone;
	}

	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}

	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}

	public void setPet(Collection<Pet> pet){
		this.pet = pet;
	}
	public Collection<Pet> getPet(){
		return pet;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof PetOwner)
		{
			return ((PetOwner)o).getOid()== oid;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int hashCode(){
		return oid;
	}

	public String toString(){
		return ownerName;
	}


}
