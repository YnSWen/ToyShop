import java.util.List;
import java.util.Scanner;

public class View {

    public void showMenu(){
        System.out.println("Выберите команду:\n" +
                "1) Произвести розыгрыш\n" +
                "2) Посмотреть какие игрушки участвуют в розыгрыше\n" +
                "3) Добавить новую игрушку для розыгрыша\n" +
                "4) Изменить шанс выпадения игрушки\n" +
                "5) Посмотреть список игрушек, ожидающих выдачи\n" +
                "6) Получить призовую игрушку\n" +
                "7) Выход\n");

    }
    public String prompt(String msg){
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

    public void showToysForRaffle(List<Toy> toys){
        System.out.println("-----------список игрушек для розыгрыша------------");
        for (Toy toy: toys){
            System.out.println(toy);
        }
        System.out.println("---------------");
    }
}

