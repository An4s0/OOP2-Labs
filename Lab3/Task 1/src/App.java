public class App {
    public static void main(String[] args) throws Exception {
        try {
            someMethod1();
        } catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }

    public static void someMethod1() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Exception in someMethod1: " + e.getMessage());
            throw e; 
        }
    }

    public static void someMethod2() throws Exception {
        throw new Exception("Exception from someMethod2");
    }
}
