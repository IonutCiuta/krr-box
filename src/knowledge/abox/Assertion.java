package knowledge.abox;

import terms.Term;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ionutciuta24@gmail.com on 16.12.2017.
 */
public class Assertion {
    private final String term;
    private final List<String> individuals = new ArrayList<>();

    public Assertion(String concept, String... indiviuals) {
        this.term = concept;
        this.individuals.addAll(Arrays.asList(indiviuals));
    }

    public String getTerm() {
        return term;
    }

    public List<String> getIndividuals() {
        return individuals;
    }

    @Override
    public String toString() {
        return term + "(" + individuals() + ")";
    }

    private String individuals() {
        return individuals.stream().reduce((i1, i2) -> i1 + ", " + i2).orElse("");
    }
}
