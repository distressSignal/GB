package Mod01.HomeWork05;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0]= new Employee("Иванов Ваня -","Уборка", "VasyaStar@mail.ru","7999123456",25,50000);
        employees[1]= new Employee("Пугачева Алла Борисовна","Артистка", "Alla@mail.ru","7999125456",70,510000);
        employees[2]= new Employee("Иванова Алла Максимовна","Помощница", "IVanovaAAA@mail.ru","7979123456",27,70000);
        employees[3]= new Employee("Пирогов Олег Олегович","Гример", "GrimZa500@mail.ru","7989123456",35,70000);
        employees[4]= new Employee("Хомяков Николай Николаевич","Уборка", "HomNicNik@mail.ru","7779123456",45,50000);
        for (Employee employee : employees) {
            if (employee.getAge()>40){
                employee.printInfo();
            }
        }
        }
    }


