package com.example;

public class Queue {
    private LinkedList list;

    Queue(){
        list = new LinkedList();
    }

    Queue(int number){
        list = new LinkedList(number);
    }

    Queue(LinkedList list){
        this.list = list;
    }

    public void enqueue(int number){
        list.insertAsHead(number);
    }

    public int dequeue() throws QueueEmptyException{
        int dequeuedNumber = list.getAndRemoveTail();
        if(dequeuedNumber == -1) {
            throw new QueueEmptyException(DataStructureErrors.DEQUEUEING_EMPTY_QUEUE.toString());
        }
        return dequeuedNumber;
    }

}
