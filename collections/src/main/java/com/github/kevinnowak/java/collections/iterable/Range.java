package com.github.kevinnowak.java.collections.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Range implements Iterable<Integer> {
    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {
        private int cursor = start;

        @Override
        public boolean hasNext() {
            return cursor <= end;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return cursor++;
        }
    }
}
