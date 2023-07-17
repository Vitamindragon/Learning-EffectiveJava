package org.effectivejava.item03.briefing.singletone;

public class FieldSingleton {
    public static final FieldSingleton INSTANCE = new FieldSingleton();

    private FieldSingleton() {

    }
}
