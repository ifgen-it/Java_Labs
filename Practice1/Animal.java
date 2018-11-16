package Practice1;

public abstract class Animal {

    public String name;
    public String moveName;

    public Animal(String name, String moveName) {
        this.name = name;
        this.moveName = moveName;
    }

    public final String moves() {
        return moveName;
    }

    public abstract String sound();

    public final void output() {

        String className = getClass().getName();
        System.out.println("Type: " + className + "\nName: " + name);
    }

    public final void PrintAnimal() {
        output();
        System.out.println("Moves: " + moves());
        System.out.println("Sound: " + sound());
    }
}
