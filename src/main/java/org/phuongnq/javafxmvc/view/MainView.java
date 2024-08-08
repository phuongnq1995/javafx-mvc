package org.phuongnq.javafxmvc.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import org.phuongnq.javafxmvc.contains.ViewPath;
import org.phuongnq.javafxmvc.controller.MainController;
import org.phuongnq.javafxmvc.service.UserService;
import org.phuongnq.javafxmvc.utils.FXUtils;

import java.io.IOException;

public class MainView implements Builder<Region> {

    private final MainController controller;

    public MainView(UserService userService) {
        this.controller = new MainController(userService);
    }

    @Override
    public Region build() {
        FXMLLoader loader = FXUtils.getFXMLLoader(ViewPath.MAIN);
        loader.setController(controller);
        try {
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
