package co.edu.uniquindio.poo.hospital.ViewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class MenuProcedimientoVC {

    App app;


        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btt_Consulta"
        private Button btt_Consulta; // Value injected by FXMLLoader

        @FXML // fx:id="btt_Volver"
        private Button btt_Volver; // Value injected by FXMLLoader

        @FXML // fx:id="btt_CitaMedica"
        private Button btt_CitaMedica; // Value injected by FXMLLoader


        @FXML
        void RegistrarCitaMedica(ActionEvent event) {
            try {
                app.CitaMedica();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @FXML
        void RegistrarConsulta(ActionEvent event) {
            try {
                app.Consulta();
            }catch (Exception e) {
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

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert btt_Consulta != null : "fx:id=\"btt_Consulta\" was not injected: check your FXML file 'MenuProcedimiento.fxml'.";
            assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'MenuProcedimiento.fxml'.";
            assert btt_CitaMedica != null : "fx:id=\"btt_CitaMedica\" was not injected: check your FXML file 'MenuProcedimiento.fxml'.";

        }
        
}
