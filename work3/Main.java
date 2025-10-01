package work3;

import java.sql.SQLOutput;
import java.util.Scanner;

// Перечисление типов двигателей
enum Engine {
    ELECTRIC("Электрический"),
    DIESEL("Дизельный"),
    PETROL("Бензиновый"),
    NONE("Отсутствует");

    private final String engineType;

    Engine(String engineType) {
        this.engineType = engineType;
    }

    public String getName() {
        return engineType;
    }
}

sealed abstract class Transport permits Bike, Car, Plane, Ship {
    final protected String name;
    final protected Engine engine;

    // Движется ли транспорт
    private boolean moving = false;

    // Запущен ли двигатель
    private boolean started = false;

    public Transport(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    abstract void startEngine();
    abstract void stopEngine();
    abstract void startMoving();
    abstract void stopMoving();

    boolean getMoving() {
        return moving;
    }

    void setMoving(boolean moving) {
        this.moving = moving;
    }

    boolean getStarted() {
        return started;
    }

    void setStarted(boolean started) {
        this.started = started;
    }
}

final class Car extends Transport {

    public Car(String name, Engine engine) {
        super(name, engine);
    }

    // Запускаем двигатель
    @Override
    public void startEngine() {

        //Если двигатель не запущен
        if (!super.getStarted()) {
            // Запускаем
            System.out.println(super.engine.getName() + " двигатель запущен");
            super.setStarted(true);
        } else {
            // Если запущен - сообщаем об этом
            System.out.println(super.engine.getName() + " двигатель уже запущен");
        }
    }

    // Останавливаем двигатель
    @Override
    public void stopEngine() {

        // Проверяем, запущен ли двигатель и движется ли транспорт
        if (!super.getMoving() && super.getStarted()) {
            // Если транспорт не движется и двигатель запущен - останавливаем двигатель
            System.out.println(super.engine.getName() + " двигатель остановлен");
            super.setStarted(false);
        } else if (super.getMoving() && super.getStarted()) {
            //Если транспорт движется и двигатель запущен
            System.out.println("Сначала нужно остановиться");
        } else if (!super.getMoving() && !super.getStarted()) {
            // Если транспорт не движется и двигатель не запущен
            System.out.println(super.engine.getName() + " двигатель не запущен");
        }
    }

    // Начинаем движение
    @Override
    public void startMoving() {

        // Проверяем, запущен ли двигатель
        if (super.getStarted()) {
            // Если двигатель запущен - едем
            super.setMoving(true);
            System.out.println(super.name + " движется по дороге");
        } else {
            System.out.println("Сначала нужно запустить двигатель");
        }
    }

    // Заканчиваем движение
    @Override
    public void stopMoving() {
        if (super.getMoving()) {
            super.setMoving(false);
            System.out.println(super.name + " остановлен");
        } else {
            System.out.println(super.name + " не движется");
        }

    }
}

final class Bike extends Transport {

    public Bike(String name) {
        super(name, Engine.NONE);
    }

    @Override
    public void startEngine() {
        System.out.println(super.name + " не имеет двигателя");
    }

    @Override
    public void stopEngine() {
        System.out.println(super.name + " не имеет двигателя");
    }

    @Override
    public void startMoving() {
        System.out.println(super.name + " движется по дороге");
    }

    @Override
    public void stopMoving() {
        System.out.println(super.name + " остановлен");
    }
}

final class Plane extends Transport {

    public Plane(String name, Engine engine) {
        super(name, engine);
    }

    // Запускаем двигатель
    @Override
    public void startEngine() {
        //Если двигатель не запущен
        if (!super.getStarted()) {
            // Запускаем
            System.out.println(super.engine.getName() + " двигатель запущен");
            super.setStarted(true);
        } else {
            // Если запущен - сообщаем об этом
            System.out.println(super.engine.getName() + " двигатель уже запущен");
        }
    }

    // Останавливаем двигатель
    @Override
    public void stopEngine() {

        // Проверяем, запущен ли двигатель и движется ли транспорт
        if (!super.getMoving() && super.getStarted()) {
            // Если транспорт не движется и двигатель запущен - останавливаем двигатель
            System.out.println(super.engine.getName() + " двигатель остановлен");
            super.setStarted(false);
        } else if (super.getMoving() && super.getStarted()) {
            //Если транспорт движется и двигатель запущен
            System.out.println("Сначала нужно приземлиться");
        } else if (!super.getMoving() && !super.getStarted()) {
            // Если транспорт не движется и двигатель не запущен
            System.out.println(super.engine.getName() + " двигатель не запущен");
        }
    }

    // Начинаем движение
    @Override
    public void startMoving() {

        // Проверяем, запущен ли двигатель
        if (super.getStarted()) {
            // Если двигатель запущен - едем
            super.setMoving(true);
            System.out.println(super.name + " взлетел и летит");
        } else {
            System.out.println("Сначала нужно запустить двигатель");
        }
    }

    // Заканчиваем движение
    @Override
    public void stopMoving() {
        if (super.getMoving()) {
            super.setMoving(false);
            System.out.println(super.name + " приземлился в аэропорту");
        } else {
            System.out.println(super.name + " не движется, находится в аэропорту");
        }
    }
}

final class Ship extends Transport {

    public Ship(String name, Engine engine) {
        super(name, engine);
    }

    // Запускаем двигатель
    @Override
    public void startEngine() {
        //Если двигатель не запущен
        if (!super.getStarted()) {
            // Запускаем
            System.out.println(super.engine.getName() + " двигатель запущен");
            super.setStarted(true);
        } else {
            // Если запущен - сообщаем об этом
            System.out.println(super.engine.getName() + " двигатель уже запущен");
        }
    }

    // Останавливаем двигатель
    @Override
    public void stopEngine() {

        // Проверяем, запущен ли двигатель и движется ли транспорт
        if (!super.getMoving() && super.getStarted()) {
            // Если транспорт не движется и двигатель запущен - останавливаем двигатель
            System.out.println(super.engine.getName() + " двигатель остановлен");
            super.setStarted(false);
        } else if (super.getMoving() && super.getStarted()) {
            //Если транспорт движется и двигатель запущен
            System.out.println(super.engine.getName() + " двигатель остановлен, лодка дрейфует");
            super.setStarted(false);
        } else if (!super.getMoving() && !super.getStarted()) {
            // Если транспорт не движется и двигатель не запущен
            System.out.println(super.engine.getName() + " двигатель не запущен");
        }
    }

    // Начинаем движение
    @Override
    public void startMoving() {

        // Проверяем, запущен ли двигатель
        if (super.getStarted()) {
            // Если двигатель запущен - едем
            super.setMoving(true);
            System.out.println(super.name + " движется по воде");
        } else {
            System.out.println("Сначала нужно запустить двигатель");
        }
    }

    // Заканчиваем движение
    @Override
    public void stopMoving() {
        if (super.getMoving()) {
            super.setMoving(false);
            System.out.println(super.name + " остановлен");
        } else {
            System.out.println(super.name + " не движется");
        }
    }
}



public class Main {

    public static Engine getEngineType() {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем тип двигателя
        Engine engine = Engine.NONE;
        while (engine == Engine.NONE) {
            System.out.println("Выберите тип двигателя: \n1. Бензиновый \n2. Дизельный \n3. Электрический");
            int engineType = scanner.nextInt();
            engine = switch (engineType) {
                case 1 -> Engine.PETROL;
                case 2 -> Engine.DIESEL;
                case 3 -> Engine.ELECTRIC;
                default -> engine;
            };

            if (engine == Engine.NONE) {
                System.out.println("Некорректный выбор. Попробуйте снова");
            }
        }
        return engine;
    }

    public static void useTransport(Transport transport) {
        Scanner scanner = new Scanner(System.in);

        if (transport instanceof Bike){
            System.out.println("Доступные действия: \n3. Начать движение \n4. Закончить движение \n0. Выход");
        } else {
            System.out.println("Доступные действия: \n1. Запустить двигатель \n2. Остановить двигатель \n3. Начать движение \n4. Закончить движение \n0. Выход");
        }

        while (true) {
            int choice = scanner.nextInt();

            // Если 0 - выходим из цикла
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    transport.startEngine();
                    break;
                case 2:
                    transport.stopEngine();
                    break;
                case 3:
                    transport.startMoving();
                    break;
                case 4:
                    transport.stopMoving();
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            Transport transport;
            Engine engine;

            System.out.print("Введите имя для транспорта: ");
            String transportName = scanner.nextLine();

            System.out.println("Выберите тип транспортного средства:");
            System.out.println("1. Автомобиль\n2. Самолет\n3. Корабль\n4. Велосипед\n0. Выход");
            int choice = scanner.nextInt();

            // Если 0 - выходим из цикла
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    // Выбираем двигатель
                    engine = getEngineType();
                    transport = new Car(transportName, engine);
                    useTransport(transport);
                    break;
                case 2:
                    // Выбираем двигатель
                    engine = getEngineType();
                    transport = new Plane(transportName, engine);
                    useTransport(transport);
                    break;
                case 3:
                    engine = getEngineType();
                    transport = new Ship(transportName, engine);
                    useTransport(transport);
                    break;
                case 4:
                    transport = new Bike(transportName);
                    useTransport(transport);
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
    }
}
