public class CourseRecord {
    public String code;
    public String title;
    public double credit;
    public String instructor;
    public int rooms;

    public CourseRecord(String code, String title, double credit, String instructor, int rooms) {
        this.code = code;
        this.title = title;
        this.credit = credit;
        this.instructor = instructor;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return  "Course Code: " + code + "\n" +
                "Course Title: " + title + "\n" +
                "Credit Hours: " + credit + "\n" +
                "Instructor Name: " + instructor + "\n" +
                "Class Rooms: " + rooms + "\n";
    }
}