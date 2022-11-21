package v1ch09.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Amy");
        list1.add("Carl");
        list1.add("Erica");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Bob");
        list2.add("Doug");
        list2.add("Frances");
        list2.add("Gloria");

        // merge the words from b into a
        ListIterator<String> aIter = list1.listIterator();
        Iterator<String> bIter = list2.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(list1);

        // remove every second word from b
        bIter = list2.iterator();
        while (bIter.hasNext()) {
            // skip one element
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(list2);

        // bulk operation: remove all words in b from a
        list1.removeAll(list2);
        System.out.println(list1);
    }
}