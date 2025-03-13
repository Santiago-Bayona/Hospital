package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuOtrosVC {
    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Historial;

    @FXML
    private Button btt_Volver;

    @FXML
    private Button btt_Medicamento;


    @FXML
    void RegistrarHistorial(ActionEvent event) {
        try {
            app.Historial();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void RegistrarMedicamento(ActionEvent event) {
        try {
            app.Medicamento();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Volver(ActionEvent event) {
        try {
            app.openViewPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        assert btt_Historial != null : "fx:id=\"btt_Historial\" was not injected: check your FXML file 'MenuOtros.fxml'.";
        assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'MenuOtros.fxml'.";
        assert btt_Medicamento != null : "fx:id=\"btt_Medicamento\" was not injected: check your FXML file 'MenuOtros.fxml'.";

    }
}

