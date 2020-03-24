import java.io.Serializable;

public class User {
    private String username;
    private Integer age;
    User(){};
    User(String username, Integer age){
        this.username = username;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public String getUsername() {
        return username;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
