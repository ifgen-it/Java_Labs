package Practice1;

public abstract class Mammal extends Animal {

    protected String soundName;

    protected Mammal(String name, String moveClassName, String soundName) {
        super(name, moveClassName);
        this.soundName = soundName;
    }

    @Override
    public String sound() {
        return soundName;
    }
}
