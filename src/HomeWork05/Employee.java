package HomeWork05;

public class Employee {
    private final String name;
    private final String post;
    private final String emailAddress;
    private final String phoneNumber;
    private final int age;
    private final int salary;

    public Employee(String name, String post, String emailAddress, String phoneNumber, int age, int salary) {
        this.name = name;
        this.post = post;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    void printInfo() {

        System.out.println(this/*.toString()*/);
    }

    public String toString() {
        return String.format("Работник: %s %nДолжность: %s %n email: %s телефон %s %n зарплата %s возраст %s %n ",
                name, post, emailAddress, phoneNumber, salary, age);
    }


}
