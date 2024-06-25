package recap;

// Енумерация!
public enum Role {

    // Енъм стойност
    ADMIN(true),
    SUPPORT(false),
    USER(false);

    // Поле в енумерацията
    private boolean isAccessAllowed;

    // Конструктор
    Role(boolean isAccessAllowed) {
        this.isAccessAllowed = isAccessAllowed;
    }

    public boolean isAccessAllowed() {
        return this.isAccessAllowed;
    }
}
