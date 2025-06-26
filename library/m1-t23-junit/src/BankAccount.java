public class BankAccount {

    private boolean isBlocked = false;
    private Integer amount;

    private final String firstName;
    private final String secondName;

    public BankAccount(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void block() {
        this.isBlocked = true;
    }

    public void activate() {
        this.amount = 0;
    }

    public Integer amount() {
        return this.amount;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String[] name() {
        return new String[] {firstName, secondName};
    }
}
