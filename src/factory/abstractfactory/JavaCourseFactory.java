package factory.abstractfactory;

import factory.simplefactory.ICourse;
import factory.simplefactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo craeteVideo() {
        return new JavaVideo();
    }
}
