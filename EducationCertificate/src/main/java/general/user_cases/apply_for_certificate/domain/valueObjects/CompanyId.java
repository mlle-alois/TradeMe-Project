package general.user_cases.apply_for_certificate.domain.valueObjects;

import java.util.Objects;

public final class CompanyId {
    private final String id;

    private CompanyId(String id) {
        this.id = id;
    }

    public static CompanyId of(String id) {
        return new CompanyId(id);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyId companyId = (CompanyId) o;
        return id.equals(companyId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CompanyId{" +
                "id=" + id +
                '}';
    }
}
