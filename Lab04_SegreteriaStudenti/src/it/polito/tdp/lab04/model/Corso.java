package it.polito.tdp.lab04.model;

public class Corso {
	
	private String codIns;
	private String nome;
	private int crediti;
	private int pd;
	
	
	public Corso(String codIns, String nome, int crediti, int pd) {
		super();
		this.codIns = codIns;
		this.nome = nome;
		this.crediti = crediti;
		this.pd = pd;
	}


	public String getCodIns() {
		return codIns;
	}


	public String getNome() {
		return nome;
	}


	public int getCrediti() {
		return crediti;
	}


	public int getPd() {
		return pd;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codIns == null) ? 0 : codIns.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codIns == null) {
			if (other.codIns != null)
				return false;
		} else if (!codIns.equals(other.codIns))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nome);
		return builder.toString();
	}
	
	
	

}
