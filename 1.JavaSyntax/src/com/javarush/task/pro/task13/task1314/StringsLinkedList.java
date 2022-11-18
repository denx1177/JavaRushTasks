package com.javarush.task.pro.task13.task1314;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        String resultStr = null;
        int count = -1; // Потому что начали с first кторый имеет индекс -1
        Node currentNode = first; // Начали с first что бы в цикле проверять наличие ПОСЛЕДУЮЩЕГО элемента, а не текущего
//        ---- первый вариант с лишней проверкой
//        while (currentNode.next != null && currentNode.next != last && count < index) {
        while (currentNode.next != null && count < index) {
         currentNode = currentNode.next;
         count++;
        }
        if (count == index){
            resultStr = currentNode.value;
        }
        return resultStr;
    }

//    public void printAll() {
//        Node currentElement = first.next;
//        while ((currentElement) != null) {
//            System.out.println(currentElement.value);
//            currentElement = currentElement.next;
//        }
//    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
