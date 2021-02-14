package ru.progwards.java1.lessons.interfaces;

interface Control {
    void start();
    void stop();
    default boolean state(){
        return true;
    }
}

interface Remote{
    default boolean state(){
        return false;
    }
}

class Tv implements Control, Remote {

    @Override
    public void start() {
        System.out.println("tv.start");
    }

    @Override
    public void stop() {
        System.out.println("tv.stop");
    }

    @Override
    public boolean state() {
        return Control.super.state();
    }
}

class Wash implements Control, Remote {

    @Override
    public void start() {
        System.out.println("wash.start");
    }

    @Override
    public void stop() {
        System.out.println("wash.stop");

    }
    @Override
    public boolean state() {
        return Remote.super.state();
    }
}

class Heating implements Control{
    @Override
    public void start() {
        System.out.println("Heating.start");
    }

    @Override
    public void stop() {
        System.out.println("Heating.stop");

    }
}

public class ITest{
    public static void main(String[] args) {
//        operate(new Tv());
//        operate(new Wash());
//        operate(new Heating());
        //startWash();
        System.out.println(new Tv().state());
        System.out.println(new Wash().state());
    }
    static void operate(Control control){
        control.start();
        System.out.println("Do something");
        control.stop();
    }
    static void startWash(){
        Wash wash = new Wash();
        Heating heating = new Heating();
        heating.stop();
        wash.start();
        // ....
        wash.stop();
        if (wash.state())
            heating.start();
    }
}