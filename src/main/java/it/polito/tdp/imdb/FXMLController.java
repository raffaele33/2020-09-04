/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.imdb;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.imdb.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="btnGrandoMax"
    private Button btnGrandoMax; // Value injected by FXMLLoader

    @FXML // fx:id="btnCammino"
    private Button btnCammino; // Value injected by FXMLLoader

    @FXML // fx:id="txtRank"
    private TextField txtRank; // Value injected by FXMLLoader

    @FXML // fx:id="cmbMovie"
    private ComboBox<?> cmbMovie; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCammino(ActionEvent event) {

    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	txtResult.clear();
    	double r;
    	try {
    		r = Double.parseDouble(txtRank.getText());
    			if(r<0.0 || r>10.0) {
    				txtResult.appendText("inserire un valore valido compreso tra 0.0 e 10.0 ");
    				return;
    			}
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire un valore numerico!");
    		return;
    	}
    	
    	this.model.CreaGrafo(r);
    	txtResult.appendText("Grafo creato!\n");
    	txtResult.appendText("# VERTICI: " + this.model.nVertici() + "\n");
    	txtResult.appendText("# ARCHI: " + this.model.nArchi());
    }

    @FXML
    void doGradoMax(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText(" film di grado massimo : "+this.model.getBest().toString());
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnGrandoMax != null : "fx:id=\"btnGrandoMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCammino != null : "fx:id=\"btnCammino\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRank != null : "fx:id=\"txtRank\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbMovie != null : "fx:id=\"cmbMovie\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
