package general.user_cases.apply_for_certificate.domain.valueObjects;

import java.util.Objects;

public final class DailyRate {
    private final int value;

    private DailyRate(int value) {
        this.value = value;
    }

    public static DailyRate of(int value) {
        return new DailyRate(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyRate dailyRate = (DailyRate) o;
        return value == dailyRate.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "DailyRate{" +
                "value=" + value +
                '}';
    }
}
