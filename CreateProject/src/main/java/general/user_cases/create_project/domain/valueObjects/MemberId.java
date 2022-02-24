package general.user_cases.create_project.domain.valueObjects;

import general.kernel.ValueObjectID;

import java.util.Objects;

public final class MemberId implements ValueObjectID {
    private final int value;

    private MemberId(int value) {
        this.value = value;
    }
    
    public static MemberId of(int value) {
        return new MemberId(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return value == memberId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "UserId{" +
                "value=" + value +
                '}';
    }
}
