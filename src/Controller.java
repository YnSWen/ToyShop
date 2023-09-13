import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;
    private List<Toy> toys = new ArrayList<>();

    private List<Toy> prizeToys = new ArrayList<>();




    public Controller(View view, List<Toy> toys, List<Toy> prizeToys) {
        this.view = view;
        this.toys = toys;
        this.prizeToys = prizeToys;
    }


    public void run(){
        view.showMenu();
        boolean getNewIteration = true;

        while(getNewIteration){
            String command = view.prompt("Введите команду: ");
            int com = Integer.parseInt(command);
            switch(com)
            {
                case 1:
                    ToyRaffle.raffle();
                    break;

                case 2:
                    view.showToysForRaffle(toys);
                    break;

                case 3:
                    int newToyId = Integer.parseInt(view.prompt("Введите Id новой игрушки: "));
                    String newToyName = view.prompt("Введите имя новой игрушки: ");
                    int newToyQuantity = Integer.parseInt(view.prompt("Введите количество добавляемых игрушек: "));
                    double newToyFrequency = Double.parseDouble(view.prompt("Введите шанс выпадения новой игрушки" +
                            "(от 1 до 100): "));
                    Toy newToy = new Toy(newToyId, newToyName, newToyQuantity, newToyFrequency);

                    toys.add(newToy);

                    System.out.println("Новая игрушка добавлена!" +
                            newToy);
                    break;

                case 4:
                    int toyIdForChange = Integer.parseInt(view.prompt("Введите id игрушки, " +
                            "у которой хотите изменить шанс выпадения: "));

                    double newFrequency = Double.parseDouble(view.prompt("Введите новые значения шанса выпадения " +
                            "игрушки"));

                    for (Toy toy: toys){
                        if (toy.getId() == toyIdForChange){
                            toy.setFrequency(newFrequency);
                            System.out.println("Новые значения установлены!");
                        }
                        else{
                            System.out.println("Игрушка с таким Id не нашлась");
                        }
                    }
                    break;

                case 5:
                    System.out.println("------------Игрушки ожидающие выдачи-----------");
                    System.out.println(prizeToys);
                    break;

                case 6:
                    int toyIdForWinner = Integer.parseInt(view.prompt("Введите id призовой игрушки: "));
                    for (Toy toy: prizeToys){
                        if (toy.getId() == toyIdForWinner){
                            if (toy.getQuantity() == 1){
                                prizeToys.remove(toy);
                            }
                            else{
                                toy.setQuantity(toy.getQuantity() - 1);
                            }
                            ToyRaffle.issuedToyWriteToFile(toy);
                            System.out.println("Выдана призовая игрушка!");


                        }
                        else{
                            System.out.println("Игрушка не нашлась");
                        }
                    }
                    break;

                case 7:
                    getNewIteration = false;
                    System.out.println("Вы вышли из программы");
                    break;


            }

        }


    }
}
