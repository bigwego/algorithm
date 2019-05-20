package factory.simplefactory;

public class PythonCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("recording python course");
    }
}
