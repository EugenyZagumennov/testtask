package com.testtask.task.core.entities.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER, EDITOR, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
