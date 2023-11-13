import java.util.ArrayList;
import java.util.List;

interface Visitor {
    void visitPublicSchool(PublicSchool school);

    void visitPrivateSchool(PrivateSchool school);
}

class SchoolVisitor implements Visitor {
    public void visitPublicSchool(PublicSchool school) {
        System.out.println("----- Visiting public school " + school.getName() + "  -----");
        System.out.println("Deposited " + school.getStudentCount() * 200 + " bolivianos\n");
    }

    public void visitPrivateSchool(PrivateSchool school) {
        System.out.println("----- Visiting private school " + school.getName() + "  -----");
        System.out.println("Goodbye\n");
    }

}

abstract class School {
    private String name;
    private Integer studentCount;

    public School(String name, Integer studentCount) {
        this.name = name;
        this.studentCount = studentCount;
    }

    public abstract void accept(Visitor visitor);

    public String getName() {
        return name;
    }

    public Integer getStudentCount() {
        return studentCount;
    }
}

class PublicSchool extends School {
    public PublicSchool(String name, Integer studentCount) {
        super(name, studentCount);
    }

    public void accept(Visitor visitor) {
        visitor.visitPublicSchool(this);
    }
}

class PrivateSchool extends School {
    public PrivateSchool(String name, Integer studentCount) {
        super(name, studentCount);
    }

    public void accept(Visitor visitor) {
        visitor.visitPrivateSchool(this);
    }
}

public class Main {
    public static void main(String[] args) {
        List<School> schoolList = new ArrayList<>();
        schoolList.add(new PublicSchool("Liceo Bolivia", 300));
        schoolList.add(new PublicSchool("Santa María ", 400));
        schoolList.add(new PublicSchool("Andre Bello", 500));
        schoolList.add(new PublicSchool("America del sur", 500));
        schoolList.add(new PublicSchool("Suecia", 400));

        schoolList.add(new PrivateSchool("San Agustin", 200));
        schoolList.add(new PrivateSchool("Don Bosco", 250));
        schoolList.add(new PrivateSchool("La Salle", 300));
        schoolList.add(new PrivateSchool("Aguilas de America", 150));
        schoolList.add(new PrivateSchool("Loyola", 200));

        Visitor visitor = new SchoolVisitor();

        for (School school : schoolList) {
            school.accept(visitor);
        }

    }
}