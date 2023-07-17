package org.modernjava.e01;

/**
 * 객체지향스럽지 않은 Calculator Application
 * ㅁ 코드가 지저분하고, 디버깅하기 쉽지않음(비지니스로직이 추가되면 복잡해짐)
 *
 * @author VitaminDraogn
 * @since 2023-07-17
 */
public class PureJavaExample {

    class Calculator {

        public int calculator(char command, int num1, int num2) {
            if (command == '+') {
                return num1 + num2;
            } else if (command == '-') {
                return num1 - num2;
            } else if (command == '*') {
                return num1 * num2;
            } else if (command == '/') {
                if (num2 == 0)
                    throw new IllegalArgumentException("Invalid input num1: " + num1 + " num2: " + num2);
                return num1 / num2;
            }

            throw new IllegalArgumentException("Invalid input command");
        }
    }

}
