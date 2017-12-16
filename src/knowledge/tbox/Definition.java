package knowledge.tbox;

import terms.Term;

/**
 * ionutciuta24@gmail.com on 16.12.2017.
 */
public class Definition {
    public static enum Connector {
        Or, And
    }

    public static class Builder {
        Definition def;

        public Builder() {
            this.def = new Definition();
        }

        public Builder as(Term t1) {
            this.def.set1stTerm(t1);
            return this;
        }

        public Builder and(Term t2) {
            this.def.setConnector(Connector.And);
            this.def.set2ndTerm(t2);
            return this;
        }

        public Builder or(Term t2) {
            this.def.setConnector(Connector.Or);
            this.def.set2ndTerm(t2);
            return this;
        }

        public Definition get() {
            return def;
        }
    }

    private Connector connector;
    private Term t1, t2;

    private Definition() {}

    public Connector getConnector() {
        return connector;
    }

    public Term get2ndTerm() {
        return t2;
    }

    public Term get1stTerm() {
        return t1;
    }

    private void setConnector(Connector connector) {
        this.connector = connector;
    }

    private void set1stTerm(Term t1) {
        this.t1 = t1;
    }

    private void set2ndTerm(Term t2) {
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return t1.toString() + " " + connector + " " + t2.toString();
    }
}
