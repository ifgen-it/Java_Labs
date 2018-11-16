package Practice1;

public class Task4 {

    public static void Decision() {

        System.out.println("Task4\n");

        Animal[] A1 = {
            new Fish("Shark"),
            new Bird("Eagle"),
            new SeaMammal("Whale", "peep"),
            new TerreMammal("Dog", "yip")
        };

        for (Animal a : A1) {
            a.PrintAnimal();
            System.out.println();
        }

    }
}
