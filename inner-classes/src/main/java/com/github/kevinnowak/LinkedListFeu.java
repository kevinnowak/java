package com.github.kevinnowak;

import java.util.NoSuchElementException;

public class LinkedListFeu {

    private Entry header = new Entry(null, null, null);
    private int size;

    public LinkedListFeu() {
        header.next = header;
        header.previous = header;
    }

    public Person getLast() {
        if (size == 0) {
            return null;
        }

        return header.previous.element;
    }

    public Person removeLast() {
        if (size == 0) {
            return null;
        }

        Entry last = header.previous;
        Person element = last.element;

        last.previous.next = header;
        header.previous = last.previous;

        size--;

        return element;
    }

    public void addLast(Person p) {
        Entry newEntry = new Entry(p, header, header.previous);
        header.previous.next = newEntry;
        header.previous = newEntry;
        size++;
    }

    public int size() {
        return size;
    }

    private static class Entry {
        private Person element;
        private Entry next;
        private Entry previous;

        public Entry(Person element, Entry next, Entry previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

    public class ListIterator {
        private int nextIndex;
        private Entry next = header.next;

        public boolean hasNext() {
            return nextIndex != size;
        }

        public Person next() {
            if (nextIndex == size) {
                throw new NoSuchElementException();
            }

            Person element = next.element;
            next = next.next;
            nextIndex++;

            return element;
        }
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }
}
