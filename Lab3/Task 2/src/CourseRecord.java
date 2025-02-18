public class CourseRecord {
    public String code;
    public String title;
    public int credit;
    public String instructor;
    public int rooms;

    public CourseRecord(String code, String title, int credit, String instructor, int rooms) {
        try {
            if ((code.startsWith("CS") && code.length() != 5)
                    || (code.startsWith("CIS") && code.length() != 6)
                    || rooms <= 0
                    || (credit < 1 || credit > 3))
                throw new IllegalArgumentException();

            this.code = code;
            this.title = title;
            this.credit = credit;
            this.instructor = instructor;
            this.rooms = rooms;

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Course Information");
        }
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