package com.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petclinic.dao.VetDao;
import com.petclinic.entity.Speciality;
import com.petclinic.entity.Vet;

@Service
public class VetService {
	@Autowired
	VetDao vdao;

	@Transactional
	public Collection<Speciality> getSpeciality(String specialityName){
		return vdao.getSpeciality(specialityName);
	}

	@Transactional
	public Collection<Vet> getVet(String vetName){
		return vdao.getVet(vetName);
	}

}
