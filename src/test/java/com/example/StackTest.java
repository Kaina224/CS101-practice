package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

public class StackTest {
    @Test
    public void emptyStack_throwsStackEmptyException(){
        Stack emptyStack = new Stack();
        Exception exception = assertThrows(StackEmptyException.class,
                                           () -> emptyStack.pop(),
                                           DataStructureErrors.POPPING_EMPTY_STACK.toString());
        assertEquals(exception.getMessage(), DataStructureErrors.POPPING_EMPTY_STACK.toString());
    }

    @Test
    public void stackOfOneValue_stackPopped_assertValuePoppedCorrectly() throws StackEmptyException{
        int expectedNumber = 1;
        LinkedList listOfOne = new LinkedList(expectedNumber);
        Stack stackOfOne = new Stack(listOfOne);
        int actualNumber = stackOfOne.pop();
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void stackOfMultipleValues_stackPoppedAndPushed_assertStackValuesAreCorrect() 
    throws StackEmptyException{
        int[] numbers = {6, 3, 7, 8, 1};
        LinkedList largerList = new LinkedList(numbers);
        Stack stack = new Stack(largerList);
        
        stack.push(8);
        stack.push(3);
        int firstExpectedPoppedNumber = 9;
        stack.push(firstExpectedPoppedNumber);
        int firstActualPoppedNumber = stack.pop();

        int secondExpectedPoppedNumber = 4;
        stack.push(secondExpectedPoppedNumber);
        int secondActualPoppedNumber = stack.pop();

        assertEquals(firstExpectedPoppedNumber, firstActualPoppedNumber);
        assertEquals(secondExpectedPoppedNumber, secondActualPoppedNumber);

        String expectedStack = "3-8-6-3-7-8-1";
        String actualStack = stack.getStack();
        assertEquals(expectedStack, actualStack);
    }

    @Test
    public void stackOfMultipleValues_stackCompletelyPopped_throwsStackEmptyException() 
    throws StackEmptyException{
        int firstExpectedPoppedNumber = 7;
        int secondExpectedPoppedNumber = 4;
        int thirdExpectedPoppedNumber = 1;

        int[] numbers = {firstExpectedPoppedNumber, 
                         secondExpectedPoppedNumber, 
                         thirdExpectedPoppedNumber};
        LinkedList list = new LinkedList(numbers);
        Stack stack = new Stack(list);

        int firstActualPoppedNumber = stack.pop();
        int secondActualPoppedNumber = stack.pop();
        int thirdActualPoppedNumber = stack.pop();

        assertEquals(firstExpectedPoppedNumber, firstActualPoppedNumber);
        assertEquals(secondExpectedPoppedNumber, secondActualPoppedNumber);
        assertEquals(thirdExpectedPoppedNumber, thirdActualPoppedNumber);

        Exception exception = assertThrows(StackEmptyException.class,
                                           () -> stack.pop(),
                                           DataStructureErrors.POPPING_EMPTY_STACK.toString());
        assertEquals(exception.getMessage(), 
                     DataStructureErrors.POPPING_EMPTY_STACK.toString());
    }

}
