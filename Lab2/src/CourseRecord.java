public class CourseRecord {
    public String code;
    public String title;
    public int credit;
    public String instructor;
    public int rooms;

    public CourseRecord(String code, String title, int credit, String instructor, int rooms) {
        this.code = code;
        this.title = title;
        this.credit = credit;
        this.instructor = instructor;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\n" +
                "Course Title: " + title + "\n" +
                "Credit Hours: " + credit + "\n" +
                "Instructor: " + instructor + "\n" +
                "Rooms: " + rooms + "\n";
    }
}