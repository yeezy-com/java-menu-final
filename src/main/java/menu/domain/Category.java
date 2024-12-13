package menu.domain;

import java.util.function.Function;

public class Category {

    private String name;
    private Menus menus;

    public Category(String name, Menus menus) {
        this.name = name;
        this.menus = menus;
    }

    public Category(Menus menus) {
        this.menus = menus;
    }

    public Menu selectRandomMenu() {
        return menus.selectMenu();
    }

    public String getName() {
        return name;
    }

    public Menu findByName(String name) {
        return menus.findByName(name);
    }
}
