import java.util.Random;

public class Manager implements EmployeePosition{

    private double finalSalary;
    private double companyIncome;


    public Manager(){
        Random r = new Random();
        companyIncome = (r.nextInt(25000) + 115000);
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return finalSalary = companyIncome * 0.05 + baseSalary;
    }

    @Override
    public double getFinalSalary() {
        return finalSalary;
    }

    @Override
    public double getCompanyIncome() {
        return companyIncome;
    }
}
