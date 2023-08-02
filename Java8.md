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



> Function<T, R>

- Input과 Output Type이 존재하는 Functional Interface

```java
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);
    ...
 }
```



> Consumer<T>

- Input 값이 존재하고 void DataType을 반환하는 Functional Interface

```java
/**
 * Represents an operation that accepts a single input argument and returns no
 * result. Unlike most other functional interfaces, {@code Consumer} is expected
 * to operate via side-effects.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #accept(Object)}.
 *
 * @param <T> the type of the input to the operation
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);
  ...
}
```



> Predicate<T>

- Input과 boolean DataType을 반환하는 Functional Interface
- 주로 데이터를 분별하는 Filter로 사용된다.

```java
@FunctionalInterface
public interface Predicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t);
    ...
}
```





> Supplier<T>

- input없이 output있는 Functional Interface이다.
- Raise Value를 체크할때 많이쓰임

```java
package java.util.function;
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}

```



> CustomFunction

- 사용자 정의 Custom Function도 정의할 수 있다.
- 가급적 Compile 단계에서 내가 만든 Function을 체크하기 위해서 @FunctionalInterface Annotation을 붙여준다.

```java
@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
    //  void print(int i);
}
```
