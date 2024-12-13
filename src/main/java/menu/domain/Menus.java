package menu.domain;

import java.util.List;

public class Menus {

    private int index = 0;
    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu nextMenu() {
        if (index >= menus.size()) {
            return null;
        }

        return menus.get(index++);
    }

    public Menu selectMenu() {
        return new Menu("test");
    }
}
