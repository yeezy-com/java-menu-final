package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coachs {

    private final List<Coach> coaches;

    private Coachs(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coachs from(List<Name> names, List<Menus> pickyMenus) {
        List<Coach> coach = new ArrayList<>();
        for (int idx = 0; idx < names.size(); idx++) {
            coach.add(new Coach(names.get(idx), pickyMenus.get(idx)));
        }

        return new Coachs(coach);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
