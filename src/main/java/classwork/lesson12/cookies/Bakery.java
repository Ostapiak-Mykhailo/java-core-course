package classwork.lesson12.cookies;

import classwork.lesson12.annotations.AnnotationTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Bakery {

    public static void main(String[] args) throws ClassNotFoundException {

        Class cl = Class.forName("classwork.lesson12.cookies.Cookie");

        if (cl.isAnnotationPresent(ControlledObject.class)){
            System.out.println("Annotation is present");

            ControlledObject annotation = (ControlledObject) cl.getAnnotation(ControlledObject.class);
            System.out.println(annotation);
            System.out.println(annotation.name());

            boolean isStart = false;
            boolean isStop = false;

            Method[] methods = cl.getMethods();
            for (Method method: methods){
                if (method.isAnnotationPresent(StartObject.class)){
                    isStart = true;
                }
                if (method.isAnnotationPresent(StartObject.class)){
                    isStop = true;
                }
                if (isStart && isStop){
                    break;
                }
                System.out.println("This start can start baking " + isStart);
                System.out.println("This start can stop baking " + isStop);

                if (isStart && isStop){
                    Cookie cookie = new Cookie();
                    cookie.cook(annotation.name());
                    cookie.finish(annotation.name());
                }
            }

        } else {
            System.out.println("Not annotated");
        }
    }
}
