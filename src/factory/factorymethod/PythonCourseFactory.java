package factory.factorymethod;

import factory.simplefactory.ICourse;
import factory.simplefactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
