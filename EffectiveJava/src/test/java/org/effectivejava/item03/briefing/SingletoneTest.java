package org.effectivejava.item03.briefing;

import org.assertj.core.api.Assertions;
import org.effectivejava.item03.briefing.singletone.FieldSingleton;
import org.effectivejava.item03.briefing.singletone.MethodSingleton;
import org.effectivejava.item03.briefing.singletone.SingleTon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleTonTest {


    @Test
    @DisplayName("싱글톤 객체 동일성 체크")
    void singleToneTest001(){
        SingleTon singleton1 = SingleTon.getInstanceV1();
        SingleTon singleton2 = SingleTon.getInstanceV1();
        System.out.println(singleton1);
        System.out.println(singleton2);
        assertEquals(singleton1,singleton2);
    }


    @Test
    @DisplayName("싱글톤 객체 Race Conditon Check")
    void singleToneTest002(){
        List<Thread> threads = new ArrayList<>();
        Runnable runnable = ()->{
            SingleTon singleTone = SingleTon.getInstanceV1();
            System.out.println(singleTone);
        };
        for(int i=0; i<10; i++)
            threads.add(new Thread(runnable));

        for(int i=0; i<threads.size(); i++){
            Thread thread = threads.get(i);
            thread.start();
        }
        
    }

    @Test
    @DisplayName("싱글톤 객체 메소드 Lock을 통한 race condition 문제해결")
    void singleToneTest003(){
        List<Thread> threads = new ArrayList<>();
        Runnable runnable = ()->{
            SingleTon singleTone = SingleTon.getInstanceV2();
            System.out.println(singleTone);
        };
        for(int i=0; i<10; i++)
            threads.add(new Thread(runnable));

        for(int i=0; i<threads.size(); i++){
            Thread thread = threads.get(i);
            thread.start();
        }
    }


    @Test
    @DisplayName("싱글톤 객체 특정부분 Lock을 통한 race condition 문제해결")
    void singleToneTest004(){
        List<Thread> threads = new ArrayList<>();
        Runnable runnable = ()->{
            SingleTon singleTone = SingleTon.getInstanceV3();
            System.out.println(singleTone);
        };
        for(int i=0; i<10; i++)
            threads.add(new Thread(runnable));

        for(int i=0; i<threads.size(); i++){
            Thread thread = threads.get(i);
            thread.start();
        }
    }



    @Test
    @DisplayName("Field Singleton 테스트")
    void fieldSingletonTest(){
        List<Thread> threads = new ArrayList<>();
        Runnable runnable = ()->{
            FieldSingleton singleTone = FieldSingleton.INSTANCE;
            System.out.println(singleTone);
        };
        for(int i=0; i<10; i++)
            threads.add(new Thread(runnable));

        for(int i=0; i<threads.size(); i++){
            Thread thread = threads.get(i);
            thread.start();
        }
    }

    @Test
    @DisplayName("Method Singleton 테스트")
    void methodSingletonTest(){
        List<Thread> threads = new ArrayList<>();
        Runnable runnable = ()->{
            MethodSingleton singleTone = MethodSingleton.getInstance();
            System.out.println(singleTone);
        };
        for(int i=0; i<10; i++)
            threads.add(new Thread(runnable));

        for(int i=0; i<threads.size(); i++){
            Thread thread = threads.get(i);
            thread.start();
        }

    }
}