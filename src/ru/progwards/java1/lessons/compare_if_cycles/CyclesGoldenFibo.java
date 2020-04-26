package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static void main(String[] args){
        for (int i=1;i<16;i++) {
            System.out.println(+fiboNumber(i));
        }
        for (int t1=1; t1<101; t1++){
            for (int t2=1; t2<101; t2++){
                for (int t3=1; t3<101; t3++){
                    if (isGoldenTriangle(t1,t2,t3)) System.out.println("треугольник со сторонами " + t1 + " " + t2 + " " + t3 + " золотой" +isGoldenTriangle(t1,t2,t3));
                }
            }
        }
//        int a=528343434;
//        int b=2;
//        int fibo=8;
//        int t1 = 19;
//        int t2 = t1;
//        int t3 = 31;
//        System.out.println("число number содержит цифру digit " +containsDigit(a,b));
//        System.out.println(fibo + "-е число фибоначи " +fiboNumber(fibo));
//        System.out.println("треугольник со сторонами " + t1 + " " + t2 + " " + t3 + " " +isGoldenTriangle(t1,t2,t3));

    }
    public static boolean containsDigit(int number, int digit){ //возвращать true, если число number содержит цифру digit
        int nRazr=1;
        int numberX = number;
//        System.out.println(nRazr + " " + numberX);
        while (numberX/10 > 0) { // определение количества разрядов
            numberX /= 10;
            nRazr++;
//            System.out.println(nRazr + " " + numberX);
        }
        int findDigit = numberX; // первое найденное число
        boolean result=false;
        if (digit == findDigit) result=true;
        int numberN = number;
        int sumFindDigit = findDigit;
        for (int i=nRazr-1;i>0;i--){ // перебор цифр в числе с учетом уже найденных
            for (int n=i; n>1;n--){ // получение числа содержащего следующий разряд
                numberN /=10;
            }
            findDigit = numberN - sumFindDigit*10; // определена цифра следующего разряда
            sumFindDigit = sumFindDigit*10+findDigit; // получение числа из уже найденных цифр
//             System.out.println(i + " " + numberN + " " + " " + findDigit + " " + sumFindDigit);
            numberN = number;
            if (digit == findDigit) result=true;
        }
        return result;
    }
/*
возвращать n-ое число Фибоначчи (нумерация начинается с 1, то есть при n = 3 должно вернуться число Фибоначчи 2, а при n = 10 число 55)
 */
    public static int fiboNumber(int n){
        int fibo=0;
        int sumTwoPastDigit=0;
        int onePastDigit=0;
        int twoPastDigit=0;
        for (int i=1; i<=n;i++){
            if (i==1){
                fibo = 1;
                twoPastDigit=1;
                }
            if (i==2){
                fibo = 1;
                onePastDigit=1;
            }
            if (i>2){
//                System.out.print("предыдущие 2 числа " + twoPastDigit + " " + onePastDigit);
                fibo=onePastDigit+twoPastDigit;
                twoPastDigit=onePastDigit;
                onePastDigit=fibo;
            }
//            System.out.println(", а " + i + "-е число фибо = " + fibo); // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
        }
        return fibo;
    }
/*
будет возвращать true, если треугольник со сторонами a, b, c является Золотым. Определим критерии.
Он должен быть равнобедренным и отношение ребра к основанию должно лежать между значениями 1.61703 и 1.61903.
*/
    public static boolean isGoldenTriangle(int a, int b, int c){
        double chekGold =0;
        double aDoub=a;
        double bDoub=b;
        double cDoub=c;
        if (((a + b) > c) & ((a + c) > b) & ((c + b) > a)) {// проверка что треугольник
            if  (a==b || a==c || b==c) { // проверка что равнобедренный
                if (a>b) chekGold=aDoub/bDoub;
                if (b>a) chekGold=bDoub/aDoub;
                if (a>c) chekGold=aDoub/cDoub;
                if (c>a) chekGold=cDoub/aDoub;
                if (b>c) chekGold=bDoub/cDoub;
                if (c>b) chekGold=cDoub/bDoub;
                //System.out.println(chekGold);
            }
        }
        boolean x =false;
        if (chekGold>=1.61703d & chekGold<=1.61903d) x=true; // проверка что золотой
        return x;
    }
}
