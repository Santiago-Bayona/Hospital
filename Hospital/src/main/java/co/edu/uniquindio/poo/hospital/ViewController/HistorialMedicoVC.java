package co.edu.uniquindio.poo.hospital.ViewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.Controller.HistorialMedicoController;
import co.edu.uniquindio.poo.hospital.Model.Consulta;
import co.edu.uniquindio.poo.hospital.Model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.Model.Paciente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HistorialMedicoVC {
    private App app;
    private ObservableList<HistorialMedico> listaHistorial = FXCollections.observableArrayList();
    private ObservableList<Consulta> listaConsultas = FXCollections.observableArrayList();
    private Consulta selectedConsulta;
    private HistorialMedico selectedHistorialMedico;
    HistorialMedicoController historialMedicoController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Consulta> tb_Consulta;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private TableColumn<HistorialMedico, String> tbc_CodigoHistorial;

    @FXML
    private Button btt_Clonar;

    @FXML
    private TableColumn<HistorialMedico, String> tbc_Consulta;

    @FXML
    private Button btt_Actualizar;

    @FXML
    private TableColumn<Consulta, String> tbc_CodigoConsulta;

    @FXML
    private TableView<HistorialMedico> tb_Historial;

    @FXML
    private Button btt_Volver;

    @FXML
    private TableColumn<Consulta, LocalDate> tbc_FechaConsulta;

    @FXML
    private Button btt_Agregar;

    @FXML
    private Button btt_Limpiar;

    @FXML
    private TextField txt_CodigoHistorial;

    /**
     * Agrega un nuevo historial médico.
     */
    @FXML
    void AgregarHistorial(ActionEvent event) {
        agregarHistorialMedico();
    }

    /**
     * Elimina el historial médico seleccionado.
     */
    @FXML
    void EliminarHistorial(ActionEvent event) {
        eliminarHistorial();
    }

    /**
     * Actualiza la información del historial médico seleccionado.
     */
    @FXML
    void ActualizarHistorial(ActionEvent event) {
        actualizarPaciente();
    }

    /**
     * Limpia los campos del formulario.
     */
    @FXML
    void LimpiarHistorial(ActionEvent event) {
        limpiarCamposHistorial();
    }

    /**
     * Clona el historial médico seleccionado.
     */
    @FXML
    void ClonarHistorial(ActionEvent event) {
        clonarHistorial();
    }

    /**
     * Regresa al menú principal.
     */
    @FXML
    void Volver(ActionEvent event) {
        try {
            app.MenuOtros();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método de inicialización de la vista.
     */
    @FXML
    void initialize() {
        assert tb_Consulta != null : "fx:id=\"tb_Consulta\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert tbc_CodigoHistorial != null : "fx:id=\"tbc_CodigoHistorial\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert btt_Clonar != null : "fx:id=\"btt_Clonar\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert tbc_Consulta != null : "fx:id=\"tbc_Consulta\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert tbc_CodigoConsulta != null : "fx:id=\"tbc_CodigoConsulta\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert tb_Historial != null : "fx:id=\"tb_Historial\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert tbc_FechaConsulta != null : "fx:id=\"tbc_FechaConsulta\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'HistorialMedico.fxml'.";
        assert txt_CodigoHistorial != null : "fx:id=\"txt_CodigoHistorial\" was not injected: check your FXML file 'HistorialMedico.fxml'.";

        historialMedicoController = new HistorialMedicoController(App.hospital);
        obtenerConsultas();
        obtenerHistorialMedico();
        initView();
    }

    /**
     * Obtiene la lista de consultas del sistema.
     */
    private void obtenerConsultas() {
        if (listaConsultas == null) {
            listaConsultas = FXCollections.observableArrayList();
        }

        Collection<Consulta> consultas = historialMedicoController.obtenerListaConsulta();
        if (consultas != null) {
            listaConsultas.setAll(consultas);
        } else {
            System.out.println("No se encontraron consultas.");
        }
    }

    /**
     * Obtiene la lista de historiales médicos del sistema.
     */
    private void obtenerHistorialMedico() {
        if (historialMedicoController != null) {
            listaHistorial.addAll(historialMedicoController.ObtnerListaHistorial());
        } else {
            System.err.println("PacienteController no está inicializado.");

        }
    }

    /**
     * Inicializa la vista con los datos cargados.
     */
    private void initView() {
        initDataBinding();
        obtenerHistorialMedico();
        tb_Historial.getItems().clear();
        tb_Historial.setItems(listaHistorial);
        tb_Consulta.setItems(listaConsultas);
        listenerSelectionHistorial();
        listenerSelectionConsulta();
    }

    /**
     * Configura el enlace entre los datos y la vista.
     */
    private void initDataBinding() {
        tbc_CodigoHistorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoHistorial()));
        tbc_CodigoConsulta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdConsulta()));
        tbc_FechaConsulta.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaConsulta()));
        tbc_Consulta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreConsultas()));


    }

    /**
     * Configura un listener para la selección de elementos en la tabla de historiales médicos
     */
    private void listenerSelectionHistorial() {
        tb_Historial.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedHistorialMedico = newSelection;
            mostraInformacionHistorial(selectedHistorialMedico);
        });
    }

    /**
     * Establece un listener para detectar la selección de una consulta en la tabla de consultas.
     * <p>
     * Cuando el usuario selecciona una consulta en la tabla, el objeto seleccionado se
     * asigna a la variable `selectedConsulta`.
     */
    private void listenerSelectionConsulta() {
        tb_Consulta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedConsulta = newSelection;
        });
    }

    /**
     * Muestra la información del historial médico seleccionado en el campo de texto.
     *
     * @param historialMedico El historial médico seleccionado en la tabla.
     */
    private void mostraInformacionHistorial(HistorialMedico historialMedico) {
        if (historialMedico != null) {
            txt_CodigoHistorial.setText(historialMedico.getCodigoHistorial());
        }
    }

    /**
     * Agrega un nuevo historial médico a la lista y lo almacena en el controlador.
     * Se crea un nuevo historial a partir de los datos ingresados y se añade a la lista
     * si la operación es exitosa.
     */
    private void agregarHistorialMedico() {
        HistorialMedico historialMedico = buildHistorial();
        if (historialMedicoController.crearHistorial(historialMedico)) {
            listaHistorial.add(historialMedico);
            limpiarCamposHistorial();
        }
    }

    /**
     * Construye un objeto de tipo HistorialMedico con la información ingresada.
     *
     * @return Un objeto HistorialMedico con el código ingresado en el campo de texto.
     */
    private HistorialMedico buildHistorial() {
        return new HistorialMedico(txt_CodigoHistorial.getText());
    }

    /**
     * Elimina el historial médico seleccionado de la lista y del controlador.
     * <p>
     * Si la eliminación es exitosa, también se eliminan los datos de la tabla y se limpian
     * los campos de entrada.
     */
    private void eliminarHistorial() {
        if (historialMedicoController.eliminarHistorial(txt_CodigoHistorial.getText())) {
            listaHistorial.remove(selectedHistorialMedico);
            limpiarCamposHistorial();
            limpiarSeleccion();
        }
    }

    /**
     * Actualiza la información del historial médico seleccionado.
     * <p>
     * Si el historial médico se encuentra en la lista y la actualización es exitosa,
     * se reemplaza por el nuevo objeto actualizado y se refresca la tabla.
     */
    private void actualizarPaciente() {
        if (selectedHistorialMedico != null &&
                historialMedicoController.actualizarHistorial(selectedHistorialMedico.getCodigoHistorial(), buildHistorial())) {

            int index = listaHistorial.indexOf(selectedHistorialMedico);
            if (index >= 0) {
                listaHistorial.set(index, buildHistorial());
            }

            tb_Historial.refresh();
            limpiarSeleccion();
            limpiarCamposHistorial();
        }
    }

    /**
     * Limpia la selección de la tabla de historiales médicos y los campos de entrada.
     */
    private void limpiarSeleccion() {
        tb_Historial.getSelectionModel().clearSelection();
        limpiarCamposHistorial();
    }

    /**
     * Clona el historial médico seleccionado y lo agrega a la lista.
     * <p>
     * Si el historial es válido, se crea una copia utilizando el método de clonación
     * del controlador y se añade a la lista de historiales.
     */
    private void clonarHistorial() {
        if (selectedHistorialMedico != null) {
            // Clonar el historial seleccionado usando el controlador
            boolean clonado = historialMedicoController.clonarHistorial(selectedHistorialMedico);

            // Actualizar la lista y la tabla si la clonación fue exitosa
            if (clonado) {
                listaHistorial.add(selectedHistorialMedico.clone());
                tb_Historial.refresh();
                System.out.println("Historial clonado exitosamente.");
            } else {
                System.out.println("Error al clonar el historial.");
            }
        }
    }

    /**
     * Limpia los campos de entrada y la selección de la tabla de consultas.
     */
    private void limpiarCamposHistorial() {
        txt_CodigoHistorial.clear();
        tb_Consulta.getSelectionModel().clearSelection();
    }

    /**
     * Establece la instancia de la aplicación para acceder a sus métodos.
     *
     * @param app La instancia principal de la aplicación.
     */
    public void setApp(App app) {
        this.app = app;
    }
}
