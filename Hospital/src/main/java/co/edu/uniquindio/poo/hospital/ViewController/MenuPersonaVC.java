package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPersonaVC {
    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Doctor;

    @FXML
    private Button btt_Volver;

    @FXML
    private Button btt_Paciente;


    @FXML
    void RegistrarPaciente(ActionEvent event) {
        try {
            app.Paciente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void RegistrarDoctor(ActionEvent event) {
        try {
            app.Doctor();
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
        assert btt_Doctor != null : "fx:id=\"btt_Doctor\" was not injected: check your FXML file 'MenuPersona.fxml'.";
        assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'MenuPersona.fxml'.";
        assert btt_Paciente != null : "fx:id=\"btt_Paciente\" was not injected: check your FXML file 'MenuPersona.fxml'.";

    }
}

