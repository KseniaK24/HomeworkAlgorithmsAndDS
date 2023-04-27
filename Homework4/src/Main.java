import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TreeRedBlackLeft tree = new TreeRedBlackLeft();
        int d = 1;
        while (d != 0) {
            System.out.println("Добавить значение в дерево?\n 1 - да,\n 0 - нет");
            Scanner scan = new Scanner(System.in);
            d = scan.nextInt();
            if (d == 1) {
                System.out.println("Введите значение: ");
                int value = scan.nextInt();
                tree.add(value);
                tree.print();
            }
        }

    }
}