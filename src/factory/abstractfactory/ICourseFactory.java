package factory.abstractfactory;

import factory.simplefactory.ICourse;

public interface ICourseFactory {

    ICourse createCourse();

    INote createNote();

    IVideo craeteVideo();

}
