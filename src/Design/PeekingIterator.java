package Design;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    private Integer next;

    private Boolean hasNext;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        advanceIterator();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }
        Integer res = next;
        advanceIterator();
        return res;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    private void advanceIterator() {
        if (it.hasNext()) {
            next = it.next();
            hasNext = true;
        } else {
            hasNext = false;
        }
    }
}
