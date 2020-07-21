package com.petclinic.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petclinic.dao.PetDao;
import com.petclinic.entity.Pet;
import com.petclinic.entity.PetOwner;
import com.petclinic.entity.Visit;

@Service
public class PetService {

	@Autowired
	PetDao petDao;

	@Transactional
	public Collection<Pet> getPetDetails(String petName){
		return petDao.getPetDetails(petName);
	}
	
	@Transactional
	public Integer addPetOwner(PetOwner petOwner){
		  return petDao.addPetOwner(petOwner);
	}
	

	@Transactional
	public Collection<PetOwner> getPetOwnerDetails(String OwnerName){
		return petDao.getPetOwnerDetails(OwnerName);
	} 
	
	@Transactional
	public PetOwner getPetOwner(Integer poid){
		return petDao.getPetOwner(poid);

	} 
	
	@Transactional
	public void updatePetOwnerWithPet(Integer poid,PetOwner pto1,List<Pet> hs){
		petDao.updatePetOwnerWithPet(poid, pto1,hs);

	} 
	
	@Transactional
	public Pet getPet(Integer pid ){
		return petDao.getPet(pid);
	} 
	
	@Transactional
	public void updatePetWithVisits(Integer pid,List<Visit> hs){
		 petDao.updatePetWithVisits(pid, hs);
	}
	
	@Transactional
	public PetOwner updatePetOwner(Integer oid, String name, String address, String city, String telephone){
		 return petDao.updatePetOwner(oid, name, address, city, telephone);
	}
	
	@Transactional
	public Pet updatePet(Integer pid,String pname, String type,String date){
		 return petDao.updatePet(pid,pname,type,date);
	}
	
	@Transactional
	public void deletePetOwner(Integer oid){
		  petDao.deletePetOwner(oid);
	}
	
	@Transactional
	public void deletePetFromOwner(Integer oid,Pet ptdao){
		  petDao.deletePetFromOwner(oid, ptdao);
	}
	
	@Transactional
	public void deleteVisitHistory(Integer pid){
		  petDao.deleteVisitHistory(pid);
	}
	

}
