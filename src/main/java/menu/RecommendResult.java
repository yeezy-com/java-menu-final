package menu;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.Menus;

public class RecommendResult {

    private final List<Category> categories;
    private final Coach coach;
    private final Menus menus;

    public RecommendResult(Coach coach, Menus menus) {
        this.coach = coach;
        this.menus = menus;
    }

    public String coachName() {
        return coach.getName();
    }

    public Menu nextMenu() {
        return menus.nextMenu();
    }
}
