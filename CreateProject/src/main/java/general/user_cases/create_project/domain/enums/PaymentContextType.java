package general.user_cases.create_project.domain.enums;

public enum PaymentContextType {
    masterCard("MasterCard");

    private String value;

    PaymentContextType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}