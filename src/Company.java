import java.util.*;

public class Company {
    private List<Employee> employees;
    private double income;

    public List<Employee> getEmployees(){
        return employees;
    }

    private void hair(Employee employee){
        if(employees == null)
            employees = new ArrayList<>();
        employees.add(employee);
    }

    public void hairAll(List<Employee> employeeList){
        if(employees == null)
            employees = new ArrayList<>();
        employees.addAll(employeeList);
    }

    public void fire(int pos){
        employees.remove(pos);
    }

    public double calcIncome(){
        income = 0;
        for(Employee employee : employees)
            if (employee.position.getJobTitle().equals("Manager"))
                income = income + employee.position.getCompanyIncome();
        return income;
    }

    public double getIncome(){
        return income;
    }

    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> highList = new ArrayList<Employee>();
        if(count < 1){
            System.out.println("Слишком мало сотрудников");
            return highList;
        }
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.position.getFinalSalary() < o2.position.getFinalSalary())
                    return 1;
                else if (o1.position.getFinalSalary() > o2.position.getFinalSalary())
                    return -1;
                else
                    return 0;
            }


        };
        employees.sort(comparator);
        for(int i = 0; i < count; i++)
            highList.add(employees.get(i));
        return highList;
    }


    List<Employee> getLowestSalaryStaff(int count){

        ArrayList<Employee> lowList = new ArrayList<Employee>();
        if(count < 1){
            System.out.println("Слишком мало сотрудников");
            return lowList;
        }
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.position.getFinalSalary() < o2.position.getFinalSalary())
                    return 1;
                else if (o1.position.getFinalSalary() > o2.position.getFinalSalary())
                    return -1;
                else
                    return 0;

            }
        };
        employees.sort(comparator);
        Collections.reverse(employees);
        for (int i = 0; i < count; i++)
            lowList.add(employees.get(i));
        return lowList;
    }

    public void generateEmployees() {
        Employee emp;

        for (int i = 0; i < 180; i++) {
            if (i%3 == 1) {
                emp = new Employee("Ivan", "Ivanov", new Operator());
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("Alexander", "Petrov", new Operator());
                hair(emp);
            } else {
                emp = new Employee("Alexei", "Kwashonkin", new Operator());
                hair(emp);
            }
        }
        Company company = new Company();

        for (int i = 0; i < 80; i++) {
            if (i%3 == 1) {
                emp = new Employee("Peregrin", "Took", new Manager());
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("Meriadoc", "Brandybuck", new Manager());
                hair(emp);
            } else {
                emp =  new Employee("Samwise", "Gamgee", new Manager());
                hair(emp);
            }
        }
        calcIncome();

        for (int i = 0; i < 10; i++) {
            if (i%3 == 1) {
                emp = new Employee("Frodo", "Baggins", new TopManager(company));
                hair(emp);
            } else if (i%3 == 2) {
                emp = new Employee("Gandalf", "the White", new TopManager(company));
                hair(emp);
            } else {
                emp = new Employee("Aragorn", "Elessar", new TopManager(company));
                hair(emp);
            }
        }


    }

    public void calcAll(double baseSalary) {

        for (Employee employee : employees) {
            employee.position.calcSalary(baseSalary);
        }
    }

    public void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(employees.get(i) + "  " + employees.get(i).position.getFinalSalary() + "  " + employees.get(i).position.getJobTitle() + "\n");
        }
    }
}
