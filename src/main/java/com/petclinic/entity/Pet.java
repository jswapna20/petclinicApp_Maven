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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Pet")
public class Pet{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pid")
	private int pid;

	@NotEmpty(message="Pet name may not be empty")
	@Column(name="petName")
	private String petName;

	@NotEmpty(message="Pet type may not be empty")
	@Column(name="type")
	private String type;

	@Column(name="birthdate")
	private String birthdate;

	@Column(name="poid")
	private int poid;

	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="PetOwner_id")
	private PetOwner petOwner;

	@OneToMany(orphanRemoval=true, cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="vsid")
	private Collection<Visit> visits;

	public Pet(){

	}

	public Pet(final int pid, final String petName, final String type, final String birthdate, final int poid, final PetOwner petOwner,final Collection<Visit> visits){
		this.pid = pid;
		this.petName = petName;
		this.type = type;
		this.birthdate = birthdate;
		this.poid = poid;
		this.petOwner = petOwner;
		this.visits = visits;
	}

	public Pet(final int pid, final String petName, final String type, final String birthdate, final int poid, final PetOwner petOwner){
		this.pid = pid;
		this.petName = petName;
		this.type = type;
		this.birthdate = birthdate;
		this.poid = poid;
		this.petOwner = petOwner;
	}

	public void setPid(int pid){
		this.pid = pid;

	}

	public int getPid(){
		return pid;
	}

	public void setPetName(String petName){
		this.petName = petName;

	}

	public String getPetName(){
		return petName;
	}

	public void setType(String type){
		this.type = type;

	}

	public String getType(){
		return type;
	}


	public void setBirthdate(String birthdate){
		this.birthdate = birthdate;

	}

	public String getBirthdate(){
		return birthdate;
	}

	public void setPoid(int poid){
		this.poid = poid;

	}

	public int getPoid(){
		return poid;
	}

	public void setPetOwner(PetOwner petOwner){
		this.petOwner = petOwner;

	}

	public PetOwner getPetOwner(){
		return petOwner;
	}


	public void setVisits(Collection<Visit> visits){
		this.visits = visits;

	}

	public Collection<Visit> getVisits(){
		return visits;
	}

	@Override
	public boolean equals(Object o){

		if (o instanceof Pet)
		{
			return ((Pet)o).getPid()==pid;
		}
		else 
			return false;
	}

	@Override
	public int hashCode(){

		return pid;

	}

	public String toString(){

		return petName;

	}

};