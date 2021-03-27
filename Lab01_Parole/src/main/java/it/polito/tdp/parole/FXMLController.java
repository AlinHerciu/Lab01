package it.polito.tdp.parole;


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco; //creo fuori da qualsiasi metodo cosi questo è un oggetto persistente
	
	 @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtPerformance;

    @FXML
    private Button btnReset;
    
    /**
    * Cancella la parola selezionata
    *   @param event
    */
    @FXML
    void doCancella(ActionEvent event) { //devo passare al metodo removeParola la parola selezionata dal''utente
    	String selected = this.txtResult.getSelectedText(); //metodo nuovo
    	
    	double start= System.nanoTime();
    	elenco.removeParola(selected);
    	double stop= System.nanoTime();
    	
    	double start2= System.nanoTime();
    	elenco.removeParola2(selected);
    	double stop2= System.nanoTime();
    	
    	String result = "";
    	for(String p: elenco.getElenco()) {
      	  result += p +"\n";
        }
        
    	txtResult.setText(result);
    	
    	this.txtPerformance.clear();
    	txtPerformance.setText("Tempo di esecuzione operazione CANCELLA con ArrayList: "+ (stop - start)+" ms \n"+ 
    	"Tempo di esecuzione operazione CANCELLA con LinkedList: "+ (stop2 - start2)+" ms");
    }

    @FXML
    void doInsert(ActionEvent event) {
      double start= System.nanoTime();
      elenco.addParola(this.txtParola.getText()); //memorizza l'input dell'utente nella lista di elencoParole
      double stop= System.nanoTime();
      
      double start2= System.nanoTime();
      elenco.addParola2(this.txtParola.getText()); //memorizza l'input dell'utente nella lista di elencoParole
      double stop2= System.nanoTime();
      
      txtResult.clear();
      
      String result = "";
      for(String p: elenco.getElenco()) {
    	  result += p +"\n";
      }
      
      txtResult.setText(result);
      
      this.txtPerformance.clear();
      this.txtPerformance.setText("Tempo di esecuzione operazione INSERISCI con ArrayList: "+ (stop - start)+" ms \n" +
      "Tempo di esecuzione operazione INSERISCI con LinkedList: "+ (stop2 - start2)+" ms");
      this.txtParola.clear();
      }

    @FXML
    void doReset(ActionEvent event) {
    	double start= System.nanoTime();
    	elenco.reset();
    	double stop= System.nanoTime();
    	
    	double start2= System.nanoTime();
    	elenco.reset2();
    	double stop2= System.nanoTime();
    	this.txtResult.clear();
    	
        this.txtPerformance.clear();
        this.txtPerformance.setText("Tempo di esecuzione operazione RESET con ArrayList : "+ (stop - start)+" ms \n"+
        "Tempo di esecuzione operazione RESET con LinkedList : "+ (stop2 - start2)+" ms");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPerformance != null : "fx:id=\"txtPerformance\" was not injected: check your FXML file 'Scene.fxml'.";
     
        elenco = new Parole();
    }

	
    
}
