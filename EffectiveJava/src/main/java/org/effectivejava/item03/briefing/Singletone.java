package org.effectivejava.item03.briefing;

public class Singletone {

    private static Singletone instance;

    public static Singletone getInstance(){
        if(instance==null)//Race Condition 발생부분(Thread 간 경합)
            instance = new Singletone();

        return instance;
    }


}
