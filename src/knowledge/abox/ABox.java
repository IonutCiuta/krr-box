package knowledge.abox;

import knowledge.KBase;

import java.util.ArrayList;
import java.util.List;

/**
 * ionutciuta24@gmail.com on 16.12.2017.
 */
public class ABox {
    private final List<Assertion> assertions = new ArrayList<>();

    public void assertThat(String term, String... individuals) {
        assertions.add(new Assertion(term, individuals));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ABox:\n");
        assertions.forEach(a -> sb.append(a).append("\n"));
        return sb.toString();
    }

    public List<Assertion> getAssertions() {
        return assertions;
    }
}
