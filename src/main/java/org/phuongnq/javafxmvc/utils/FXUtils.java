package org.phuongnq.javafxmvc.utils;

import javafx.fxml.FXMLLoader;
import lombok.SneakyThrows;
import org.phuongnq.javafxmvc.JavaFxApplication;
import org.phuongnq.javafxmvc.contains.ViewPath;

public class FXUtils {
    public static FXMLLoader getFXMLLoader(ViewPath viewPath) {
        return new FXMLLoader(JavaFxApplication.class.getResource(viewPath.getFxmlPath()));
    }

    @SneakyThrows
    public static <T> T load(ViewPath viewPath) {
        return getFXMLLoader(viewPath).load();
    }

    public static <T> T getController(ViewPath viewPath) {
        FXMLLoader fxmlLoader = getFXMLLoader(viewPath);
        return fxmlLoader.getController();
    }
}
