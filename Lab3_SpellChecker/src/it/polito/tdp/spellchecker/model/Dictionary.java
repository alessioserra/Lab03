package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

	List<String> dizionario = new LinkedList<String>();
	
	public void loadDictionary(String language) {
		
		try {
			FileReader fr = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine())!=null) {
				
				dizionario.add(word);
				
			}
			br.close();
		}catch (IOException e) {
			System.out.println("Errore nella lettura del file!");
		}	
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord> risultato = new LinkedList<RichWord>();
		
		for (String s : inputTextList) {
			if (dizionario.contains(s)==true) {
				risultato.add(new RichWord(s,true));	
			}
			else risultato.add(new RichWord(s,false));
		}
		return risultato;
	}
	
	public void pulisciDizionario() {
		
		List<String> temp = new LinkedList<String>();
		
		for (String s : dizionario) temp.add(s);
		
		dizionario.removeAll(temp);
	}
	
}
