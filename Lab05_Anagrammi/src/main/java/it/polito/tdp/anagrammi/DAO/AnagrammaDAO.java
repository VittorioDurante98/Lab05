package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		String sql = "SELECT * FROM parola WHERE nome=?";
		boolean trovato = false;
		List<String> trovatoValore = new LinkedList<>();
		try {
			Connection conn = ConnectDb.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String s = rs.getString("nome");
				trovatoValore.add(s);
			}

			if(trovatoValore.size()==1)
				trovato=true;
			
			conn.close();
			
			return trovato;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	}


