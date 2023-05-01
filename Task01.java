import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void),
 * который вернет “перевернутый” список.
 */
public class Task01 {

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        LinkedList<String> myList = new LinkedList<>(Arrays.asList("1", "A", "2", "B", "3", "C"));
        System.out.println("Начальный список: ");
        System.out.println(myList);
        System.out.println("Перевернутый список: ");
        System.out.println(reverseMyList(myList));
    }

    public static LinkedList<String> reverseMyList(LinkedList<String> mList) {
        Collections.reverse(mList);
        return mList;
    }
}