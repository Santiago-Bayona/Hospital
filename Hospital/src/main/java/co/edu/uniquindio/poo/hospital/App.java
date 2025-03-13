package co.edu.uniquindio.poo.hospital;

import co.edu.uniquindio.poo.hospital.Model.Doctor;
import co.edu.uniquindio.poo.hospital.Model.Hospital;
import co.edu.uniquindio.poo.hospital.Model.Medicamento;
import co.edu.uniquindio.poo.hospital.ViewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class App extends Application {
    public static Hospital hospital = new Hospital("San Juan de Dios");
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bienvenido");
        openViewPrincipal();
    }

    public void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Bienvenido.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            BienvenidoVC primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void MenuPersona() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("MenuPersona.fxml"));
            Pane rootLayout = (Pane) loader.load();
            MenuPersonaVC menuPVC = loader.getController();
            menuPVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void MenuOtros() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("MenuOtros.fxml"));
            Pane rootLayout = (Pane) loader.load();
            MenuOtrosVC menuOVC = loader.getController();
            menuOVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Doctor() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Doctor.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DoctorVC doctorVC = loader.getController();
            doctorVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Paciente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Paciente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PacienteVC pacienteVC = loader.getController();
            pacienteVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Medicamento() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Medicamento.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MedicamentoVC medicamentoVC = loader.getController();
            medicamentoVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Historial() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("HistorialMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HistorialMedicoVC historialMedicoVC = loader.getController();
            historialMedicoVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void MenuProcedimiento() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("MenuProcedimiento.fxml"));
            Pane rootLayout = (Pane) loader.load();
            MenuProcedimientoVC menuProcedimientoVC = loader.getController();
            menuProcedimientoVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void CitaMedica() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CitaMedica.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CitaMedicaVC citaMedicaVC = loader.getController();
            citaMedicaVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Consulta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Consulta.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ConsultaVC consultaVC = loader.getController();
            consultaVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void inicializarData() {
        Doctor doctor = new Doctor("1455","Ramiro","gonzalez",47,Doctor.Especialidad.NEUMOLOGIA);
        hospital.agregarDoctor(doctor);
        Medicamento medicamento= new Medicamento("4554","acteaminofen",10.0);
        hospital.agregarMedicamento(medicamento);

    }
}