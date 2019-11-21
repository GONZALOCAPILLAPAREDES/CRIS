package es.upm.dit.apsv.cris.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;

import es.upm.dit.apsv.cris.model.Researcher;

public class ResearcherDAOImplementation implements ResearcherDAO {
	
	
	private static ResearcherDAOImplementation instance = null;
	private ResearcherDAOImplementation() {}
	public static ResearcherDAOImplementation getInstance() {
	    if( null == instance ) {
	        instance = new ResearcherDAOImplementation();
	    }
	    return instance;
	}

	@Override
	public Researcher create(Researcher researcher) {
		
		Session session = SessionFactoryService.get().openSession();
		try {
		   session.beginTransaction();
		   session.save(researcher);
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return researcher;
	}

	@Override
	public Researcher read(String researcherId) {
		
		Researcher researcher= null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
		   session.beginTransaction();
		   researcher = session.get(Researcher.class, researcherId);
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return researcher;
	
	}

	@Override
	public Researcher update(Researcher researcher) {
		
		Session session = SessionFactoryService.get().openSession();
		try {
		   session.beginTransaction();
		   session.saveOrUpdate(researcher);
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return researcher;
	}

	@Override
	public Researcher delete(Researcher researcher) {
		
		Session session = SessionFactoryService.get().openSession();
		try {
		   session.beginTransaction();
		   session.delete(researcher);
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return researcher;
	}

	@Override
	public List<Researcher> readAll() {
		
		List<Researcher> researchersList = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		
		try {
		   session.beginTransaction();
		   researchersList = session.createQuery("from Researcher").list();
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return researchersList;
	
	}

	@Override
	public Researcher readAsUser(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 Researcher researcher = (Researcher) session.
		 createQuery("select r from Researcher r where r.email= :email and r.password = :password").
		 setParameter("email", email).
		 setParameter("password", password).
		 uniqueResult();
		 session.getTransaction().commit();
		 session.close();
		 return researcher;
	}

}
