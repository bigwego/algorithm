package factory.simplefactory;

class CourseFactory {

//    public ICourse create(String name) {
//        if ("java".equals(name)) {
//            return new JavaCourse();
//        } else {
//            return null;
//        }
//    }

    ICourse create(Class<?> clazz) {
        try {
            if (null != clazz) {
                return (ICourse) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
