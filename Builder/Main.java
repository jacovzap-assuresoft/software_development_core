class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;

    public Computer(String cpu, String ram, String storage, String graphicsCard) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
    }

    public String getCPU() {
        return cpu;
    }

    public String getRAM() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer Configuration: \n" +
                "CPU: " + cpu + "\n" +
                "RAM: " + ram + "\n" +
                "Storage: " + storage + "\n" +
                "Graphics Card: " + graphicsCard + "\n";
    }
}

interface ComputerBuilder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    void buildGraphicsCard();
    Computer getComputer();
}

class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer("empty", "empty", "empty", "empty");
    }

    @Override
    public void buildCPU() {
        computer = new Computer("High-end CPU", computer.getRAM(), computer.getStorage(), computer.getGraphicsCard());
    }

    @Override
    public void buildRAM() {
        computer = new Computer(computer.getCPU(), "32GB RAM", computer.getStorage(), computer.getGraphicsCard());
    }

    @Override
    public void buildStorage() {
        computer = new Computer(computer.getCPU(), computer.getRAM(), "2TB SSD", computer.getGraphicsCard());
    }

    @Override
    public void buildGraphicsCard() {
        computer = new Computer(computer.getCPU(), computer.getRAM(), computer.getStorage(), "NVIDIA RTX 3090");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

class ComputerDirector {
    public Computer buildComputer(ComputerBuilder builder) {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildGraphicsCard();
        return builder.getComputer();
    }
}

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        ComputerBuilder builder = new GamingComputerBuilder();
        Computer gamingComputer = director.buildComputer(builder);

        System.out.println(gamingComputer);
    }
}