# [ITEM03]private 생성자나 열거타입으로 싱글턴임을 보장하라

싱글턴(Singleton)이란, 인스턴스를 오직 하나만 생성할 수 있는 클래스를 의미한다.

- Stateless한 객체를 만들때 사용한다. 

싱글턴 생성방법은 다음과 같다.

### 1.Public static final 필드 방식

해당 객체생성 패턴은, 사용자가 필요한 매개변수에 따라 생성자를 만드는 방식이다. 

이 방식은 다음과 같은 단점이 있다.

- 매개변수가 많아지면, 생성자를 일일이 다 만들어줘야 되서, 코드가독성 및 효율이 떨어진다.

- 확장하기 어렵다
- 매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다

```java

public class Elvis {

    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {

    }

    public void leaveTheBuilding(){
        System.out.println("호출이 정상적으로 동작합니다.");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

```

<hr>


