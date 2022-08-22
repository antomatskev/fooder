package eu.fooder.security;

public enum UserPermission {
    ALL("all"),
    ADMIN("admin"),
    CUSTOMER("customer");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
