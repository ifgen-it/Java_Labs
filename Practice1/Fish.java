package Practice1;

public class Fish extends Animal {

    private final static String moveClassName = "swim";

    public Fish(String name) {
        super(name, moveClassName);
    }

    @Override
    public String sound() {
        return "nothing";
    }

}
