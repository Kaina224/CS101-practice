package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LinkedList {
    private Optional<Node> head;
    private Optional<Node> tail;

    LinkedList(){
        head = Optional.empty();
        tail = Optional.empty();
    }

    LinkedList(int number){
        head = Optional.of(new Node(number));
        tail = head;
    }

    LinkedList(int[] numbers){
        if (numbers.length == 0){
            head = Optional.empty();
            tail = head;
        }
        else if(numbers.length == 1){
            head = Optional.of(new Node(numbers[0]));
            tail = head;
        }

        else{
            head = Optional.of(new Node(numbers[0]));
            Node current = new Node(numbers[1]);
            head.get().next = Optional.of(current);
            for (int i = 2; i < numbers.length; i++){
                Node next = new Node(numbers[i]);
                current.next = Optional.of(next);
                current = next;
            }
            tail = Optional.of(current);
        }
    }

    public void insertAsTail(int number){
        if(head.isPresent()) {
            Node next = new Node(number);
            Node current = head.get();
            while(current.next.isPresent()){
                current = current.next.get(); 
            }
            current.next = Optional.of(next);
            tail = Optional.of(next);
        }
    }

    public void insertAsHead(int number){
        if (head.isPresent()){
            Node newHead = new Node(number);
            newHead.next = Optional.of(head.get());
            head = Optional.of(newHead);
        }
        else{
            head = Optional.of(new Node(number));
        }
    }

    int getAndRemoveHead(){
        if (head.isPresent()){
            Optional<Node> oldHead = head;
            if(head.get().next.isPresent()){
                head = head.get().next;
            }
            else{
                head = Optional.empty();
            }
            return oldHead.get().getNumber();
        }
        else{
            return -1;
        }
    }
    public List<Integer> getNumbers(){
        List<Integer> numbers = new ArrayList<Integer>();
        Optional<Node> current = head;
        while(current.isPresent()){
            Node currentNode = current.get();
            numbers.add(currentNode.getNumber());
            current = currentNode.next;
        }
        return numbers;
    }

    public Optional<Node> getHead(){
        return head;
    }

    public Optional<Node> getTail(){
        return tail;
    }

    public int getNodeNumber(Optional<Node> node){
        if (node.isPresent()){
            return node.get().getNumber();
        }
        else{
            return -1;
        }
    }

    private class Node{
        private int number;
        Optional<Node> next;

        public Node(int number){
            this.number = number;
            this.next = Optional.empty();
        }

        public int getNumber(){
            return number;
        }
    }
}
