import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ToyRaffle {
    private static ArrayList<Toy> toys;
    private static ArrayList<Toy> prizeToys;

    public ToyRaffle(ArrayList<Toy> toys, ArrayList<Toy> prizeToys) {
        this.toys = toys;
        this.prizeToys = prizeToys;
    }

    public ToyRaffle() {
    }

    public static ArrayList<Toy> getToys() {
        return toys;
    }

    public static void setToys(ArrayList<Toy> toys) {
        ToyRaffle.toys = toys;
    }

    public static ArrayList<Toy> getPrizeToys() {
        return prizeToys;
    }

    public static void setPrizeToys(ArrayList<Toy> prizeToys) {
        ToyRaffle.prizeToys = prizeToys;
    }


    public void addNewToy(Toy newToy, List<Toy> toys){
        toys.add(newToy);
    }

    public static void raffle(){
        if (!toys.isEmpty()){
            for (Toy toy : toys){
                double random = Math.random() * 100;
                if (random < toy.getFrequency()) {
                    prizeToys.add(toy);
                    System.out.println("Вы выиграли: " + toy.getToyName() + "\n" +
                            "Ваш индетификатор для получения игрушки: " + toy.getId());
                    if (toy.getQuantity() == 1 ){
                        toys.remove(toy);
                    }
                    else {
                        toy.setQuantity(toy.getQuantity() - 1);
                    }
                }
             }
        }

    }

    public void changeFrequency(int toyID, double newFrequency){
        for (Toy toy: toys){
            if (toy.getId() == toyID){
                toy.setFrequency(newFrequency);
            }
        }
    }

    public void addPrizeToyToList(Toy toy){
        prizeToys.add(toy);
    }

    public static void issuedToyWriteToFile(Toy toy){
        try(FileWriter fw = new FileWriter("issuedToys.txt",true )) {
            fw.write(toy.getToyName());
            fw.append("\n");
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}


