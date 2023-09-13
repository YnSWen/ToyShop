import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

         Toy toy1 = new Toy(1, "Doll", 10, 30);
         Toy toy2 = new Toy(4, "Car", 6, 30);
         Toy toy3 = new Toy(6, "Big Bear", 3, 7);

         List<Toy> toys = new ArrayList<Toy>();
         toys.add(toy1);
         toys.add(toy2);
         toys.add(toy3);

         List<Toy> prizeToys = new ArrayList<Toy>();


         View view = new View();
         ToyRaffle toyRaffle = new ToyRaffle((ArrayList<Toy>) toys, (ArrayList<Toy>) prizeToys);

         Controller controller = new Controller(view, toys, prizeToys);


         controller.run();



    }
}