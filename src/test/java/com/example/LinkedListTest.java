package com.example;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void assertEmptyLinkedList(){
        LinkedList list = new LinkedList();
        List<Integer> actualList = list.getNumbers();
        assert(actualList.isEmpty());
    }

    @Test
    public void assertLinkedListOfOneValueCreatedProperly(){
        LinkedList list = new LinkedList(1);
        List<Integer> actualList = list.getNumbers();
        int[] expectedArray = {1};
        int[] actualArray = actualList.stream().mapToInt(i -> i ).toArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void assertLinkedListOfTwoValuesCreatedProperly(){
        int[] expectedArray = {1,2};
        LinkedList list = new LinkedList(expectedArray);
        List<Integer> actualList = list.getNumbers();
        int[] actualArray = actualList.stream().mapToInt(i -> i).toArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void assertLinkedListOfMultipleValuesCreatedProperly(){
        int[] expectedArray = {1,2,3,4,5};
        LinkedList list = new LinkedList(expectedArray);
        List<Integer> actualList = list.getNumbers();
        int[] actualArray = actualList.stream().mapToInt(i -> i).toArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void linkedListWithMultipleValues_valueInsertedAtHead_assertInsertedProperly(){
        int[] listData = {1,2,3,4,5};
        LinkedList list = new LinkedList(listData);
        int expectedNumber = 7;
        list.insertAsHead(expectedNumber);

        int actualNumber = list.getNodeNumber(list.getHead());
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void linkedListWithMultipleValues_valueInsertedAtTail_assertInsertedProperly(){
        int[] listData = {1,2,3,4,5};
        LinkedList list = new LinkedList(listData);
        int expectedNumber = 7;
        list.insertAsTail(expectedNumber);

        int actualNumber = list.getNodeNumber(list.getTail());
        assertEquals(expectedNumber, actualNumber);
    }
}
