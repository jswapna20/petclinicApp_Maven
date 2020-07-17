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

@Entity
@Table(name="VET")
public class Vet{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int vid;

	@Column(name="vet_name")
	private String vetName;

	@OneToMany(orphanRemoval=true, cascade ={CascadeType.ALL },fetch=FetchType.EAGER)
	@JoinColumn(name="v_id")
	private Collection<Speciality> specialities;

	public Vet(){
	}

	public Vet(String vetName){
		this.vetName = vetName;	
	}

	public Vet(String vetName,Collection<Speciality> specialities){
		this.vetName = vetName;
		this.specialities = specialities;
	}

	public Vet(int vid, String vetName,Collection<Speciality> specialities){
		this.vid = vid;
		this.vetName = vetName;
		this.specialities = specialities;
	}

	public Vet(Collection<Speciality> specialities){
		this.specialities = specialities;
	}

	public void setVid(int vid){
		this.vid = vid;
	}

	public int getVid(){
		return vid;	
	}

	public void setVetName(String vetName){
		this.vetName = vetName;
	}

	public String getVetName(){
		return vetName;
	}

	public void setSpecialities(Collection<Speciality> specialities){
		this.specialities = specialities;
	}

	public Collection<Speciality> getSpecialities(){
		return specialities;
	}

	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(vid == 0) return false;

		if(o instanceof Vet)
		{
			return ((Vet)o).getVid()== this.vid;
		}
		else 
			return false;
	}

	@Override
	public int hashCode(){
		return vid;
	}

}
