import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

interface Observer {
    void update(boolean isIndependenceDay);
}

class User implements Observer {
    private String name;
    private boolean isFromBolivia;

    public User(String name, boolean isFromBolivia) {
        this.name = name;
        this.isFromBolivia = isFromBolivia;
    }

    @Override
    public void update(boolean isIndependenceDay) {
        if (isFromBolivia && isIndependenceDay) {
            System.out.println("Felicidades Bolivia!! \n" + "Hola " + name + "\n");
        } else {
            System.out.println("Google.\n" + "Hola " + name + "\n");
        }
    }
}

class DoodleNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(boolean isIndependenceDay) {
        for (Observer observer : observers) {
            observer.update(isIndependenceDay);
        }
    }
}

interface DoodleStrategy {
    boolean isIndependenceDay();
}

class BoliviaIndependenceDayStrategy implements DoodleStrategy {
    @Override
    public boolean isIndependenceDay() {
        LocalDate today = LocalDate.now();
        return today.getMonthValue() == 11 && today.getDayOfMonth() == 8;
    }
}

public class Main {
    public static void main(String[] args) {
        DoodleNotifier doodleNotifier = new DoodleNotifier();
        doodleNotifier.addObserver(new User("Juan", true));
        doodleNotifier.addObserver(new User("Pedro", false));
        doodleNotifier.addObserver(new User("María", true));
        doodleNotifier.addObserver(new User("José", false));

        doodleNotifier.notifyObservers(new BoliviaIndependenceDayStrategy().isIndependenceDay());
    }
}