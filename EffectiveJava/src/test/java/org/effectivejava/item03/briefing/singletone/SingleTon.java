package org.effectivejava.item03.briefing.singletone;

import org.effectivejava.item03.briefing.Singletone;

public class SingleTon {

    private static volatile SingleTon instance;//캐시메모리가 아닌 메인메모리에서 값을 가져옴
    private SingleTon(){};

    /**
     * 해당 부분은 RaceCondition이 발생한다.
     * 즉, Thread Safety 하지않음
     * (보통 요즘 PC들은 멀티스레드 환경이기때문에)
     */
    public static SingleTon getInstanceV1(){
        if(instance==null)//Race Condition 발생부분
            instance = new SingleTon();

        return instance;
    }

    /**
     * synchronized 옵션을 통해서, method Lock을 걸어 문제해결
     * 하지만, 이 방식은 비용이 많이발생
     */
    public static synchronized SingleTon getInstanceV2(){
        if(instance==null)//Race Condition 발생부분
            instance = new SingleTon();

        return instance;
    }

    /**
     * synchronized 옵션을 통해서, method Lock을 걸어 문제해결
     * 하지만, 이 방식은 비용이 많이발생
     */
    public static SingleTon getInstanceV3(){
        if(instance==null)//Race Condition 발생부분
            synchronized (Singletone.class){
                if(instance ==null)
                    instance = new SingleTon();
            }
        return instance;
    }

}
