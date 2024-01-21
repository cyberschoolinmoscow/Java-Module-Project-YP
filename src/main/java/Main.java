import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = 0;
        Boolean isNumberCorrect = false;
        while (!isNumberCorrect) {
            System.out.println("На скольких человек необходимо разделить счёт?");

            try {
                Scanner scanner = new Scanner(System.in);

                number = scanner.nextInt();
                if (number <= 1) {
                    System.out.println("Ошибка. Количество гостей должно быть больше 1. Нужно ввести корректное количество гостей.");
                } else {
                    isNumberCorrect = true;
                }
            } catch (Exception e) {
                System.out.println("Ошибка. Количество гостей должно быть числом. Нужно ввести корректное количество гостей.");
            }
        }
        Calculator.number = number;
        while (true) {
            Boolean isNameCorrect = false, isPriceCorrect = false;
            float productPrice = 0;
            String productName = null;

            while (!isNameCorrect) {

                System.out.println("Введите название товара");
                Scanner scanner = new Scanner(System.in);

                productName = scanner.next();
                if (productName.isEmpty() || productName.equals(null)) {
                    System.out.println("Ошибка. Нужно ввести корректное название товара.");

                } else {
                    isNameCorrect = true;
                    break;
                }
            }

            while (!isPriceCorrect) {
                System.out.println("Введите его стоимость");
                try {
                    Scanner scanner = new Scanner(System.in);
                    productPrice = scanner.nextFloat();
                    if (productPrice > 0) {
                        isPriceCorrect = true;
                    } else {
                        System.out.println("Ошибка. Стоимость должна быть больше нуля. Нужно ввести корректную стоимость товара.");
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка. Стоимость должна быть числом. Нужно ввести корректную стоимость товара.");
                }
            }

            Calculator.addItem(new Product(productName, productPrice));

            System.out.println("Добавить ещё один товар?\nВведите любой символ или введите команду \"завершить\" чтобы закончить ввод товаров.");
            Scanner scanner = new Scanner(System.in);

            String response = scanner.next();

            if (response.equalsIgnoreCase("завершить")) {
                Calculator.printCheck();
                System.out.println("Сумма к оплате: "+Calculator.printTotal());
                System.out.println("Каждый гость должен внести по "+Calculator.divided());
                break;

            }
        }
    }
}