import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите верхнюю границу для значений: ");
        int m = Integer.parseInt(scanner.nextLine());

        logger.log("Создаём и наполняем список");
        ArrayList list = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(m));
        }
        System.out.println("Вот случайный список: " + list.toString());

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int f = Integer.parseInt(scanner.nextLine());

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(f);
        List filterOutList = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filterOutList.toString());
        logger.log("Завершаем программу");
    }
}
