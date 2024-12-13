package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Categories;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.Name;

public class InputManager {

    private final InputView inputView;
    private final InputIterator inputIterator;

    public InputManager(InputView inputView, InputIterator inputIterator) {
        this.inputView = inputView;
        this.inputIterator = inputIterator;
    }

    public List<Name> inputCoachNames() {
        return inputIterator.retryUntilSuccess(() -> {
            String rawNames = inputView.inputCoachNames();
            return Arrays.stream(rawNames.split(","))
                    .map(Name::new)
                    .collect(Collectors.toList());
        });
    }

    public List<Menus> inputPickyMenus(List<Name> names, Categories categories) {
        return inputIterator.retryUntilSuccess(() -> {
            return names.stream()
                    .map(name -> Arrays.stream(inputView.inputPickyMenus(name.getName()).split(","))
                            .map(categories::findByMenuName)
                            .collect(Collectors.toList()))
                    .map(Menus::new)
                    .collect(Collectors.toList());
        });
    }
}
