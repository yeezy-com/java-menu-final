package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coachs;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.Name;
import menu.domain.PickyMenu;
import menu.view.InputIterator;
import menu.view.InputManager;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    private static List<String> foods = Arrays.asList("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼",
            "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음",
            "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채",
            "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜",
            "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
    private static List<Category> categories;

    private static void init() {
        List<String> categoryNames = Arrays.asList("일식", "한식", "중식", "아시안", "양식");
        int idx = 0;

        List<Category> tmpCategory = new ArrayList<>();
        List<Menu> tmpMenus = new ArrayList<>();
        for (String rawFood : foods) {
            String[] lotOfFood = rawFood.split(",");

            for (String food : lotOfFood) {
                tmpMenus.add(new Menu(food.trim()));
            }

            tmpCategory.add(new Category(categoryNames.get(idx++), new Menus(tmpMenus)));
        }

        categories = tmpCategory;
    }

    public static void main(String[] args) {
        init();

        InputView inputView = new InputView();
        InputIterator inputIterator = new InputIterator();
        InputManager inputManager = new InputManager(inputView, inputIterator);
        OutputView outputView = new OutputView();

        outputView.showEnterMessage();
        List<Name> names = inputManager.inputCoachNames();
        List<Menus> pickyMenus = inputManager.inputPickyMenus(names);

        Coachs coaches = Coachs.from(names, pickyMenus);

        List<Category> categoryList = selectCategories();
    }

    private static List<Category> selectCategories() {
        int[] categoryCount = {0, 0, 0, 0, 0};

        List<Category> categoryList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int categoryIndex = Randoms.pickNumberInRange(1, 5) - 1;
            categoryCount[categoryIndex]++;

            if (categoryCount[categoryIndex] >= 3) {
                i--;
                continue;
            }

            Category category = categories.get(categoryIndex);
            categoryList.add(category);
        }
        return categoryList;
    }
}
