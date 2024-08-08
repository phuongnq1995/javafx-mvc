package org.phuongnq.javafxmvc.contains;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ViewPath {
    APP("app"),
    MAINTENANCE("maintenance", "maintenance"),
    LOGIN("login", "login"),
    MAIN("main", "main");

    private final String path;
    private final String folder;

    ViewPath(String path) {
        this(path, null);
    }

    public String getFxmlPath() {
        if (folder == null) {
            return String.format("/fxml/%s.fxml", path);
        }
        return String.format("/fxml/%s/%s.fxml", folder, path);
    }
}
