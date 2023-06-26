# [ITEM02]생성자에 매개변수가 많다면 빌더를 고려하라

### 1.Telescoping Pattern

해당 객체생성 패턴은, 사용자가 필요한 매개변수에 따라 생성자를 만드는 방식이다. 

이 방식은 다음과 같은 단점이 있다.

- 매개변수가 많아지면, 생성자를 일일이 다 만들어줘야 되서, 코드가독성 및 효율이 떨어진다.

- 확장하기 어렵다
- 매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다

```java
public class Item {
    private String name;
    private Integer price;
    private Integer quantity;

    public Item(String name) {
        this.name = name;
    }

    public Item(Integer price) {
        this.price = price;
    }

    public Item(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public static void main(String[] args) {
        Item item = new Item("apple",3000,2);
    }
}
```

<hr>

### 2. JavaBeans Patern

매개변수가 없는 기본생성자를 만들고, Setter 메서드를 통해 원하는 매개변수값을 설정하는 방식

장점으로는, 1번 방식보다 코드가독성이 높다. 그러나 그 외에 다음과 같은 단점이 있다.

- **객체가 일관된 상태를 유지하기 어렵다.** 
  객체 하나를 생성하기 위해, 여러번의 메서드(Constructor, Setter Methods) 호출해야 되고 이 생성 과정동안 

  객체일관성을 유지하기 어렵다.

  ```java
  //객체의 일관성이란 다음과 같다.
  class A {
    final int a;
    final int b;
  
    A(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }
  /*
  다음과 같은 생성패터일때는, 객체를 생성할때 반드시 필드 a,b에 값이 있음을 보장할 수 있다.
  그러나 JavaBeans Pattern은 클라이언트가 모두 Setter를 해줘야하고 사용자 실수로 Setter Method누락을 한 경우 일관성을 유지하기 어렵다.*/
  ```



- **객체의 불변성을 유지할 수 없다.**

  객체를 완성한 뒤에도 Setter는 여전히 사용하기 때문에 내용이 변경될 여지가 존재한다. 

<hr>

### 3. Builder Pattern

객체의 **생성과정과 표현방법**을 분리해 동일한 생성절차에서 서로다른 표현 결과를 만들 수 있게 하는 패턴이다. 

위 방식은 객체의 일관성과 가독성을 모두 얻은 방식이다. 매개변수가 4개이상일때는 빌더패턴이 더 유리하다.

```java

public class Item {
    private String name;
    private Integer price;
    private Integer quantity;

    private Item(Builder builder){
        this.name = builder.name;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    public static class Builder{
        //필수매개변수
        private final String name;

        //선택 매개변수
        private Integer price;
        private Integer quantity;

        public Builder(String name){
            this.name = name;
        }

        public Builder price(Integer price){
            this.price = price;
            return this;
        }
        public Builder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }

        public Item build(){
            return new Item(this);
        }
    }

    
    public static void main(String[] args) {

        Item item = new Builder("name")
                .price(1000)
                .quantity(2)
                .build();
    }
}

```