package menu.domain;

public class Name {

    public static final int MINIMUM_NAME_LENGTH = 2;
    public static final int MAXIMUM_NAME_LENGTH = 4;

    private final String name;

    public Name(String name) {
        validateIsBlankOrNull(name);
        validateIsKorean(name);
        validateIsRightLength(name);
        this.name = name;
    }

    private void validateIsBlankOrNull(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateIsRightLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 코치의 이름은 최소 %d글자, 최대 %d글자이어야 합니다.", MINIMUM_NAME_LENGTH, MAXIMUM_NAME_LENGTH));
        }
    }

    private void validateIsKorean(String name) {
        if (!name.matches("^[가-힣]$")) {
            throw new IllegalArgumentException(String.format("[ERROR] \"%s\" 이 이름은 코치 이름으로 적합하지 않습니다.", name));
        }
    }

    public String getName() {
        return name;
    }
}
