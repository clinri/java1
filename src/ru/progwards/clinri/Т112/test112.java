package ru.progwards.clinri.Т112;

import java.util.Scanner;

//Создайте метод с сигнатурой public void scanLines(), который реализует следующий алгоритм:
//- вводить с клавиатуры строки, до тех пор, пока во входной строке не встретится "/stop"
//- если во входной строке содержится "Привет" вывести на консоль "Здравствуйте!"
//- если во входной строке содержится "как дела" вывести на консоль "Хорошо"
//- если во входной строке содержится "/stop" - закончить выполнение метода
//- во всех остальных случая вывести введенную строку на консоль
//
//Примечание: для проверки, содержит ли строка, содержимое другой строки используйте метод класса String boolean contains(String str)
public class test112 {
    public static void scanLines() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (word.contains("/stop")) {
                break;
            }
            if (word.contains("Привет")) {
                System.out.println("Здравствуйте!");
                continue;
            }
            if (word.contains("как дела")) {
                System.out.println("Хорошо");
                continue;
            }
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        scanLines();
    }
}

