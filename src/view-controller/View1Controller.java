package viewEnController;

import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Model;

public class View1Controller implements Observer{
    
    private Model m;
    
    public void setModel(Model m){
        this.m = m;
    }

    @FXML
    private Label label;

    @FXML
    void handleButtonUp(ActionEvent event) {
           m.setWaarde(m.getWaarde()+1);
    }

    @FXML
    void handleDown(ActionEvent event) {
        m.setWaarde(m.getWaarde()-1);

    }
    
    public void update(Observable arg0, Object arg1) {	 // Called from the Model
		label.setText(String.valueOf(m.getWaarde()));
	}

}
