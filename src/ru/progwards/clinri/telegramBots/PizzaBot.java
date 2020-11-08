package ru.progwards.clinri.telegramBots;

/*
Документация на Progwards telegramm bot 2
public class ProgwardsTelegramBot extends TelegramLongPollingBot
Класс - наследник класса для создания Телеграмм ботов

public ProgwardsTelegramBot()
конструктор по умолчанию

public String username
usrname бота в Телеграмм

public String token
токен бота в Телеграмм

public void addTags(String name, String tags)
добавить тэги по имени
name - имя груааы тэгов
tags - сами тэги

public FoundTags checkTags(String text)
вернуть теги, соответствующие запросу в text

public boolean checkLastFound(FoundTags found, String text)
проверяет соответствие найденного тому, что в text
return getLastFound(found).toLowerCase().equals(text.toLowerCase());

public String getLastFound(FoundTags found)
вернуть наиболее подходящий элемент

public int foundCount(FoundTags found)
вернуть количество найденного

public String extract(FoundTags found)
вернуть подходящие тэги по запросу

public void setUserData(Integer userid, String name, String data)
сохранить данные data для пользователя user с ключом name

public String getUserData(Integer userid, String name)
получить данные для пользователя user с ключом name

public void cleartUserData(Integer userid)
удалить данные для пользователя user

public String processMessage(Integer userid, String text)
обработка сообщения text пользователя user и выдача результата

public void start()
запускает телеграмм-бота
 */

import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.testlesson.ProgwardsTelegramBot;

import java.util.Scanner;

public class PizzaBot extends ProgwardsTelegramBot {
    private final String menu = "У нас есть пицца, напитки и десерты";

    @Override
    public String processMessage(String text) {
        checkTags(text);

        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Приветствую тебя, о мой повелитель!\n Что желаешь? " + menu;

            if (checkLastFound("конец"))
                return "Спасибо за заказ.";

            if (checkLastFound("дурак"))
                return "Не надоругаться. Я не волшебник, я только учусь";

            return "Отлично, добавляю в заказ " + getLastFound() + " Желаешь что-то еще?";
        }
        if (foundCount() > 1)
            return "Под твой запрос подходит: \n" + extract() + "Выбери что-то одно, и я добавлю это в заказ.";
        return "Я не понял, возможно у нас этого нет, попробуй сказать по другому. " + menu;

    }


    public static void main(String[] args) {
        System.out.println("Hello, bot!");
        ApiContextInitializer.init();

        PizzaBot bot = new PizzaBot();
        bot.username = "ClinriPizzabot";
        bot.token = "934746144:AAFmzmZmzZ3iKHX6ypT0d5FTGtWbgGULL2Y";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello");
        bot.addTags("конец", "конец, все, стоп, нет");
        bot.addTags("дурак", "дурак, придурок, идиот, тупой");

        bot.addTags("Пицца гавайская", "гавайск, пицц, ананас, куриц");
        bot.addTags("Пицца маргарита", "маргарит, пицц, моцарелла, сыр, кетчуп, помидор");
        bot.addTags("Пицца пеперони", "пеперони, пицц, салями, колбас, сыр, кетчуп, помидор");

        bot.addTags("Торт тирамису", "десерт, кофе, маскарпоне, бисквит");
        bot.addTags("Торт медовик", "десерт, мед, бисквит");
        bot.addTags("Эклеры", "десерт, заварной, крем, тесто");

        bot.addTags("Кола", "напит, пить, кола");
        bot.addTags("Холодный чай", "напит, пить, чай, липтон, лимон");
        bot.addTags("Сок", "напит, пить, сок, апельсиноый, яблочный, вишневый");

//        bot.start();
        bot.test();
    }

    void test() {
        Scanner in = new Scanner(System.in);
        String input;
//    	TUser user = new TUser();
        do {
            input = in.nextLine();
//    		System.out.println(processMessage(user, input));
            System.out.println(processMessage(input));
        } while (!input.equals("стоп"));
    }
}








