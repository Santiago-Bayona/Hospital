package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BienvenidoVC {

    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Persona;

    @FXML
    private Button btt_Procedimiento;

    @FXML
    private Button btt_Otros;


    @FXML
    void AbrirPersona(ActionEvent event) {
        try {
            app.MenuPersona();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AbrirProcedimiento(ActionEvent event) {
        try {
            app.MenuProcedimiento();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void AbiriOtros(ActionEvent event) {
        try {
            app.MenuOtros();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        assert btt_Persona != null : "fx:id=\"btt_Persona\" was not injected: check your FXML file 'Bienvenido.fxml'.";
        assert btt_Procedimiento != null : "fx:id=\"btt_Procedimiento\" was not injected: check your FXML file 'Bienvenido.fxml'.";
        assert btt_Otros != null : "fx:id=\"btt_Otros\" was not injected: check your FXML file 'Bienvenido.fxml'.";

    }
}

