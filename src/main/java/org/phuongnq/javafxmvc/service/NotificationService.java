package org.phuongnq.javafxmvc.service;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import lombok.Getter;

public class NotificationService {
    private static NotificationService notificationService = null;
    public static NotificationService getInstance() {
        if (notificationService == null) {
            notificationService = new NotificationService();
        }
        return notificationService;
    }

    @Getter
    private final BooleanProperty loadingProperty = new SimpleBooleanProperty(false);

    public void showLoading() {
        loadingProperty.setValue(true);
    }

    public void closeLoading() {
        loadingProperty.setValue(false);
    }
}
