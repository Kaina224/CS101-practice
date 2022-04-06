package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class QueueTest {
    @Test
    public void emptyQueue_attemptedDequeueThrowsException() throws QueueEmptyException{
        Queue emptyQueue = new Queue();
        Exception exception = assertThrows(QueueEmptyException.class,
                                           () -> emptyQueue.dequeue(),
                                           DataStructureErrors.DEQUEUEING_EMPTY_QUEUE.toString());
        assertEquals(exception.getMessage(), DataStructureErrors.DEQUEUEING_EMPTY_QUEUE.toString());
    }

    @Test
    public void queueOfOne_itemDequeued_dequeuedItemCorrect() throws QueueEmptyException{
        int expectedNumber = 1;
        Queue queueOfOne = new Queue(expectedNumber);
        int actualNumber = queueOfOne.dequeue();
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void queueWithMultipleItems_itemDequeued_dequeuedItemCorrect() throws QueueEmptyException{
        int expectedNumber = 1;
        int [] numbers = {4, 3, 2, expectedNumber};
        LinkedList list = new LinkedList(numbers);
        Queue queue = new Queue(list);
        int actualNumber = queue.dequeue();
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void queueWithMultipleItems_multipleItemsEnqueuedAndDequeued_assertDequeuedItemsCorrect()
    throws QueueEmptyException {
        int expectedNumberOne = 1;
        int expectedNumberTwo = 2;
        int expectedNumberThree = 3;
        int[] numbers = {4,
                         expectedNumberThree,
                         expectedNumberTwo,
                         expectedNumberOne};
        LinkedList list = new LinkedList(numbers);
        Queue queue = new Queue(list);
        int actualNumberOne = queue.dequeue();
        int actualNumberTwo = queue.dequeue();
        int actualNumberThree = queue.dequeue();

        assertEquals(expectedNumberOne, actualNumberOne);
        assertEquals(expectedNumberTwo, actualNumberTwo);
        assertEquals(expectedNumberThree, actualNumberThree);
    }

    @Test
    public void queueWithMultipleItems_dequeuedBeyondCapacity_assertQueueEmptyExceptionThrown()
    throws QueueEmptyException {
        int[] numbers = {1,2,3};
        LinkedList list = new LinkedList(numbers);
        Queue queue = new Queue(list);
        int numberOne = queue.dequeue();
        int numberTwo = queue.dequeue();
        int numberThree = queue.dequeue();
        Exception exception = assertThrows(QueueEmptyException.class,
                                           () -> queue.dequeue(),
                                           DataStructureErrors.DEQUEUEING_EMPTY_QUEUE.toString());
        assertEquals(exception.getMessage(), DataStructureErrors.DEQUEUEING_EMPTY_QUEUE.toString());
    }
}
