package org.phuongnq.javafxmvc.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import org.phuongnq.javafxmvc.contains.ViewPath;
import org.phuongnq.javafxmvc.controller.LoginController;
import org.phuongnq.javafxmvc.utils.FXUtils;

import java.io.IOException;
import java.util.function.Consumer;

public class LoginView implements Builder<Region> {

    private final LoginController controller;

    public LoginView(Consumer<String> consumerOnSuccess) {
        this.controller = new LoginController(consumerOnSuccess);
    }

    @Override
    public Region build() {
        FXMLLoader loader = FXUtils.getFXMLLoader(ViewPath.LOGIN);
        loader.setController(controller);
        try {
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
