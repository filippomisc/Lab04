package it.polito.tdp.lab04.model;

import java.util.HashMap;
import java.util.Map;


public class StudenteIdMap {
	
	private Map<Integer, Studente> map;
	
	public StudenteIdMap() {
		map = new HashMap<>();
	}
	
	public Studente get(int studenteId) {
		return map.get(studenteId);
	}
	
	public Studente get(Studente studente) {
		Studente old = map.get(studente.getMatricola());
		if (old == null) {
			map.put(studente.getMatricola(), studente);
			return studente;
		}
		return old;
	}
	
	public void put(Studente studente, int studenteId) {
		map.put(studenteId, studente);
	}

}
