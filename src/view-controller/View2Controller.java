package viewEnController;

import java.util.Observable;
import java.util.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import model.Model;

public class View2Controller implements Observer {

    private Model m;

    public void setModel(Model m) {
        this.m = m;
    }

    @FXML
    private Slider slider;

    /*@FXML
    void handleSlider(ActionEvent event) {
           m.setWaarde((int)slider.getValue());
    }
     */
    @FXML
    void initialize() { 
        // Handle Slider value change events.
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            m.setWaarde(newValue.intValue());
        });
    }

    public void update(Observable arg0, Object arg1) {	 // Called from the Model
        slider.setValue(m.getWaarde());
    }

}
