package Exercise2;

public abstract class GameTester {
    protected String name;

    public GameTester(String name) {
        this.name = name;
    }

    public abstract double determineSalary();
}

