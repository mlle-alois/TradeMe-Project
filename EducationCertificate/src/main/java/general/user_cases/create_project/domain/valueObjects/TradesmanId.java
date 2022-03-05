package general.user_cases.create_project.domain.valueObjects;

import general.kernel.ValueObjectID;

public final class TradesmanId implements ValueObjectID {
    private final int value;

    public TradesmanId(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
