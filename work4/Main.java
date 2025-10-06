package work4;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        Subject subject = new Subject();
        ConcreteObserver concreteObserver1 = new ConcreteObserver();
        ConcreteObserver concreteObserver2 = new ConcreteObserver();

        subject.attach(concreteObserver1);
        subject.attach(concreteObserver2);

        subject.setValue(stringBuilder);
        subject.setValue(stringBuilder.append(1234));
    }
}