package es.upm.dit.apsv.cris.dao;

import java.util.List;

import es.upm.dit.apsv.cris.model.Researcher;

public interface ResearcherDAO {
	public Researcher create( Researcher researcher );
	public Researcher read( String researcherId );
	public Researcher update( Researcher researcher );
	public Researcher delete( Researcher researcher );
	public List<Researcher> readAll();
	public Researcher readAsUser(String email, String password);
}
