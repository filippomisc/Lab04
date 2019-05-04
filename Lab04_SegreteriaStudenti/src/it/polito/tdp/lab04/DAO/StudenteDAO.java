package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> getTuttiGliStudenti(){
	
	final String sql = "SELECT * FROM studente";

	List<Studente> studenti = new LinkedList<Studente>();

	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			int matricola = rs.getInt("matricola");
			String cognome = rs.getString("cognome");
			String nome = rs.getString("nome");
			String CDS = rs.getString("CDS");

			System.out.println(matricola + " " + cognome + " " + nome + " " + CDS);

			
			// Aggiungi il nuovo oggetto Corso alla lista corsi
			studenti.add(new Studente(matricola, nome, cognome, CDS));
		}

		return studenti;

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db");
	}
	
	}

	public Studente cercaStudente(int matricola) {
		
		final String sql = "select *\n" + 
				"from studente s\n" + 
				"where s.matricola=?";

		Studente studente = null;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matr = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");

				System.out.println(matr + " " + cognome + " " + nome + " " + CDS);

				
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				studente = new Studente(matr, nome, cognome, CDS);
			}

			return studente;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public List<Corso> cercaCorsi(Studente studente) {
		final String sql = "select c.codins, c.nome, c.crediti, c.pd\n" + 
				"from iscrizione i, corso c\n" + 
				"where i.matricola=? and\n" + 
				"i.codins=c.codins";

		List<Corso> result = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, studente.getMatricola());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				String nome = rs.getString("nome");				
				int crediti = rs.getInt("crediti");
				int pd = rs.getInt("pd");

//				System.out.println(matr + " " + cognome + " " + nome + " " + CDS);

				
				result.add(new Corso(codins, nome, crediti, pd));
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}
