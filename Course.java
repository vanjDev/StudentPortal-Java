// Course System -- [No Functions Yet :)]

public class Course {
    private String courseCode;
    private int units;

    public Course(String courseCode, int units) {
        this.courseCode = courseCode;
        this.units = units;
    }

    void show() {
        System.out.println("\n===============================");
        System.out.println("📚 Course Information");
        System.out.println("===============================");
        System.out.printf("📘 Course Code: %s\n", courseCode);
        System.out.printf("🔢 Units: %d\n", units);
        System.out.println("This is a general course.");
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
        void show() {
            super.show();
            System.out.println("===============================");
            System.out.println("🏫 GED Course Details");
            System.out.println("===============================");
            System.out.printf("🔗 Department Program: %s\n", department_program);
            System.out.println("📖 Note: This is a GED course, accessible to other programs.");
            System.out.println("===============================");
        }
}

class CS extends Course {
    int specialization;
    public CS(String courseCode, int units) {
        super(courseCode, units);
    }
    @Override
    void show() {
        super.show();
        System.out.println("===============================");
        System.out.println("💻 CS Course Details");
        System.out.println("===============================");
        String specializationName = switch (specialization) {
            case 1 -> "Software Engineering";
            case 2 -> "Artificial Intelligence";
            case 3 -> "Data Science";
            default -> "Unknown Specialization";
        };
        System.out.printf("🔧 Specialization: %s\n", specializationName);
        System.out.println("📖 Note: This is a CS course, only available to CS programs.");
        System.out.println("===============================");
    }
}

class CCS extends Course {
    Boolean isCS = true;
    public CCS(String courseCode, int units) {
        super(courseCode, units);
    }

    @Override
    void show() {
        super.show();
        System.out.println("===============================");
        System.out.println("🔍 CCS Course Details");
        System.out.println("===============================");
        System.out.printf("🔑 CS Program Access: %s\n", isCS ? "Yes" : "No");
        System.out.println("📖 Note: This is a CCS course, available to CS/IT programs only.");
        System.out.println("===============================");
    }
}
