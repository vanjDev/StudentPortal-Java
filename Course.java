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
    public GED(String courseCode, int units) {
        super(courseCode, units);
    }
        @Override
    void show(){
        System.out.println("This is GED course, therefore it's accessible to other programs.");
    }
}
