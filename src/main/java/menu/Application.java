package menu;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("점심 메뉴 추천을 시작합니다." + System.lineSeparator());

        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String rawCoach = Console.readLine();

        List<Name> names = new ArrayList<>();
        for (String name : rawCoach.split(",")) {
            names.add(new Name(name));
        }

        List<PickyMenu> pickyMenus = new ArrayList<>();
        for (Name name : names) {
            System.out.println();
            System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요." + System.lineSeparator(), name.getName());
            String menus = Console.readLine();
            pickyMenus.add(new PickyMenu(menus));
        }
    }
}
