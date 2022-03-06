package general.user_cases.assign_tradesman.domain.valueObjects;

import general.kernel.ValueObjectID;

import java.util.Objects;

public final class LogId implements ValueObjectID {
    private final int value;

    private LogId(int value) {
        this.value = value;
    }
    
    public static LogId of(int value) {
        return new LogId(value);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogId logId = (LogId) o;
        return value == logId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LogId{" +
                "value=" + value +
                '}';
    }
}
