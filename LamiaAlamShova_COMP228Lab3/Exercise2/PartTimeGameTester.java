package Exercise2;

public class PartTimeGameTester extends GameTester {
    private int hoursWorked;

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double determineSalary() {
        return hoursWorked * 20.0; //20 per hour for part-time
    }
}
