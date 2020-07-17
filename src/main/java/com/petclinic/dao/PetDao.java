   package com.petclinic.dao;
   import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.petclinic.entity.Pet;
import com.petclinic.entity.PetOwner;
import com.petclinic.entity.Visit;

   @Repository
   public class PetDao extends BaseDao{
		 /*private static SessionFactory sessionFactory;

		 public static void main(String[] args){
			try
			{
			sessionFactory = new AnnotationConfiguration().configure().addPackage("com.petclinic").addAnnotatedClass(Pet.class).addAnnotatedClass(PetOwner.class).addAnnotatedClass(Visit.class).buildSessionFactory();
			}
			catch(Exception e)
			{
			throw new ExceptionInInitializerError(e);
			}

		}*/
			
				
   public Collection<Pet> getPetDetails(String pname){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Pet> result = new ArrayList<Pet>();
				try
				{
					tx = session.beginTransaction();
					Query query = session.createQuery("From com.petclinic.entity.Pet where petName like ?");
					query.setString(0,"%"+pname+"%");
					result = query.list();
					System.out.println("Inside PetDao: HELLO PetName!!!!!!!!!!");
					tx.commit();
				}
				catch(HibernateException e)
				{
					if(tx!= null)
					tx.rollback();
					System.out.println(e);
				} 
				finally
				{
					session.close();
				}
		return result;
				
	}

   public Collection<PetOwner> getPetOwnerDetails(String oname){
				
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<PetOwner> result = new ArrayList<PetOwner>();
	
				try
				{
					tx = session.beginTransaction();
					Query query = session.createQuery("From com.petclinic.entity.PetOwner where ownerName like ?");
					query.setString(0,"%"+oname+"%");
					result = query.list();
					System.out.println("Inside PetDao: HELLO OwnerName!!!!!!!!!!");
					tx.commit();
				
				}
				catch(HibernateException e)
				{
					if(tx!= null)
					tx.rollback();
					System.out.println(e);
						
				} 
				finally
				{
				session.close();
				}
		return result;
				
	}
	//comment it			
  /* public Collection<PetOwner> ownerDetails(PetOwner petOwner){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		String ownerName = petOwner.getOwnerName();
		List<PetOwner> result = new ArrayList<PetOwner>();
														
				try
				{
					tx = session.beginTransaction();
					Query query = session.createQuery("From com.petclinic.PetOwner where ownerName like ?");
					query.setString(0,"%"+ownerName+"%");
					result = query.list();
					tx.commit();
				}
				catch(HibernateException e)
				{
					if(tx!= null)
					tx.rollback();
					System.out.println(e);
				} 
				finally
				{
					session.close();
				}
		return result;
				
	}*/

   public PetOwner getPetOwner(Integer poid){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		PetOwner po = null;													
				try
				{
					tx = session.beginTransaction();
					po = (PetOwner)session.get(PetOwner.class,poid);
					tx.commit();
				}
				catch(HibernateException e)
				{
					if(tx!= null)
					tx.rollback();
					System.out.println(e);
				} 
				finally
				{
					session.close();
				}
		return po;
	}

   public Pet getPet(Integer pid){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Pet pet = null;													
				try
				{
					tx = session.beginTransaction();
					pet = (Pet)session.get(Pet.class,pid);
					tx.commit();
				}
				catch(HibernateException e)
				{
					if(tx!= null)
					tx.rollback();
					System.out.println(e);
				} 
				finally
				{
					session.close();
				}
		return pet;
				
	}
	
   public Integer addPetOwner(PetOwner petOwner){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer id = null;
				try
				{
					tx = session.beginTransaction();
					id = (Integer)session.save(petOwner);
					tx.commit();
				}
				catch(HibernateException e)
				{
					if(tx != null)
					tx.rollback();
					System.out.println(e);
				}
				finally
				{
					System.out.println("Closing session");
					session.close();
						
				}
		return id;
	}

	public PetOwner updatePetOwnerWithPet(Integer id, PetOwner petOwner, List<Pet> hs){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		PetOwner po = null;
				try
				{
					tx = session.beginTransaction();
					PetOwner insessionOwner = (PetOwner)session.get(PetOwner.class, id);
					System.out.println("In petdao merge(), value of insessionowner n id :: "+insessionOwner +id);
					Collection<Pet> inSessionPets = insessionOwner.getPet();
					inSessionPets.addAll(hs);
					session.update(insessionOwner);
					tx.commit();
				}
				catch(HibernateException e)
				{
					if(tx != null)
					tx.rollback();
					System.out.println(e);
				}
				finally
				{
					System.out.println("Closing session");
					session.close();
				}
		return po;
			
	}
   
   public void updatePetWithVisits(Integer id, List<Visit> hs){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
				try
				{
					tx = session.beginTransaction();
					Pet insessionPet = (Pet)session.get(Pet.class, id);
					System.out.println("In petdao updatePetWithVisits, value of insessionPet n id :: "+insessionPet +id);
					Collection<Visit> inSessionVisits = insessionPet.getVisits();
					inSessionVisits.addAll(hs);
					session.update(insessionPet);
					tx.commit();
						
				}
				catch(HibernateException e)
				{
					if(tx != null)
					tx.rollback();
					System.out.println(e);
				}
				finally
				{
					System.out.println("Closing session");
					session.close();
						
				}
					
	}

   public Pet updatePet(Integer pid, String name, String type, String birthdate){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Pet pet = new Pet();
				try
				{
					tx= session.beginTransaction();
					pet = (Pet)session.get(Pet.class, pid);
					pet.setPetName(name);
					pet.setType(type);
					pet.setBirthdate(birthdate);
					session.update(pet);
					tx.commit();
				}

				catch(HibernateException e)
				{
					if(tx != null)
					tx.rollback();
					e.printStackTrace();
				}
				finally
				{
					session.close();
				}
		return pet;
	}

   public PetOwner updatePetOwner(Integer oid, String name, String address, String city, String telephone){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		PetOwner po = new PetOwner();
				try
				{
					tx= session.beginTransaction();
					po = (PetOwner)session.get(PetOwner.class, oid);
					po.setOwnerName(name);
					po.setAddress(address);
					po.setCity(city);
					po.setTelephone(telephone);
					session.update(po);
					tx.commit();
				}
				catch(HibernateException e)
				{
					if(tx != null)
					tx.rollback();
					e.printStackTrace();
				}
				finally
				{
					session.close();
				}
		return po;
	}


	public void deletePetOwner(Integer oid){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Collection<Pet> pc = new ArrayList<Pet>(); 
				try
				{
					tx= session.beginTransaction();
					PetOwner petOwner = (PetOwner)session.get(PetOwner.class, oid);
					pc = petOwner.getPet();

					for(Pet pet : pc){
						pet.getVisits().clear();
					}
					pc.clear();
					session.delete(petOwner);
					session.flush();
					session.clear();
					tx.commit();
				}

				catch(HibernateException e)
				{
					if(tx != null)
					tx.rollback();
					e.printStackTrace();
									
				}
				finally
				{
					session.close();
				}
	}
   public void deletePetFromOwner(Integer oid, Pet ptdao){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Collection<Pet> pets = new ArrayList<Pet>();
				try
				{						
					tx= session.beginTransaction();
					PetOwner petOwner = (PetOwner)session.get(PetOwner.class, oid);
					petOwner.getPet().remove(ptdao);
					System.out.println("removed pet from petowner collection");
					session.flush();
					session.clear();
					tx.commit();
				}
				catch(HibernateException e)
				{
					if(tx != null)
					tx.rollback();
					e.printStackTrace();
				}
				finally
				{
					session.close();
				}
	}


   public void deleteVisitHistory(Integer pid){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
				try
				{
					tx= session.beginTransaction();
					System.out.println("in deleteVisithistory session dao in visit");
					Pet pet = (Pet)session.get(Pet.class, pid);
					pet.getVisits().clear();
					session.flush();
					session.clear();
					tx.commit();
				}

				catch(HibernateException e)
				{
					if(tx != null)
					tx.rollback();
					e.printStackTrace();
				}
				finally
				{
					session.close();

				}
	}
};