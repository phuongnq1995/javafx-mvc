package org.phuongnq.javafxmvc.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserCredentials {
    private final String username;
    private final String password;
}
