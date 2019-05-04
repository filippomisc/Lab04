package it.polito.tdp.lab04.model;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	CorsoDAO corsoDAO =null;
	StudenteDAO studenteDAO =null;
	
	List<Studente> studenti;
	List<Corso> corsi;
	
	
	StudenteIdMap studenteIdMap;
	CorsoIdMap corsoIdMap;
	
	
	public Model() {
		corsoDAO= new CorsoDAO();
		studenteDAO = new StudenteDAO();
		
		studenteIdMap= new StudenteIdMap();
		corsoIdMap=new CorsoIdMap();
		
		corsi= corsoDAO.getTuttiICorsi();
	

		
	}


	public List<Corso> getCorsi() {
		return corsi;
	}


	public Studente cercaStudente(int matricola) {

		return studenteDAO.cercaStudente(matricola);
	}


	public List<Studente> cercaIscrittiCorso(Corso corso) {
		
		List<Studente> result = null;
		if(corso.getNome().compareTo("Tutti")==0) {
			result = corsoDAO.getTuttiStudentiIscritti();
		}else {
			result = corsoDAO.getStudentiIscrittiAlCorso(corso);
		}
		
		

		return result;
		
	}
	
	public boolean isIscritto(Corso corso,Studente studente) {
		
		boolean result =false;
		
		for(Studente s :corsoDAO.getStudentiIscrittiAlCorso(corso)){
			if(studente.equals(s)) {
				result =true;
			}
		}
		return result;
	}


	public List<Corso> cercaCorsi(Studente studente) {
		
		return studenteDAO.cercaCorsi(studente);
		
	}
	
	

}
