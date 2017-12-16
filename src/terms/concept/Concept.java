package terms.concept;

import terms.Term;

/**
 * ionutciuta24@gmail.com on 16.12.2017.
 */
public class Concept extends Term {
    public static class Builder {
        private Concept concept;

        public Builder() {
            this.concept = new Concept();
        }

        public Builder named(String name) {
            concept.setName(name);
            return this;
        }

        public Builder negated() {
            concept.setNegated();
            return this;
        }

        public Concept get() {
            return concept;
        }
    }

    private boolean negated;

    public boolean isNegated() {
        return negated;
    }

    private void setNegated() {
        this.negated = true;
    }

    @Override
    public String toString() {
        return negated ? ("~" + getName()) : getName();
    }
}
