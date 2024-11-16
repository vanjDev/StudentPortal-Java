// Course System -- [No Functions Yet :)]

public class Course {
    private String courseCode;
    private int units;

    public Course(String courseCode, int units) {
        this.courseCode = courseCode;
        this.units = units;
    }

    void show(){
        System.out.println("This is a course!");
    }

    public String getCourseCode() {
        return courseCode;
    }
    public int getUnits() {
        return units;
    }
}

class GED extends Course {
    String department_program;
    public GED(String courseCode, int units) {
        super(courseCode, units);
    }

        @Override
    void show(){
            System.out.println("department program: " + department_program);
        System.out.println("This is GED course, therefore it's accessible to other programs.");
    }
}

class CS extends Course {
    int specialization;
    public CS(String courseCode, int units) {
        super(courseCode, units);
    }
    @Override
    void show(){
        if (specialization == 1){
            System.out.println("specialization: Software Engineering");
        } else if (specialization == 2) {
            System.out.println("specialization: Artificial Intelligence");
        } else if (specialization == 3) {
            System.out.println("specialization: Data Science");
        }
        System.out.println("This is CS course, therefore it's only to CS Programs.");
    }
}

class CCS extends Course {
    Boolean isCS = true;
    public CCS(String courseCode, int units) {
        super(courseCode, units);
    }

    @Override
    void show(){
        System.out.println("isCS: " + isCS);
        System.out.println("This is CCS course, therefore it's accessible to only CS/IT Programs.");
    }
}
