package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class Parole {
	
	private List<String> elencoParole;  
	private List<String> elencoWords;
	
	
	public Parole() { 						
		elencoParole = new ArrayList<String>();
		elencoWords = new LinkedList<String>();
	}
	
	/**
	 * aggiunge la nuova parola all'elenco di parole
	 * @param p
	 */
	public void addParola(String p) {
	 elencoParole.add(p); //aggiungo la parola passata come parametro alla lista di parole
	 
	}
	
	public void addParola2(String p) {
		 elencoWords.add(p);
		}
	
	/**
	 * Restituisce l'elenco delle parole inserite ordinate alfabeticamente
	 * @return
	 */
	
	public List<String> getElenco() { 
		Collections.sort(elencoParole);
		return elencoParole;
		}
	
	
	public void reset() { 
		elencoParole.clear();
	}

	public void reset2() { 
		elencoWords.clear();
	}
	
	public List<String> getElencoWords(){
		Collections.sort(elencoWords);
		return elencoWords;
	}
	
	public void setElencoWords(List<String> elencoWords) {
		this.elencoWords = elencoWords;
	}

	public List<String> getElencoParole() {
		return elencoParole;
	}

	public void setElencoParole(List<String> elencoParole) {
		this.elencoParole = elencoParole;
	}

	
	
	/**
	 * Rimuove dalla lista elencoParole la parola passata come parametro
	 * @param string
	 */
	public void removeParola(String string) { 
		elencoParole.remove(string);
	}
	
	public void removeParola2(String string) { 
		elencoWords.remove(string);
	}
}
