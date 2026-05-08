package entity.abstracts;

import utils.ValidationUtil;

public abstract class Person {
    private String name;

    //constructor
    public Person(String name) {
        this.setName(name);
    }

    //getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationUtil.requireNonNull(name, "`name` null olamaz.");
        ValidationUtil.requireNonEmpty(name, "`name` boş olamaz.");
        this.name = name;
    }

    //toString
    @Override
    public String toString() {
        return name;
    }

    //methods
    public abstract void whoYouAre();
}
