public class Student {

    private Course course;

    // Constructor Injection
    public Student(Course course) {
        this.course = course;
    }

    public void showDetails() {
        System.out.println("Student is enrolled in: " + course.getCourseName());
    }
}
