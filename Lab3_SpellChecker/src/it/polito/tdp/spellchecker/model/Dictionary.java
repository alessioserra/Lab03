package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

	List<RichWord> dizionario;
	
	public void loadDictionary(String language) {
		
		try {
			FileReader fr = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine())!=null) {
				
				//METODO
				
			}
			br.close();
		}catch (IOException e) {
			System.out.println("Errore nella lettura del file!");
		}	
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		return null;
	}
	
}
