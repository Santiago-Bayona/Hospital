module co.edu.uniquindio.poo.hospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.hospital to javafx.fxml;
    exports co.edu.uniquindio.poo.hospital;
    exports co.edu.uniquindio.poo.hospital.Model;
    opens co.edu.uniquindio.poo.hospital.Model to javafx.fxml;
    exports co.edu.uniquindio.poo.hospital.Controller;
    opens co.edu.uniquindio.poo.hospital.Controller to javafx.fxml;
    opens co.edu.uniquindio.poo.hospital.ViewController to javafx.fxml;
    exports co.edu.uniquindio.poo.hospital.ViewController to javafx.fxml;
}