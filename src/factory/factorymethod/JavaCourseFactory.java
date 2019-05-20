package factory.factorymethod;

import factory.simplefactory.ICourse;
import factory.simplefactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
