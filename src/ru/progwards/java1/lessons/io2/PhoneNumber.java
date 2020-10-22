package ru.progwards.java1.lessons.io2;

//Создать статический метод public static String format(String phone),
// который форматирует телефон под формат +7(999)111-2233, входящий формат может быть различным:
//- 79991112233
//- 8(999)111-22-33
//- 8 999 111 22 33
//
//формальное задание на форматирование:
//- выделить все цифры, отбросить все разделители
//- проверить что цифр в номере 11 или 10, в противном случае выбросить исключение
//- убрать спереди 8
//- добавить, если нужно +7
//- отформатировать под выходной шаблон
public class PhoneNumber {
    public static String format(String phone) throws Exception {
        StringBuilder normalPhone = new StringBuilder();
        for (char c : phone.trim().toCharArray())
            if (Character.isDigit(c)) normalPhone.append(c);
        normalPhone.trimToSize();
        if (normalPhone.capacity()<10 || normalPhone.capacity()>11) throw new Exception("неверный номер телефона");
        if (normalPhone.capacity()==10) normalPhone.insert(0,"8");
        System.out.println(normalPhone.toString().substring(0,1));
        System.out.println(normalPhone.substring(0,1).compareTo("7"));
        if (normalPhone.capacity()==11 & normalPhone.substring(0,1).compareTo("7")==0) {
            System.out.println("11");
            normalPhone.replace(0,1,"8");
        }
        normalPhone.replace(0,1,"7");


        normalPhone.insert(0,"+");
        normalPhone.insert(2,"(");
        normalPhone.insert(6,")");
        normalPhone.insert(10,"-");
        return normalPhone.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(format("+-904-218-15-71"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
