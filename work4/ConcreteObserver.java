package work4;

public class ConcreteObserver implements Observer {

    @Override
    public void update(StringBuilder strBuilder) {
        System.out.println("New value: " + strBuilder);
    }
}
