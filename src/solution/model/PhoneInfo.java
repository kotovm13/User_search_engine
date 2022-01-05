package solution.model;

public class PhoneInfo {

    private final long number;
    private final String info;

    public PhoneInfo(long number, String info) {
        this.info = info;
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return String.format("%d %s%n", getNumber(), getInfo());
    }
}
