   package com.petclinic.dao;

   import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.petclinic.entity.Speciality;
import com.petclinic.entity.Vet;



	@Repository
	public class VetDao extends BaseDao {
		/*private static SessionFactory sessionFactory;

		  public static void main(String[] args){
				try
				{
					sessionFactory = new AnnotationConfiguration().configure().addPackage("com.petclinic.entity").addAnnotatedClass(Vet.class).addAnnotatedClass(Speciality.class).buildSessionFactory();
				}
				catch(Exception e)
				{
					throw new ExceptionInInitializerError(e);
				}

				VetDao vd = new VetDao();
	
				List<Speciality> sp1 = new ArrayList<Speciality>();
				sp1.add(new Speciality("Dermatology"));
				sp1.add (new Speciality("Behaviour"));

				List<Speciality> sp2 = new ArrayList<Speciality>();
				sp2.add(new Speciality("Dentistry"));

				List<Speciality> sp3 = new ArrayList<Speciality>();
				sp3.add(new Speciality("Anesthesia"));

				List<Speciality> sp4 = new ArrayList<Speciality>();
				sp4.add(new Speciality("Surgery")); 
				sp4.add(new Speciality("Gynaecologist")); 

				List<Speciality> sp5 = new ArrayList<Speciality>();
				sp5.add(new Speciality("Dentistry"));

			
				List<Speciality> sp6 = new ArrayList<Speciality>();
				sp6.add(new Speciality("Dermatology"));
				sp6.add (new Speciality("Behaviour"));


				Integer vet1 = vd.addVet(new Vet("Dr. Singh", sp1));
				Integer vet2 = vd.addVet(new Vet("Dr. Vihaan", sp2));
				Integer vet3 = vd.addVet(new Vet("Dr. Chitra", sp3));
				Integer vet4 = vd.addVet(new Vet("Dr. Rakhi Kapoor", sp4));
				Integer vet5 = vd.addVet(new Vet("Dr. Swati", sp5));
				Integer vet6 = vd.addVet(new Vet("Dr. Ankita ", sp6));


			}*/


		public Collection<Vet> getVet(String vetName){
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				List<Vet> result = new ArrayList<Vet>();

				try
				{
					tx = session.beginTransaction();
					Query query = session.createQuery("From com.petclinic.entity.Vet where vetName like ?");
					query.setString(0, "%"+vetName +"%");
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
				
		}

		public Integer addVet(Vet vet){
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				Integer id = null;
				try
				{
					tx = session.beginTransaction();
					id = (Integer)session.save(vet);
					System.out.println("showing entry of id :"+id);
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

		public Integer addSpeciality(Speciality speciality){
			
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				Integer id = null;
				try
				{
					tx = session.beginTransaction();
					id = (Integer)session.save(speciality);
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
					System.out.println("Closing session addSpeciality");
					session.close();
				}
				return id;
			
		}

		public Collection<Speciality> getSpeciality(String specialityName){
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				String speciality_name = null;
				List<Speciality> result = new ArrayList<Speciality>();
					
				try
				{
					tx = session.beginTransaction();
					Query query = session.createQuery("From com.petclinic.entity.Speciality where specialityName like ?");
					query.setString(0,"%"+specialityName+"%");
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
		}

	}
			
