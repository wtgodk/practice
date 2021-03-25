package x.godk;

import x.godk.collection.list.ArrayList;
import x.godk.collection.list.List;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Hello world!
 */
public class App {
    private static int currentSize = 10;
    private static int maxSize = 20;

    public static void main(String[] args) {
        int val = 20;
        ConcurrentHashMap<Integer,Integer> chm = new ConcurrentHashMap<>();
        chm.put(1,2);
        chm.put(2,2);
        chm.put(3,2);
        chm.put(4,2);
        chm.put(5,2);
        chm.put(6,2);
        chm.put(7,2);
        chm.put(82,2);
        chm.put(81,2);
        chm.put(83,2);
        chm.put(584,2);
        chm.put(86,2);
        chm.put(238,2);
        chm.put(81232,2);
        chm.put(81,2);
        chm.put(812,2);
        chm.put(83,2);
        java.util.List testList = new java.util.ArrayList();
        testList.remove(1);
        //   grow(16);
        //   System.out.println(currentSize);
        String[] str = {};
        System.out.println(str.length);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = currentSize;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }

        if (newCapacity - maxSize > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        currentSize = newCapacity;

        // minCapacity is usually close to size, so this is a win:

    }


    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > maxSize) ?
                Integer.MAX_VALUE :
                maxSize;
    }

}


class Glyph {
    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }

    private void draw() {
        System.out.println("Glyph.draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(). radius = " + radius);
    }

    void draw() {
        System.out.println("RoundGlyph.draw(). radius = " + radius);
    }
}

class PolyConstructors {

    public static void main(String[] args) {
        new RoundGlyph(5);

    }

}