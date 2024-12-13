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

    public Menu findByName(String name) {
        return menus.stream()
                .filter(menu -> menu.isSameName(name))
                .findFirst()
                .orElse(null);
    }

    public boolean contains(Menu menu) {
        return menus.contains(menu);
    }
}
