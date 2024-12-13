package menu.domain;

public class Menu {

    private final String menuName;

    public Menu(String menuName) {
        this.menuName = menuName;
    }

    public String getName() {
        return menuName;
    }

    public boolean isSameName(String name) {
        if (menuName.equals(name)) {
            return true;
        }
        return false;
    }
}
