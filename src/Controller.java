import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Controller {
    private View view;

    private ToyRaffle toyRaffle;




    public Controller(View view, ToyRaffle toyRaffle) {
        this.view = view;
        this.toyRaffle = toyRaffle;
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
                    toyRaffle.raffle();
                    break;

                case 2:
                    view.showToysForRaffle(toyRaffle.getToys());
                    break;

                case 3:
                    int newToyId = Integer.parseInt(view.prompt("Введите Id новой игрушки: "));
                    String newToyName = view.prompt("Введите имя новой игрушки: ");
                    int newToyQuantity = Integer.parseInt(view.prompt("Введите количество добавляемых игрушек: "));
                    double newToyFrequency = Double.parseDouble(view.prompt("Введите шанс выпадения новой игрушки" +
                            "(от 1 до 100): "));
                    Toy newToy = new Toy(newToyId, newToyName, newToyQuantity, newToyFrequency);

                    toyRaffle.getToys().add(newToy);

                    System.out.println("Новая игрушка добавлена!" +
                            newToy);
                    break;

                case 4:
                    int toyIdForChange = Integer.parseInt(view.prompt("Введите id игрушки, " +
                            "у которой хотите изменить шанс выпадения: "));

                    double newFrequency = Double.parseDouble(view.prompt("Введите новые значения шанса выпадения " +
                            "игрушки"));


                    boolean isRightId = false;
                    for (Toy toy: toyRaffle.getToys()){
                        if (toy.getId() == toyIdForChange){
                            isRightId = true;
                            toy.setFrequency(newFrequency);
                            System.out.println("Новые значения установлены!");
                            break;
                        }
                        else {
                            isRightId = false;
                        }
                    }
                    if (isRightId = false){
                        System.out.println("Игрушка с таким Id не нашлась");
                    }

                    break;

                case 5:
                    view.showPrizeToys(toyRaffle.getPrizeToys());
                    break;

                case 6:
                    int toyIdForWinner = Integer.parseInt(view.prompt("Введите id призовой игрушки: "));
                    toyRaffle.deleteToyFromPrizeList(toyRaffle.getPrizeToys(), toyIdForWinner);
                    System.out.println("Вам выдана призовая игрушка!");


                    break;

                case 7:
                    getNewIteration = false;
                    System.out.println("Вы вышли из программы");
                    break;


            }

        }


    }
}
