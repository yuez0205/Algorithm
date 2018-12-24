package Google;

import java.util.*;

public class FamilyTree {

    Person king;
    Map<String, Person> map;

    public FamilyTree(String name) {
        king = new Person(name);
    }

    public void birth(String fatherName, String childName) {

    }

    public void death(String name) {

    }

    public List<Integer> getInheritOrder() {
        List<Integer> res = new ArrayList<>();
        return res;
    }

    public class Person {
        int idx;
        String name;
        boolean alive;
        List<Person> children;
        public Person(String name) {
            this.name = name;
            alive = true;
            children = null;
        }
    }
}
