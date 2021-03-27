package chameleon;
/*Summary
* 抽象方法定义了子类必须实现的接口规范
* 定义了抽象方法的class 必须被定义为抽象类，从抽象类继承子类必须实现抽象方法
* 如果不实现抽象方法，则该子类依然是一个抽象子类，但是必须加上abstract class 关键字、
* 面向抽象编程使得调用者只关心抽象方法的定义，不关心子类的具体实现。
* */
public class Main2AbastractMethod {
    public static void main(String[] args) {
        System.out.println("This is Main2AbastractMethod");
        Student2 stu = new Student2();
        stu.run();

        // 抽象类也可以定义引用类型
        /*
        * 这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程
        * 面向抽象编程的本质
        *   上层代码只定义规范
        *   不需要子类就可以实现业务逻辑
        *   具体业务逻辑由不同的子类实现，调用者并不关心
        * */
        Person2 stu2 = new Student2();
        stu2.run();
        stu2.sayHello();
    }
}

class hello{
    public void sayHello(){
        System.out.println("Hello");
    }
}
/*
* 抽象方法可以继承普通类
* */
abstract class Person2 extends hello{
    /*
    * 抽象类可以强迫子类必须实现它定义的方法
    * */
    public abstract void run();
}
class Student2 extends Person2{
    @Override
    public void run(){
        System.out.println("Student2.run");
    }
}