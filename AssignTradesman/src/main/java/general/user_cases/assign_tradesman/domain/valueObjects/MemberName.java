package general.user_cases.assign_tradesman.domain.valueObjects;

import java.util.Objects;

public final class MemberName {
    private final String name;

    private MemberName(String name) {
        this.name = name;
    }
    
    public static MemberName of(String name) {
        return new MemberName(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberName memberName = (MemberName) o;
        return name.equals(memberName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "MemberName{" +
                "name=" + name +
                '}';
    }
}
