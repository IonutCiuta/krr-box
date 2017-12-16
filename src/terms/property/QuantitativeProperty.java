package terms.property;

import terms.concept.Concept;

/**
 * ionutciuta24@gmail.com on 16.12.2017.
 */
public class QuantitativeProperty extends Property {
    public static enum Quantifier {
        Any, Exists
    }

    public static class Builder {
        private QuantitativeProperty property;

        public Builder() {
            this.property = new QuantitativeProperty();
        }

        public Builder name(String name) {
            property.setName(name);
            return this;
        }

        public Builder anyOf(Concept concept) {
            property.setQuantifier(Quantifier.Any);
            property.setArg(concept);
            return this;
        }

        public Builder existsFor(Concept concept) {
            property.setQuantifier(Quantifier.Exists);
            property.setArg(concept);
            return this;
        }

        public QuantitativeProperty get() {
            return property;
        }
    }

    private Quantifier quantifier;
    private Concept arg;

    public Quantifier getQuantifier() {
        return quantifier;
    }

    private void setQuantifier(Quantifier quantifier) {
        this.quantifier = quantifier;
    }

    public Concept getArg() {
        return arg;
    }

    private void setArg(Concept arg) {
        this.arg = arg;
    }
}
