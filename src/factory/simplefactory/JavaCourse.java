package factory.simplefactory;

public class JavaCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("recording java course");
    }
}
