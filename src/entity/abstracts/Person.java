package entity.abstracts;

public abstract class Person {
    private String name;

    //constructor
    public Person(String name) {
        this.name = name;
    }

    //getter
    public String getName() {
        return name;
    }

    //fonksiyonlar
    public abstract void whoYouAre();
}
