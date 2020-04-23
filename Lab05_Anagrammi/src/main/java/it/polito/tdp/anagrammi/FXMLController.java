package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Ricerca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	Map<String, Boolean> mappaA ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button tnAnagramma;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button tnReset;

    @FXML
    void doCalcolo(ActionEvent event) {
    	mappaA =  new HashMap<String, Boolean>(model.getMap(txtParola.getText()));
    	for(String s: mappaA.keySet()) {
    		if(mappaA.get(s)==true)
    			txtCorretti.appendText(s+"\n");
    		else
    			txtErrati.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tnAnagramma != null : "fx:id=\"tnAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tnReset != null : "fx:id=\"tnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		
		this.model=model;
		txtCorretti.setEditable(false);
		txtErrati.setEditable(false);
	}
}
