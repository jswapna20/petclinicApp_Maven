package com.petclinic.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.dto.VetDto;
import com.petclinic.entity.Speciality;
import com.petclinic.entity.Vet;
import com.petclinic.service.VetService;


@Controller
@RequestMapping("/")
public class VetController{

	@Autowired
	VetService vetService;

	@RequestMapping(value="/searchVet", method=RequestMethod.POST)
	public ModelAndView vetName(@ModelAttribute("vetDto") VetDto vetDto, BindingResult result, HttpSession session){

		System.out.println("in vetController entry!!!!!!!!!!!!");

		String vetName = vetDto.getVetName();
		System.out.println("in vetController entry!!!!!!!!!!!! vetName value" +vetName);

		String specialityName = vetDto.getSpecialityName();
		System.out.println("in vetController entry!!!!!!!!!!!! specialityName value" +specialityName);


		Map<Speciality, Vet> spMap = new HashMap<>();
		Map<Vet, Collection<Speciality>> vetMap = new HashMap<>();

		if(specialityName != ""){
			// speciality Name //
			Collection<Speciality> specialityColl = new ArrayList<Speciality>();
			Vet vetObject = new Vet();


			specialityColl = vetService.getSpeciality(specialityName);
			System.out.println("in vetController entry!!!!!!!!!!!! chk specialityColl value afetr cmng fro dao" +specialityColl.size());

			for (Speciality spObject : specialityColl )
			{
				vetObject = spObject.getVet();
				spMap.put(spObject, vetObject );

			}


		}
		else{

			// vetName //
			Collection<Speciality> sp = new ArrayList<Speciality>();
			Collection<Vet> vetColl = vetService.getVet(vetName);

			System.out.println("in vetController entry!!!!!!!!!!!! chk vetColl value afetr cmng fro dao" +vetColl.size());


			for (Vet vet : vetColl )
			{
				sp =  vet.getSpecialities();
				System.out.println("inside controller vetName sp size check"+sp.size());
				vetMap.put(vet, sp);
			}


		}


		ModelAndView mv = new ModelAndView("vetsearch_speciality");
		mv.addObject("vetMap", vetMap);
		mv.addObject("spMap", spMap);


		System.out.println("HELLO CONTROLLER!!!!!!!!!!");

		return mv;



	}

}


