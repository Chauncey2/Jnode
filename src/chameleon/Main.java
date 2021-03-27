package chameleon;

/*Summary
 * 1. 子类可以覆写父类方法，覆写在子类的方法改变了父类方法的行为
 * 2. java 的方法调用总是作用于运行期对象的实际类型，这种行为成为多态。
 * 3. final
 *   final定义的方法阻止了子类覆写
 *   final定义的类，阻止了子类继承
 *   final 定义的field必须在创建对象时被初始化，随后不可修改。
 * */
public class Main {
    public static void main(String[] args) {
        System.out.println("This is main method.");
        /*
         * Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
         * 这种特性在OOP中，被称为 多态（Polymorphic）
         * */
        Student stu = new Student();
        stu.run(); // Student.run

        // 一个实际类型为Student 但是引用类型确实Person的变量
        Person p = new Student();
        p.run(); // Student.run

        Income[] incomes = new Income[]{
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));
        totalTax();
    }

    public static void runTwice(Person p) {
        /*
         * 多态的特性就是，运行期才能动态决定调用的子类方法。
         * runTwice方法就无法确定传入的实际类型是Person还是Student，亦或是其他Person的子类。
         * */
        p.run();
        p.run();
    }

    public static double totalTax(Income... incomes) {
        /*
         * 1. 可变长度参数列表 Income... incomes 可以允许方法这 【无参调用 totalTax();】
         * */
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

/*3
 * 复写Object 方法
 * */

class person {
    protected String name;

    @Override
    public String toString() {
        return "Person:name" + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof person) {
            person p = (person) obj;
            return this.name.equals(p.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public final String hello1() {
        /*
         * final 最终的意思，定义为最终的方法，不能被子类复写（Override）
         * */
        return "Hello" + name;
    }
}


/*2
 * */
class Income {
    protected double income;

    public double getTax() {
        return income * 0.1;
    }

    public Income(double income) {
        this.income = income;
    }
}

class Salary extends Income {

    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income < 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {

    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}


/*1*/
class Person {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student extends Person {

    @Override // 加上注解Override，能够帮助编辑器检查，是否正确覆写
    public void run() {
        System.out.println("Student.run");
    }


}