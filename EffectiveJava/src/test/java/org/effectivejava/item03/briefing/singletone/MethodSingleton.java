package org.effectivejava.item03.briefing.singletone;

public class MethodSingleton {
    private static final MethodSingleton INSTANCE = new MethodSingleton();

    private MethodSingleton(){

    }
    public static MethodSingleton getInstance(){
        return INSTANCE;
    }

    //API를 변경하지 않고 싱글턴이 아니게 변경할 수 있다.
    public static MethodSingleton getInstancV1(){
        return new MethodSingleton();
    }
}
