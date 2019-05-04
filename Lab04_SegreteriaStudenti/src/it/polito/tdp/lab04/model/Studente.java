package it.polito.tdp.lab04.model;

public class Studente {
	
	private int matricola;
	private String nome;
	private String cognome;
	private String cds;
	
	public Studente(int matricola, String nome, String cognome, String cds) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cds = cds;
	}

	public int getMatricola() {
		return matricola;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCds() {
		return cds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricola;
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
		Studente other = (Studente) obj;
		if (matricola != other.matricola)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%-10s ", matricola));
		builder.append(String.format("%-20s ", nome));
		builder.append(String.format("%-20s ", cognome));
		builder.append(String.format("%-10s ", cds));
		return builder.toString();
	}
	
	
	
}
