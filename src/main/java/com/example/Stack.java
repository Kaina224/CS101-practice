package com.example;
import java.util.stream.*;

public class Stack {
    private LinkedList list;

    Stack(){
        list = new LinkedList();
    }

    Stack(LinkedList list){
        this.list = list;
    }

    public void push(int number){
        list.insertAsHead(number);
    }

    public int pop() throws StackEmptyException{
        int poppedNumber = list.getAndRemoveHead();
        if(poppedNumber == -1){
            throw new StackEmptyException(DataStructureErrors.POPPING_EMPTY_STACK.toString());
        }
        return poppedNumber;
    }

    public String getStack(){
        return list.getNumbers().stream()
                                .map(i -> String.valueOf(i))
                                .collect(Collectors.joining("-"));
    }
}
