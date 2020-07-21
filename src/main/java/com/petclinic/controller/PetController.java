   package com.petclinic.controller;

   import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.dto.PetnOwnerDto;
import com.petclinic.entity.Pet;
import com.petclinic.entity.PetOwner;
import com.petclinic.entity.Visit;
import com.petclinic.service.PetService;


/**
 * 
 * @author Swapna
 *
 */
	@Controller
	public class PetController{
				
		@Autowired
		PetService petService;
		//Displays the first Pet Management page	
		/**
		 * 
		 * @return
		 */
		@RequestMapping("/petsearch")
		public ModelAndView petsrch(){
				
			Pet pet = new Pet();
			PetOwner petOwner = new PetOwner();
			ModelAndView mv = new ModelAndView("petsrch");
			mv.addObject("pet", pet);
			mv.addObject("petOwner", petOwner);
			return mv;
		}

		//Displays the first Pet Management page	
		@RequestMapping("/cancelToPetsearch")
		public ModelAndView switchToPetsrch(){
				
			Pet pet = new Pet();
			PetOwner petOwner = new PetOwner();
			ModelAndView mv = new ModelAndView("petsrch");
			mv.addObject("pet", pet);
			mv.addObject("petOwner", petOwner);
			return mv;
		}

		//displays links of all matching pets with the name entered and their petOwners are displayed across their pets  
		@RequestMapping("/search")
		public ModelAndView searchPetLink(@ModelAttribute("pet") Pet pet, BindingResult result, HttpSession session){

			Collection<Pet> npet = new ArrayList<Pet>();
			String petName = pet.getPetName();
			npet = petService.getPetDetails(pet.getPetName());

			ModelAndView mv = new ModelAndView("link");
			mv.addObject("npet", npet);
			return mv;
		} 

		//displays links of all matching petOwners with the name entered and their pets are displayed across them  //
		@RequestMapping("/petSearch_ownerLink")
		public ModelAndView searchOwnerLink(@ModelAttribute("petOwner") PetOwner owner, BindingResult result, HttpSession session){
					
			Collection<PetOwner> npetOwner =  new ArrayList<PetOwner>();
			Collection<Pet> pt = new ArrayList<Pet>();
			String ownerName = owner.getOwnerName();
					
			npetOwner = petService.getPetOwnerDetails(ownerName);
					
			ModelAndView mv = new ModelAndView("link");
			mv.addObject("npetOwner", npetOwner);
			return mv;
		} 
		
		//This page allows to search the owner to add pet to it
		@RequestMapping("/searchOwner")
		public ModelAndView searchOwner(){
			 PetOwner petOwner = new PetOwner();
			 ModelAndView mv = new ModelAndView("searchOwner");
			 mv.addObject("petOwner", petOwner);
			 return mv;
		}

		//Fetches addPets page to add details of a new Pet
		@RequestMapping("/addPets")
		public ModelAndView addPets(PetOwner owner){
			 Integer oid = owner.getOid();
			 Pet pet = new Pet();
			
			 ModelAndView mv = new ModelAndView("addPets");
			 mv.addObject("oid", oid);
			 mv.addObject("pet", pet);
			 mv.addObject("petOwner", owner);
			 return mv;
		}

		// adds pet to its respective PetOwner and saves in the database
		@RequestMapping(value="/addNewPet", method=RequestMethod.POST)
		public ModelAndView addNewPet(@Valid @ModelAttribute("pet") Pet pet,BindingResult result, HttpSession session){

			 PetOwner petOwner = new PetOwner();
			 Integer poid = pet.getPoid();
			 PetOwner po = petService.getPetOwner(poid);

					if(result.hasErrors()){
						Pet newPet = new Pet();
						ModelAndView mv = new ModelAndView("addPets");
						mv.addObject("oid", poid);
						mv.addObject("pet", newPet);
						mv.addObject("petOwner", po);
						return mv;	
					}
					else
					{
						List<Pet> hs = new ArrayList();
						hs.add(pet);
						PetOwner pr = null;
						
						PetOwner pto1 = new PetOwner(po.getOwnerName(),po.getAddress(), po.getCity(),po.getTelephone(), hs);
						petService.updatePetOwnerWithPet(poid, pto1,hs);
									 
						ModelAndView mv = new ModelAndView("addPets");
							mv.addObject("petTest", pet);
							mv.addObject("petOwner", petOwner);
							return mv;
					}
			}

		//Fetches addPetOwner page to add details of a new Petowner 
		@RequestMapping("/addPetowner")
		public ModelAndView addPetowner(){
					
			 PetOwner petOwner = new PetOwner();
			 PetOwner ownerTest = null;
			 ModelAndView mv = new ModelAndView("addPetOwner");
				 mv.addObject("petOwner", petOwner);
				 mv.addObject("ownerTest",ownerTest);
				 return mv;
		}

		//Adds a new PetOwner details in the database
		@RequestMapping(value="/addNewPetOwner", method=RequestMethod.POST)
		public ModelAndView addOwner(@Valid @ModelAttribute("petOwner") PetOwner petOwner,BindingResult result, HttpSession session){		
					if(result.hasErrors()){
						PetOwner owner = new PetOwner();
						ModelAndView mv = new ModelAndView("addPetOwner");
						mv.addObject("petOwner", owner);
						 return mv;	
	             	}
							
					else{
						 Integer owner_coll = petService.addPetOwner(petOwner);
						 ModelAndView mv = new ModelAndView("addPetOwner");
						 mv.addObject("ownerTest",petOwner);
						 return mv;
					}
		}


		// This page allows to add Pet to its respective PetOwner
		@RequestMapping("/owners")
		public ModelAndView owners(@ModelAttribute("PetOwner") PetOwner owner, BindingResult result, HttpSession session){

			String ownerName = owner.getOwnerName();
			Collection<PetOwner> ownerColl = petService.getPetOwnerDetails(ownerName);
					
			ModelAndView mv = new ModelAndView("owners");
				mv.addObject("ownerColl", ownerColl);
				return mv;
		}

		//The page gives all the details of the Pet
		@RequestMapping(value="/linkPet",method=RequestMethod.GET)
		public ModelAndView petview(Pet pet ,BindingResult result, HttpSession session){
							System.out.println("outside inside petview controller, value of pet" +pet);
			Integer pid = pet.getPid();
			System.out.println("outside inside petview controller, value of pet pid" +pid);
			
			Pet npet = petService.getPet(pid);
			System.out.println("else part inside petview controller, value of npet" +npet);

			//Brings the page to main Pet Management page on clicking cancel button after deleting the Pet
			if (npet == null) 
			{
				Pet newPet = new Pet();
				PetOwner newPetOwner = new PetOwner();
				System.out.println("if inside petview controller, value of pet" +pet);

				ModelAndView mv = new ModelAndView("petsrch");
				mv.addObject("pet", newPet);
				mv.addObject("petOwner", newPetOwner);
				return mv;
			}
			else
			{
			System.out.println("else part inside petview controller, value of pet" +pet);
			System.out.println("else part inside petview controller, value of pet pid" +pet.getPid());

			PetOwner po = npet.getPetOwner();
			String ownerName = po.getOwnerName();

			ModelAndView mv = new ModelAndView("petview");
				mv.addObject("npet", npet);
				mv.addObject("ownerName", ownerName);
				return mv;
			}
		}

		//The page gives all the details of the PetOwner
		@RequestMapping(value="/linkOwner")
		public ModelAndView ownerView(PetOwner owner ,BindingResult result, HttpSession session){
			Integer oid = owner.getOid();
			PetOwner petOwner = petService.getPetOwner(oid);
			System.out.println("outside, ownerView controller, value of pet" +petOwner);
			
			//Brings the page to main Pet Management page on clicking cancel button after deleting the PetOwner
			if (petOwner == null)
			{
				Pet newPet = new Pet();
				PetOwner newPetOwner = new PetOwner();
				System.out.println("if,inside ownerView controller, value of pet" +petOwner);

				ModelAndView mv = new ModelAndView("petsrch");
				mv.addObject("pet", newPet);
				mv.addObject("petOwner", newPetOwner);
				return mv;
			}
			else
			{				
			System.out.println("else, inside ownerView controller, value of pet" +petOwner);
			ModelAndView mv = new ModelAndView("viewOwnerDetails");
				mv.addObject("petOwner", petOwner);
				return mv;
			}
		}
		
		//The page shows all the visit history of the Pet 			
		@RequestMapping(value="/petviewToVisitations", method=RequestMethod.GET)
		public ModelAndView visitations(Pet pet){
			int pid = pet.getPid();
			PetnOwnerDto petnOwnerDto = new PetnOwnerDto();
			Collection<Visit> nvisit = new ArrayList<Visit>();

			pet = petService.getPet(pid);
			nvisit = pet.getVisits();
			
			ModelAndView mv = new ModelAndView("Visitation");
				mv.addObject("petnOwnerDto", petnOwnerDto);
				mv.addObject("pet", pet);
				mv.addObject("nvisit", nvisit);
				return mv;
		}

		//The page brings a Visit Form to add a new visit details of the Pet 			
		@RequestMapping("/petviewToVisitForm")
		public ModelAndView visitForm(Pet pet,BindingResult result, HttpSession sessio){

			int pid = pet.getPid();
			PetnOwnerDto petnOwnerDto = new PetnOwnerDto();
			Collection<Visit> nvisit = new ArrayList<Visit>();
			Visit testVisit = null;

			pet = petService.getPet(pid);
	
			nvisit = pet.getVisits();
				
	
			ModelAndView mv = new ModelAndView("visit");
				mv.addObject("pet", pet);
				mv.addObject("petnOwnerDto", petnOwnerDto);
				mv.addObject("testVisit", testVisit);
				return mv;
		}

		//The page adds a new visit info of the Pet in the database			
		@RequestMapping(value="/addVisits", method=RequestMethod.POST)
		public ModelAndView addPetWithVisits(@ModelAttribute("petnOwnerDto") PetnOwnerDto petnOwnerDto,BindingResult result, HttpSession session){

			 Pet pet = new Pet();
			 Integer pid = petnOwnerDto.getPid();
			String visitDate = petnOwnerDto.getVisitDate();
			String description = petnOwnerDto.getDescription();
			Visit visit = new Visit(visitDate, description);
	
			 List<Visit> hs = new ArrayList();
				 hs.add(visit);
			
			 petService.updatePetWithVisits(pid, hs);
			 pet = petService.getPet(pid);

			ModelAndView mv = new ModelAndView("visit");
				mv.addObject("pet", pet);
				mv.addObject("petnOwnerDto", petnOwnerDto);
				mv.addObject("testVisit", visit);
				return mv;
		}

		// It brings an edit form to update the details of PetOwner
		@RequestMapping(value="/ownerUpdateForm", method=RequestMethod.POST)
		public ModelAndView ownerUpdateForm(@ModelAttribute("petOwner")PetOwner owner,BindingResult result, HttpSession session){
			int oid = owner.getOid();
			PetOwner po = null;
			PetOwner ownerObject = null;
				
			po = petService.getPetOwner(oid);

			ModelAndView mv = new ModelAndView("ownerUpdateForm");
				mv.addObject("po", po);
				mv.addObject("ownerObject", ownerObject);
				return mv;
		}

		// It updates the details of PetOwner in the database
		@RequestMapping(value="/ownerUpdate", method=RequestMethod.POST)
		public ModelAndView ownerUpdate(@ModelAttribute("po")PetOwner owner,BindingResult result, HttpSession session){
			int oid = owner.getOid();
			PetOwner ownerObject = new PetOwner();
			String name = owner.getOwnerName();
			String address = owner.getAddress();
			String city = owner.getCity();
			String telephone = owner.getTelephone();
				
			ownerObject = petService.updatePetOwner(oid, name, address, city, telephone);

			ModelAndView mv = new ModelAndView("ownerUpdateForm");
				mv.addObject("po", owner);
				mv.addObject("ownerObject", ownerObject);			
				return mv;
		}


		//fetches petUpdateForm to edit Pet details
		@RequestMapping(value="/petviewToUpdatePet", method=RequestMethod.GET)
		public ModelAndView petUpdateForm(Pet pet,BindingResult result, HttpSession session){
			int pid = pet.getPid();
			PetOwner po = null;
			Pet petObject = new Pet();
			String ownername = null;

			pet = petService.getPet(pid);
			po = pet.getPetOwner();
			ownername = po.getOwnerName();
			
			ModelAndView mv = new ModelAndView("petUpdate");
				mv.addObject("pet", pet);
				mv.addObject("ownername", ownername);
				mv.addObject("petObject", petObject);
				return mv;
		}

		// It updates the details of Pet in the database
		@RequestMapping(value="/petUpdate", method=RequestMethod.POST)
		public ModelAndView petUpdate(@ModelAttribute("petObject")Pet pet,BindingResult result, HttpSession session){
			int pid = pet.getPid();
			String pname = pet.getPetName();
			String type = pet.getType();
			String date = pet.getBirthdate();

			Pet petUpdate = petService.updatePet(pid,pname, type,date);
		
			ModelAndView mv = new ModelAndView("petUpdate");
				mv.addObject("petObject", pet);	
				mv.addObject("pet", pet);				 
				mv.addObject("petUpdate", petUpdate);	
				return mv;
		}
		//It shows a Pet delete page to delete Pet
		@RequestMapping(value="/petviewToDeletePet", method=RequestMethod.GET)
		public ModelAndView deletePetForm(Pet pet,BindingResult result, HttpSession session){
			int pid = pet.getPid();
			PetOwner po = null;
			String ownername = null;

			pet = petService.getPet(pid);
			po = pet.getPetOwner();
			ownername = po.getOwnerName();
			
			ModelAndView mv = new ModelAndView("petDelete");
				mv.addObject("pet", pet);
				mv.addObject("ownername", ownername);
				return mv;
		}

		//It shows a PetOwner delete page to delete PetOwner
		@RequestMapping(value="/deletePetOwnerForm")
		public ModelAndView deletePetOwnerForm(PetOwner petOwner){
			int oid = petOwner.getOid();
			PetOwner po = null;
			po = petService.getPetOwner(oid);
			
			ModelAndView mv = new ModelAndView("petOwnerDeleteForm");
				mv.addObject("petOwner", po);
				return mv;
		}
		
		//It deletes the selected PetOwner from the database along with his Pets and their visit informations
		@RequestMapping(value="/deleteOwner", method=RequestMethod.POST)
		public ModelAndView deletePetOwner(@ModelAttribute("petOwner")PetOwner petOwner,BindingResult result, HttpSession session){
		
				int oid = petOwner.getOid();
				PetOwner poDao = null;

				poDao = petService.getPetOwner(oid);
				petService.deletePetOwner(oid);

				ModelAndView mv = new ModelAndView("petOwnerDeleteForm");
					mv.addObject("petOwner", poDao);
					mv.addObject("petOwnerTest", poDao);
					return mv;
		}

		//It deletes the selected Pet from the database along with its visiting informations
		@RequestMapping(value="/deletePet", method=RequestMethod.POST)
		public ModelAndView deletePet(@ModelAttribute("pet")Pet pet,BindingResult result, HttpSession session){
				int pid = pet.getPid();
				PetOwner po = null;

				Pet ptdao = petService.getPet(pid);
				petService.deleteVisitHistory(pid);
				
				po = ptdao.getPetOwner();
				Integer oid = po.getOid();
				petService.deletePetFromOwner(oid, ptdao);
			
				ModelAndView mv = new ModelAndView("petDelete");
					mv.addObject("petTest", ptdao);	
					mv.addObject("pet", ptdao);	
					return mv;
			
		}
    };			