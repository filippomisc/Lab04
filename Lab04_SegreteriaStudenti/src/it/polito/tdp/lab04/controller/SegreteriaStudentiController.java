/**
 * Sample Skeleton for 'SegreteriaStudenti.fxml' Controller Class
 */

package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboCorso"
    private ComboBox<Corso> comboCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscrittiCorso"
    private Button btnCercaIscrittiCorso; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaNome"
    private Button btnCercaNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscritto"
    private Button btnIscritto; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    void setModel(Model model) {
    	
    	this.model=model;
    	
    	Corso vuoto = new Corso("", "Tutti", 0, 0);
    	this.comboCorso.getItems().add(vuoto);

    	this.comboCorso.getItems().addAll(model.getCorsi());
    	
    }
    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	int matricola = Integer.parseInt(this.txtMatricola.getText());
    	Studente studente = model.cercaStudente(matricola);
    	
    	List<Corso> corsi = model.cercaCorsi(studente);
		StringBuilder sBuilder = new StringBuilder();

    	for (Corso corso : corsi) {
    		
    		sBuilder.append(String.format("%-10s", corso.getCodIns()));
    		sBuilder.append(String.format("%-50s", corso.getNome()));
    		sBuilder.append(String.format("%-15s", "crediti: " + corso.getCrediti()));
    		sBuilder.append(String.format("%-10s", "semestre: " + corso.getPd()));
    		sBuilder.append("\n");
		}

    	txtResult.setText(sBuilder.toString());
    }
    
    @FXML
    void doIsIscritto(ActionEvent event) {
    	
//    	try {
    	Corso corso = comboCorso.getValue();
    	
    	int matricola = Integer.parseInt(this.txtMatricola.getText());
    	Studente studente = model.cercaStudente(matricola);
    	
//    	if(studente==null) {
//    		txtResult.setText("studente non presente nel database");
//    	}else {
//    		this.txtNome.setText(studente.getNome());
//    		this.txtCognome.setText(studente.getCognome());
//    		}
    	
    	Boolean result =model.isIscritto(corso, studente);
    	
    	if(result==true)
    		txtResult.setText("lo studente è gia' iscritto al corso selezionato");
    	else
    		txtResult.setText("lo studente NON è iscritto al corso selezionato");

    
//    	}catch (NumberFormatException e) {
//			txtResult.setText("inserire la matricola nel formato corretto");
//		} catch (RuntimeException e) {
//			txtResult.setText("errore di caricamento del database");
//		}

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	try {

    		
    		this.txtResult.clear();
        	
        	Corso corso = comboCorso.getValue();
        	
//        	if(corso==null) {
//        		   txtResult.setText("scegliere un corso");
//        	}
        	List<Studente> list = model.cercaIscrittiCorso(corso);
    
        	for (Studente studente : list) {
        		txtResult.appendText(studente.toString()+"\n");
    		}
        	
        	
		} catch (NullPointerException e) {
 		   txtResult.setText("scegliere un corso");

		}
    }

    @FXML
    void doCercaNome(ActionEvent event) {
    	this.txtCognome.clear();
    	this.txtNome.clear();
    	this.txtResult.clear();
    	
    	try {
			
    		int matricola = Integer.parseInt(this.txtMatricola.getText());
        	
        	Studente studente = model.cercaStudente(matricola);
        	
        	if(studente==null) {
        		txtResult.setText("studente non presente nel database");
        	}else {
        		this.txtNome.setText(studente.getNome());
        		this.txtCognome.setText(studente.getCognome());
        		this.btnIscritto.setDisable(false);
        		this.btnCerca.setDisable(false);
        		}
		} catch (NumberFormatException e) {
			txtResult.setText("inserire la matricola nel formato corretto");
		} catch (RuntimeException e) {
			txtResult.setText("errore di caricamento del database");
		}
    	
    	

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
//TODO RESETTARE LA COMBO BOX
    	txtResult.clear();
    	txtCognome.clear();
    	txtNome.clear();
    	txtMatricola.clear();
    	btnIscritto.setDisable(true);
    	
    	
    
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscritto != null : "fx:id=\"btnIscritto\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

     // Utilizzare questo font per incolonnare correttamente i dati
        txtResult.setStyle("-fx-font-family: monospace");
//        comboCorso.setStyle("-fx-font-family: monospace");
        
        
    }
}
