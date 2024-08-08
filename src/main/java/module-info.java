module org.phuongnq.javafxmvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens org.phuongnq.javafxmvc to javafx.fxml;
    opens org.phuongnq.javafxmvc.controller to javafx.fxml;
    opens org.phuongnq.javafxmvc.view to javafx.fxml;

    exports org.phuongnq.javafxmvc;
}