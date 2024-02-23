module org.example.projectpassport {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.mail;


    opens org.example.projectpassport to javafx.fxml;
    exports org.example.projectpassport;
    exports org.example.projectpassport.tableView;
    opens org.example.projectpassport.tableView to javafx.fxml;
    exports org.example.projectpassport.SystemUsers;
    opens org.example.projectpassport.SystemUsers to javafx.fxml;
}