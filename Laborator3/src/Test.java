public class Test {
    public void process(int value) {
        System.out.println("Entered method (value = " + value + ")");
        value = 50;
        System.out.println("Changed value within method (value = " + value + ")");
        System.out.println("Leaving method (value = " + value + ")");
    }

    public static void main(String args[]) {
        Test processor = new Test();
        int someValue = 7;
        System.out.println("Before calling method (value = " + someValue + ")");
        processor.process(someValue);
        System.out.println("After calling method (value = " + someValue + ")");
    }
}

