package com.petclinic.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="SPECIALITY")
public class Speciality{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id")
	private int sid;

	@Column(name = "speciality_name")
	private String specialityName;

	@ManyToOne
    @JoinColumn(name= "v_id")
	private Vet vet;

	public Speciality(){
	}
	

	public Speciality(int sid, String specialityName, Vet vet){
		this.sid = sid;
		this.specialityName = specialityName;
		this.vet = vet;
	}

	public Speciality(int sid,String specialityName){
		this.sid = sid;
		this.specialityName = specialityName;
	}

	public Speciality(String specialityName){
		this.specialityName = specialityName;
	}

	public void setSid(int sid){
		this.sid = sid;
	}

	public int getSid(){
		return sid;
	}

	public void setSpecialityName(String specialityName){
		this.specialityName = specialityName;
	
	}

	public String getSpecialityName(){
		return specialityName;
	}

	public void setVet(Vet vet){
		this.vet = vet;
	
	}

	public Vet getVet(){
		return vet;
	}
	
	@Override
	public boolean equals(Object o){

		if(o == null) return false;
		if(sid == 0) return false;
	
		if(o instanceof Speciality)
			return (((Speciality)o).getSid()== sid);
		else
			return false;
		}
	
	@Override
	public int hashCode(){
	
		return sid;	
	}

	public String toString(){
	
		return specialityName;
	}

}