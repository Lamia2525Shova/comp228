package Exercise2;

public class FullTimeGameTester extends GameTester {

    public FullTimeGameTester(String name) {
        super(name);
    }

    @Override
    public double determineSalary() {
        return 3000.00; //fixed salary
    }
}
