# [ITEM01]생성자 대신 정적 팩터리 메서드를 고려하라

클라이언트는 보통 생성자를 이용하여 객체를 생성한다. 그러나 이러한 생성방식 보다. 정적 팩터리 메서드를 만들어서 하는 것이 장점이 많다. 관련해서 해당 방식의 장점과 단점을 설명하도록 하겠다. 

<hr>

**장점**

1. 이름을 가질 수 있다.
2. 호출될 때마다 인스턴스를 새로 생성하지않아도된다.
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
5. 정적팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

**단점**

1. 상속을 하라면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.

<hr>

### [장점1]이름을 가질 수 있다.

생성자를 통해 객체를 생성하게되면, 객체의 특성을 클래스명과 매개변수명만으로 추론하기 어렵다. 

그러나 정적 팩터리 메서드를 통해서는 **객체의 특성을 명확히 설명할 수 있다.**

```java
public class Book {
    private String name;
    private String author;

    public static Book createBookFromName(String name){
        Book book = new Book();
        book.name = name;
        return book;
    }
    //정적 팩토리 메서드 -> 제약 없이 같은 파라미터의 인스턴스 반환 객체 생성 가능
    public static Book createBookFromAuthor(String author){
        Book book = new Book();
        book.author = author;
        return book;
    }

    public static void main(String[] args) {
        Book book = Book.createBookFromName("Effective Java");
    }
}
```



더블어, **생성자 메서드는 시그니처 제약이 존재한다.**

```java
public class Book {
    private String name;
    private String author;

    public Book(String name){
        this.name = name;
    }
    
    //위 생성자와 같은 타입의 파라미터로 시그니처 중복으로 오류 발생
    public Book(String author){
        this.author = author;
    }
}
```

<hr>

### [장점2]호출할 때마다 인스턴스를 새로 생성하지 않아도 된다.

불필요한 객체 생성을 막거나, immutable한 클래스를 만들기 위해 사용한다.

하기 예제 외에도, Boolean.valueof 정적팩토리메서드는 새로운 객체를 만들지 않고 캐싱된 객체를 반환한다. 

이러한 방식은, 불필요한 객체생성을 방지하고, 성능을 향상시킬 수 있다.

```java
public class Book {
    private String name;
    private String author;
    private static final Book book = new Book("Effective Java");

    private Book(String name){
        this.name = name;
    }
    public static Book getInstance(){
        return book;
    }

    public static void main(String[] args) {
        Book book = Book.getInstance();
    }
}
```

<hr>

### **[장점3]반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.**

생성자와 다르게 반환 타입의 상위객체를 반환할 수 있기 때문에 유연성과 확장성을 가짐

```java
public class Card {
    private static final String SAMSUNG_CARD = "SAMSUNG";
    private static final String APPLE_CARD = "APPLE";

    static Payment payment(String name){
        switch (name){
            case SAMSUNG_CARD: return new Samsung();
            case APPLE_CARD: return new Apple();
        }
        throw new IllegalArgumentException();
    }
}
```



<hr>

### **[장점4]**입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.**

장점3가 같은 의견으로, 매개변수의 갯수의 따라 하위객체 타입을 변경할 수 있다.

<hr>

### [장점5] **정적팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.**

<hr>

### [단점1]**상속을 하라면 public이나 protected 생성자가 필요하니 <u>정적 팩터리 메서드만</u> 제공하면 하위 클래스를 만들 수 없다.**

- java.util.Collections은 static으로만 이루어져있다. 이러한 경우 구현체는 상속할 수 없다. (불변타입으로 만들려는 이 제약을 지켜야하다는 오히려 장점일 수 있음)  

- private 생성자를 통해 외부 생성을 막고, 정적 팩터리 메서드만을 사용하여 인스턴스를 반환할 경우, 하위 클래스를 만들 수 없다.

<hr>

### [단점2]**정적 팩터리 메서드는 프로그래머가 찾기 어렵다.**

생성자의 경우 javaDoc이 자동으로 컬럼을 두어 표시하지만 정적 팩토리 메서드의 경우 그런 표시가 없기 때문에 프로그래머가 찾기 어렵다. 따라서 문서화 및 명명규칙에 따라 만드는것을 권장한다.

| **명명 규칙**                  | **설명**                                                     |
| ------------------------------ | ------------------------------------------------------------ |
| **from()**                     | 매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메소드. ex) Date.from() |
| **of()**                       | 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메소드. ex) Enum.of() |
| **valueOf()**                  | from 과 of 의 더 자세한 버전 ex) BigInteger.valueOf()        |
| **instance() getInstance()**   | (매개 변수를 받는다면) 매개변수로 명시한 인스턴스를 반환하지만 같은 인스턴스임을 보장하지는 않는다. ex)StackWalker.getInstance() |
| **create()** **newInstance()** | instance 혹은 getInstance와 같지만 매번 새로운 인스턴스를 생성해 반환함을 보장한다. ex) Array.newInstance() |
| **getType()**                  | getInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩토리 메소드를 정의할 때 쓴다. ex)Files.getFileStore() |
| **newType()**                  | newInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩토리 메소드를 정의할 때 쓴다. ex)Files.newBufferedReader() |
| **type()**                     | getType과 newType의 간결한 버전 ex)Collections.list()        |