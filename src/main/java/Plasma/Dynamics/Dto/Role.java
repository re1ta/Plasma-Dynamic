package Plasma.Dynamics.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Getter
public enum Role {

    ADMIN("admin", "ROLE_ADMIN");

    private final String id;
    private final String roleName;
}
