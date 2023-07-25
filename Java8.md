# Java8

> First-Class Citizen

1. Element를 메소드 인자로 넘겨줄 수 있다.

   ```java
   Element el = new Element();
   callMethod(el)
   ```

2. 메소드 결과값으로 Element를 받을 수 있다.

   ```java
   Element result = callMethod(el)
   ```

3. DataStructure 안에 Element를 저장할 수 있어야한다.

   ```java
   List<Element> list = Arrays.asList(el,el2);
   ```

✓ **자바에서는 Object가 First-Class Citizen인데 java8부터 Method도 First-Class Method를 지원함**



> Functional Interface

- 오직 1개의 추상메서드를 가진 인터페이스를 Functional Interface라한다.

> Identity Method

- 데이터타입의 Input과 Output이 같다. 더불어, 전달받은 인자 값을 별도의 조작없이 반환해야한다

```java
//identity(0)
public String identity(String value){
		return value;
}

//identity(X)
public String identity(String value){
		return value + "1";
}
```

