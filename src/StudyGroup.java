public class StudyGroup {
    private String groupName;
    private int course;
    private Teacher teacher;
    private Person student;

    //constructor
    public StudyGroup(String groupName, int course, Teacher teacher, Person student) {

        this.groupName = groupName;
        if ((course < 1) || (course > 5)) {
            this.course = 1;
        } else {
            this.course = course;
        }
        this.teacher = teacher;
        this.student = student;
    }

    //setters and getters
    public void setStudent(Person student) {

        this.student = student;
    }

    public Person getStudent() {
        return this.student;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    //Methods
    @Override
    public String toString() {
        return "Group: " + this.groupName + ", " + this.course + ", \nTeacher: " + this.teacher + ", Student:" + this.student;
    }

}
