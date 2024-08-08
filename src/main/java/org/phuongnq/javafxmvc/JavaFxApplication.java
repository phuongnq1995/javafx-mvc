package org.phuongnq.javafxmvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.phuongnq.javafxmvc.contains.ViewPath;
import org.phuongnq.javafxmvc.utils.FXUtils;

import java.io.IOException;

public class JavaFxApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(FXUtils.load(ViewPath.APP), 1024, 600);
        stage.setTitle("JavaFX-Mvc");
        stage.setScene(scene);
        stage.show();
    }
}