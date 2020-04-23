package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	Map<String, Boolean> mappaParole = new HashMap<String, Boolean>();
	Ricerca r= new Ricerca();
	AnagrammaDAO a= new AnagrammaDAO();
	List<String> listaA = new LinkedList<>();
	boolean trovato = false;
	
	public Map<String, Boolean> getMap( String parola) {
		
		listaA = r.anagrammi(parola);
		for(int i=0; i<listaA.size(); i++) {
			trovato = a.isCorrect(listaA.get(i));
			mappaParole.put(listaA.get(i), trovato);
		}
		return mappaParole;
	}
	
}
