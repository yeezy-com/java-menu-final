package menu.domain;

import java.util.List;

public class Categories {

    private final List<Category> categories;

    public Categories(List<Category> categories) {
        this.categories = categories;
    }

    public Menu findByMenuName(String menuName) {
        return categories.stream()
                .map(category -> category.findByName(menuName))
                .findFirst()
                .orElse(null);
    }
}
