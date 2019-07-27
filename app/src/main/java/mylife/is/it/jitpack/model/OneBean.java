package mylife.is.it.jitpack.model;

public class OneBean {
    private String name;
    private int age;
    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public OneBean(String name, int age, String userId) {
        this.name = name;
        this.age = age;
        this.userId = userId;
    }
}
