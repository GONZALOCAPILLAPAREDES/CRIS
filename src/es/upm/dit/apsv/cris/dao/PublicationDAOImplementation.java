package es.upm.dit.apsv.cris.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.apsv.cris.model.Publication;
import es.upm.dit.apsv.cris.model.Publication;

public class PublicationDAOImplementation implements PublicationDAO {
	
	private static PublicationDAOImplementation instance = null;
	private PublicationDAOImplementation() {}
	public static PublicationDAOImplementation getInstance() {
	    if( null == instance ) {
	        instance = new PublicationDAOImplementation();
	    }
	    return instance;
	}

	@Override
	public Publication create(Publication Publication) {
		
		Session session = SessionFactoryService.get().openSession();
		try {
		   session.beginTransaction();
		   session.save(Publication);
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return Publication;
	}

	@Override
	public Publication read(String PublicationId) {
		
		Publication Publication= null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
		   session.beginTransaction();
		   Publication = session.get(Publication.class, PublicationId);
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return Publication;
	
	}

	@Override
	public Publication update(Publication Publication) {
		
		Session session = SessionFactoryService.get().openSession();
		try {
		   session.beginTransaction();
		   session.saveOrUpdate(Publication);
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return Publication;
	}

	@Override
	public Publication delete(Publication Publication) {
		
		Session session = SessionFactoryService.get().openSession();
		try {
		   session.beginTransaction();
		   session.delete(Publication);
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return Publication;
	}

	@Override
	public List<Publication> readAll() {
		
		List<Publication> PublicationsList = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		
		try {
		   session.beginTransaction();
		   PublicationsList = session.createQuery("from Publication").list();
		   session.getTransaction().commit();
		} catch (Exception e) {
		   // handle exceptions
		} finally {
		   session.close();
		}
		
		return PublicationsList;
	
	}




}
