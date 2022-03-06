package general.user_cases.assign_tradesman.domain.enums;

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
