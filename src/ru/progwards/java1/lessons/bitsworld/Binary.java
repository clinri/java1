package ru.progwards.java1.lessons.bitsworld;
//3.1 Реализовать конструктор
//public Binary(byte num).
//3.2 Реализовать метод
//public String toString(), который возвращает двоичное представление числа типа byte, используя только битовые операции. В выводимом значении всегда должно быть 8 символов
//Например:
//0: "00000000"
//1: "00000001"
//127: "01111111"
//-128: "10000000"
//-1: "11111111"
public class Binary {
    byte num;
    public Binary(byte num){
        this.num=num;
    }

    public String toString(){
        String strBin = "";
        for (int i=0; i<8; i++){
            strBin = Byte.toString((byte) (this.num & 1)) + strBin;
            this.num >>>=1;
        }
        return strBin;
    }

    public static void main(String[] args) {
        System.out.println(new Binary((byte) 0b10000001).toString());
    }

}
