package general.user_cases.create_project.domain;

public enum MemberShipType {

    annual("annual");

    private String value;

    MemberShipType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
