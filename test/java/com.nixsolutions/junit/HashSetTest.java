package com.nixsolutions.junit;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

import static org.junit.Assert.*;

public class HashSetTest {
    private HashSet<String> hashSet;

    @Test public void creatNewHashSetWithNoElements() {
        //when
        hashSet = new HashSet<String>();

        //then
        assertEquals(0, hashSet.size());
    }

    @Test(expected = IllegalArgumentException.class) public void throwExceptionBecauseOfWrongInitialData()
            throws IllegalArgumentException {
        hashSet = new HashSet<String>(-1, -5);
    }

    @Test public void emptySetHasSize0() {
        //given
        hashSet = new HashSet<String>();

        //when
        int size = hashSet.size();

        //then
        assertEquals(0, size);
    }

    @Test public void changeSizeSetAfterAddNewElement() {
        //given
        hashSet = new HashSet<String>();

        //when
        hashSet.add("one");
        hashSet.add("two");
        int firstSize = hashSet.size();
        hashSet.add("three");

        //then
        assertEquals(2, firstSize);
        assertEquals(3, hashSet.size());
    }

    @Test public void setWithElementsIsNotEmpty() {
        //given
        hashSet = new HashSet<String>();

        //when
        hashSet.add("Yellow");
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Blue");

        //then
        assertNotNull(hashSet);
    }

    @Test public void doseNotChangeSetAfterAddElementAlreadyContained() {
        //given
        hashSet = new HashSet<String>();

        //when
        hashSet.add("marvel");
        hashSet.add("marvel");

        //then
        assertEquals(1, hashSet.size());
    }

    @Test public void addElementInSet() {
        //given
        hashSet = new HashSet<String>();

        //when
        hashSet.add("nure");

        //then
        assertTrue(hashSet.contains("nure"));
        assertEquals(1, hashSet.size());
    }

    @Test public void containAddedElementInSet() {
        //given
        hashSet = new HashSet<String>();

        //when
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");

        //then
        assertTrue(hashSet.contains("one"));
        assertTrue(hashSet.contains("three"));
        assertFalse(hashSet.contains("marvel"));
    }

    @Test public void afterRemoveSetDoesNotContainElement() {
        //given
        hashSet = new HashSet<String>();
        hashSet.add("hello");
        hashSet.add("word");

        //when
        boolean wasRemoved = hashSet.remove("word");

        //then
        assertTrue(wasRemoved);
        assertFalse(hashSet.contains("word"));
        assertEquals(1, hashSet.size());
    }

    @Test public void canNotRemoveElementNotFromSet() {
        //given
        hashSet = new HashSet<String>();
        hashSet.add("hello");
        hashSet.add("word");

        //when
        boolean againRemove = hashSet.remove("word!!!");

        //then
        assertFalse(againRemove);
    }

    @Test public void hasNoElementsAfterClear() {
        //given
        hashSet = new HashSet<String>();
        hashSet.add("hello");
        hashSet.add("word");

        //when
        int firstSize = hashSet.size();
        hashSet.clear();

        //then
        assertEquals(2, firstSize);
        assertEquals(0, hashSet.size());
    }

    @Test public void passThroughSetWithIterator() {
        //given
        hashSet = new HashSet<String>();
        hashSet.add("nix");

        //when
        Iterator iterator = hashSet.iterator();

        //then
        while (iterator.hasNext()) {
            assertEquals("nix", iterator.next());
        }
    }

    @Test public void convertFromHashSetToArray() {
        //given
        hashSet = new HashSet<String>();
        hashSet.add("hello");
        hashSet.add("word");
        String[] array;

        //when
        array = hashSet.toArray(new String[0]);

        //then
        assertEquals("hello", array[0]);
        assertEquals("word", array[1]);
    }
}
