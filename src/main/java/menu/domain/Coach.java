package menu.domain;

public class Coach {

    private final Name name;
    private final Menus pickyMenu;

    public Coach(Name name, Menus pickyMenu) {
        this.name = name;
        this.pickyMenu = pickyMenu;
    }

    public boolean isPossibleMenu(Menu menu) {
        if (pickyMenu.contains(menu)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name.getName();
    }
}
