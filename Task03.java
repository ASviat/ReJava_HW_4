import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) throws SecurityException, IOException {
        Scanner iScanner = new Scanner(System.in);

        LinkedList<Integer> myList = new LinkedList<Integer>();
        int count = 0;
        myList = CalcIt(iScanner, myList, count);
        iScanner.close();
    }

    public static LinkedList<Integer> CalcIt(Scanner x, LinkedList<Integer> mList, int countIt) {

        if (countIt == 0) System.out.println("Введите число 1: ");
        else {
            System.out.println("Info. Введите b для отмены последней операции\nInfo. Введите q для выхода из программы.");
            System.out.println("Введите число или действие(+, -, *, %, /) с полученным значением: ");
        }
        String num1 = x.next();
        if (IsDigit(num1)) {
            System.out.println("Введите действие: ");
            char my_char = x.next().charAt(0);

            System.out.println("Введите число 2: ");
            String num2 = x.next();

            if (IsDigit(num2)) {

                switch (my_char) {
                    case '+':
                        mList.add(Integer.parseInt(num1) + Integer.parseInt(num2));
                        break;
                    case '-':
                        mList.add(Integer.parseInt(num1) - Integer.parseInt(num2));
                        break;
                    case '*':
                        mList.add(Integer.parseInt(num1) * Integer.parseInt(num2));
                        break;
                    case '%':
                        mList.add(Integer.parseInt(num1) % Integer.parseInt(num2));
                        break;
                    case '/':
                        mList.add(Integer.parseInt(num1) / Integer.parseInt(num2));
                        break;
                }

                System.out.printf("%s %c %s = %s\n", num1, my_char, num2, mList.getLast());
                countIt++;
                return CalcIt(x, mList, countIt);

            } else {
                System.out.println("Введите число!");
                return CalcIt(x, mList, countIt);
            }
        } else {
            if (num1.equals("q")) {
                return mList;
            }
            if (num1.equals("b")) {
                try {
                    mList.removeLast();
                    System.out.printf("Последний результат до отмены действия: %s\n", mList.getLast());

                    countIt--;
                    return CalcIt(x, mList, countIt);
                } catch (Exception e) {
                    System.out.println("Не введено значение, к которому можно вернуться.");
                    return CalcIt(x, mList, countIt);
                }

            }
            if (num1.equals("+") || num1.equals("-") || num1.equals("*")
                    || num1.equals("%") || num1.equals("/")) {

                System.out.println("Введите число: ");
                String num2 = x.next();
                if (IsDigit(num2)) {

                    switch (num1) {
                        case "+":
                            mList.add(mList.peekLast() + Integer.parseInt(num2));
                            break;
                        case "-":
                            mList.add(mList.peekLast() - Integer.parseInt(num2));
                            break;
                        case "*":
                            mList.add(mList.peekLast() * Integer.parseInt(num2));
                            break;
                        case "%":
                            mList.add(mList.peekLast() % Integer.parseInt(num2));
                            break;
                        case "/":
                            mList.add(mList.peekLast() / Integer.parseInt(num2));
                            break;
                    }

                    System.out.printf("%s %s %s = %s\n", mList.get(countIt - 1), num1, num2, mList.getLast());
                    countIt++;
                    return CalcIt(x, mList, countIt);
                }
            }
            System.out.println("Моя твоя не понимать");

            return CalcIt(x, mList, countIt);
        }
    }

    private static boolean IsDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}