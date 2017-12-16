package terms.property;

/**
 * ionutciuta24@gmail.com on 16.12.2017.
 */
public class ComparativeProperty extends Property {
    public static enum Comparator {
        Greater, Lower, Equal, GreaterOrEqual, LowerOrEqual
    }

    public static class Builder {
        private ComparativeProperty property;

        public Builder() {
            this.property = new ComparativeProperty();
        }

        public Builder named(String name) {
            property.setName(name);
            return this;
        }

        public Builder shouldBeGreaterOrEqualThan(int count) {
            property.setComparator(Comparator.GreaterOrEqual);
            property.setCount(count);
            return this;
        }

        public ComparativeProperty get() {
            return property;
        }
    }

    private Comparator comparator;
    private int count;

    public Comparator getComparator() {
        return comparator;
    }

    private void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    private String getSign() {
        switch (comparator) {
            case Equal:
                return "";

            case Lower:
                return "<";

            case Greater:
                return  ">";

            case LowerOrEqual:
                return  "<=";

            case GreaterOrEqual:
                return "=>";

            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return getSign() + count + " " + getName();
    }
}
