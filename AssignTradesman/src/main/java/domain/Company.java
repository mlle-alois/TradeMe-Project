package domain;

import domain.valueObjects.CompanyId;

public final class Company {
    private final String name;
    private final CompanyId id;

    private Company(String name, CompanyId id) {
        this.name = name;
        this.id = id;
    }

    public static Company of(String name, CompanyId id) {
        return new Company(name, id);
    }

    public String getName() {
        return name;
    }

    public CompanyId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Company Id : " + id.toString() + " \n" +
                "Name : " + name + " \n";
    }
}
