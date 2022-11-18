package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();
// -------------------- В правильном решении часть 1
//    public StringsLinkedList() {
//        first.next = last;
//        last.prev = first;
//    }

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
//----------------------- Моё решение
        Node newNode = new Node();
        newNode.value = value;
        if(first.next == null) {
            first.next = newNode;
            last.prev = newNode;
        }else{
            newNode.prev = last.prev;
            last.prev.next = newNode;
            last.prev = newNode;
        }
// -------------------- В правильном решении часть 2        
//        Node node = new Node();
//        node.value = value;
//        Node lastNode = last.prev;
//        lastNode.next = node;
//        node.prev = lastNode;
//        last.prev = node;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
