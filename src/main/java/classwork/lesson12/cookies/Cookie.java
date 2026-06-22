package classwork.lesson12.cookies;

@ControlledObject(name = "biscuits")
public class Cookie {

    @StartObject
    public void cook(String name){
        System.out.println("Baking " + name);
    }

    @StopObject
    public void finish(String name){
        System.out.println(name + " are ready");
    }
}
