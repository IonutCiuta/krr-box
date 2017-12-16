package knowledge.tbox;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TBox:\n");
        definitions.keySet().forEach(s -> sb.append(s).append(": ").append(definitionOf(s)).append("\n"));
        return sb.toString();
    }
}
