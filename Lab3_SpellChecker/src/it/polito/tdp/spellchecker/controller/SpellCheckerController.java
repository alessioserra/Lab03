package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	//Creo modello
	private Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea txtIn;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtOut;

    @FXML
    private Label errors;

    @FXML
    private Button btnClear;

    @FXML
    private Label time;
    
    public void setModel(Dictionary model) {
    	this.model=model;
    	//Definisco il comboBox
    	comboBox.getItems().addAll("English","Italian");
    }

    @FXML
    void doClearText(ActionEvent event) {

    }

    
    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	model.loadDictionary(comboBox.getValue());
    	
    	LinkedList<String> stringa = new LinkedList<String>();
    	String input =txtIn.getText().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", " ");
    	
        String array[]=input.split(" ");
        
        for(int i=0; i<array.length;i++) {
        	stringa.add(array[i]);
        }
        
       List<RichWord> risultato = model.spellCheckText(stringa);
       
       List<String> output = new LinkedList<String>();
       
       for (RichWord r : risultato) {
    	   if (r.isCorretta()==false) output.add(r.getParola());
       }
       
       int contatore=0;
       
       //Output della TextArea
       for (String o : output) {
    	   txtOut.appendText(o);
    	   contatore++;
       }
       
       errors.setText("ci sono " + contatore + "errori!");
        
    }

    @FXML
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtIn != null : "fx:id=\"txtIn\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtOut != null : "fx:id=\"txtOut\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert errors != null : "fx:id=\"errors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}
