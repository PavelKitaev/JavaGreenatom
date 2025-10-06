package work4;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers;
    private StringBuilder strBuilder;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    // Добавляем наблюдателя
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    // Удаляем наблюдателя
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    // Уведомляем наблюдателя
    public void notifyObs() {
        for (Observer observer : this.observers) {
            observer.update(strBuilder);
        }
    }

    public void setValue(StringBuilder strBuilder) {
        this.strBuilder = strBuilder;
        notifyObs();
    }
}
