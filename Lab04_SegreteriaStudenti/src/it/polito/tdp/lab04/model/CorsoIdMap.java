package it.polito.tdp.lab04.model;

import java.util.HashMap;
import java.util.Map;


public class CorsoIdMap {
	
	private Map<String, Corso> map;
	
	public CorsoIdMap() {
		map = new HashMap<>();
	}
	
	public Corso get(String corsoId) {
		return map.get(corsoId);
	}
	
	public Corso get(Corso corso) {
		Corso old = map.get(corso.getCodIns());
		if (old == null) {
			map.put(corso.getCodIns(), corso);
			return corso;
		}
		return old;
	}
	
	public void put(Corso corso,String corsoId) {
		map.put(corsoId, corso);
	}

}
