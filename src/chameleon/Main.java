package chameleon;

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
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

/*2*/
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