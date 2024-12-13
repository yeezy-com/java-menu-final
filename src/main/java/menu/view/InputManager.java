package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Name;
import menu.domain.PickyMenu;

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

    public List<PickyMenu> inputPickyMenus(List<Name> names) {
        return inputIterator.retryUntilSuccess(() -> {
            return names.stream()
                    .map(name -> inputView.inputPickyMenus(name.getName()))
                    .map(PickyMenu::new)
                    .collect(Collectors.toList());
        });
    }
}
