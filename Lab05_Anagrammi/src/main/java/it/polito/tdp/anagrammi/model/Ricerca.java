package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class Ricerca {
	
	List<String> listaAnagrammi;
	List<String> listaAnagrammiC;
	List<String> listaAnagrammiE;
	List<Character> caratteriDisp = new LinkedList<>();
	String parziale;
	int livello;
	public List<String> anagrammi(String parola) {
		this.listaAnagrammi= new LinkedList<>();
		parziale= "";
		caratteriDisp = getCaratteri(parola);
		livello=0;
	    this.ricorsiva(livello, parziale, caratteriDisp);
		
		return listaAnagrammi;
	}
	

	
	public List<Character> getCaratteri(String parola) {
		for(int i=0; i<parola.length(); i++) {
			char c= parola.charAt(i);
			caratteriDisp.add(c);
		}
		
		return caratteriDisp;

	}
	
	private void ricorsiva(int livello, String parziale, List<Character> caratteriDisp) {
		if(caratteriDisp.size()==0) {
			listaAnagrammi.add(parziale);
		}
		
		for(Character ch: caratteriDisp) {
			String tentativo = parziale + ch;
			
			List<Character> rim = new LinkedList<>(caratteriDisp);  
			rim.remove(ch);
			ricorsiva(livello+1, tentativo, rim);
		}
	}
	

}
