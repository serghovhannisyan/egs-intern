package task2;

public class User {

    private String name;
    private int ege;

    public User(String name, int ege) {
        this.name = name;
        this.ege = ege;
    }

    public String getName() {
        return name;
    }

    public int getEge() {
        return ege;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ege=" + ege +
                '}';
    }

}
