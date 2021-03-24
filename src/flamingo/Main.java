package flamingo;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

class Person {
    private String name;
    private int age;

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be > 0");
        }
    }
}

class Student extends Person {
    private float score;

    public float getScore() {
        return this.score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}


public class Main {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("jone");
        stu.setAge(18);
        stu.setScore(90);

        System.out.println("Hello world");

    }
}
