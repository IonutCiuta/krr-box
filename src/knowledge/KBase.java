package knowledge;

import knowledge.abox.ABox;
import knowledge.tbox.Definition;
import knowledge.tbox.TBox;
import terms.concept.Concept;
import terms.property.ComparativeProperty;
import terms.property.QuantitativeProperty;

import java.util.*;

/**
 * ionutciuta24@gmail.com on 16.12.2017.
 */
public class KBase {
    private TBox tBox = new TBox();
    private ABox aBox = new ABox();

    private void setup() {
        Concept person = new Concept.Builder().named("Person").get();
        Concept female = new Concept.Builder().named("Female").get();
        Concept woman = new Concept.Builder().named("Woman").get();
        tBox.define(woman.getName(), new Definition.Builder().as(person).and(female).get());

        Concept nonWoman = new Concept.Builder().named("Woman").negated().get();
        Concept man = new Concept.Builder().named("Man").get();
        tBox.define(man.getName(), new Definition.Builder().as(person).and(nonWoman).get());

        Concept mother = new Concept.Builder().named("Mother").get();
        QuantitativeProperty hasChildPerson = new QuantitativeProperty.Builder().named("hasChild").existsFor(person).get();
        tBox.define(mother.getName(), new Definition.Builder().as(woman).and(hasChildPerson).get());

        Concept father = new Concept.Builder().named("Father").get();
        tBox.define(father.getName(), new Definition.Builder().as(man).and(hasChildPerson).get());

        Concept parent = new Concept.Builder().named("Parent").get();
        tBox.define(parent.getName(), new Definition.Builder().as(mother).or(father).get());

        Concept grandmother = new Concept.Builder().named("Grandmother").get();
        QuantitativeProperty hasChildParent = new QuantitativeProperty.Builder().named("hasChild").existsFor(parent).get();
        tBox.define(grandmother.getName(), new Definition.Builder().as(mother).and(hasChildParent).get());

        Concept motherWithManyChildren = new Concept.Builder().named("MotherWithManyChildren").get();
        ComparativeProperty hasThreeOrMoreChildren = new ComparativeProperty.Builder().named("hasChild").shouldBeGreaterOrEqualThan(3).get();
        tBox.define(motherWithManyChildren.getName(), new Definition.Builder().as(mother).and(hasThreeOrMoreChildren).get());

        Concept motherWithoutDaughter = new Concept.Builder().named("MotherWithoutDaughter").get();
        QuantitativeProperty hasNonWomanChild = new QuantitativeProperty.Builder().named("hasChild").anyOf(nonWoman).get();
        tBox.define(motherWithoutDaughter.getName(), new Definition.Builder().as(mother).and(hasNonWomanChild).get());

        Concept wife = new Concept.Builder().named("Wife").get();
        QuantitativeProperty hasHusbandMan = new QuantitativeProperty.Builder().named("hasHusband").existsFor(man).get();
        tBox.define(wife.getName(), new Definition.Builder().as(woman).and(hasHusbandMan).get());

        aBox.assertThat(motherWithoutDaughter.getName(), "MARY");
        aBox.assertThat(hasChildPerson.getName(), "MARY", "PETER");
        aBox.assertThat(hasChildPerson.getName(), "MARY", "PAUL");
        aBox.assertThat(father.getName(), "PETER");
        aBox.assertThat(hasChildPerson.getName(), "PETER", "HARRY");
    }

    public void applyInference() {
        System.out.println(tBox.deriveFrom("MotherWithoutDaughter"));
        System.out.println(tBox.deriveFrom("Grandmother"));
        System.out.println(tBox.deriveFrom("Father"));
    }

    @Override
    public String toString() {
        return tBox + "\n" + aBox;
    }

    public static void main(String[] args) {
        KBase kBase = new KBase();
        kBase.setup();
        kBase.applyInference();

        System.out.println(kBase);
    }
}
