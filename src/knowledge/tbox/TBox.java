package knowledge.tbox;

import terms.Term;
import terms.concept.Concept;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ionutciuta24@gmail.com on 16.12.2017.
 */
public class TBox {
    private final Map<String, Definition> definitions = new HashMap<>();

    public void define(String conceptName, Definition definition) {
        definitions.put(conceptName, definition);
    }

    public Definition definitionOf(String conceptName) {
        return definitions.get(conceptName);
    }

    public Map<String, Definition> getDefinitions() {
        return definitions;
    }

    public Set<String> deriveFrom(String concept) {
        Set<String> lineage = new HashSet<>();
        derive(concept, lineage);
        return lineage;
    }

    public void derive(String concept, Set<String> lineage) {
        lineage.add(concept);

        Definition def = definitions.get(concept);
        if(def == null) return;

        expandTerm(def.get1stTerm(), lineage);
        expandTerm(def.get2ndTerm(), lineage);
    }

    public void expandTerm(Term term, Set<String> lineage) {
        if(term instanceof Concept && !((Concept) term).isNegated()) {
            derive(term.getName(), lineage);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TBox:\n");
        definitions.keySet().forEach(s -> sb.append(s).append(": ").append(definitionOf(s)).append("\n"));
        return sb.toString();
    }
}
