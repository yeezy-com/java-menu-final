package menu;

import java.util.Arrays;
import java.util.List;

public class PickyMenu {

    private final List<String> menus;

    public PickyMenu(String menus) {
        // 검증 로직
        this.menus = Arrays.asList(menus.split(","));
    }
}
