package cn.plusect;

/**
 * 单链表，增删改查。数据为int型
 *
 * @author plusect
 */
public class SinglyLinkedList {
    private Node head = null;

    /**
     * 根据值查询节点
     */
    public Node getByValue(int value) {
        Node p = head;
        while (p != null && p.data != value)
            p = p.next;
        return p;
    }

    /**
     * 根据index查询节点
     */
    public Node getByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }


    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertAfter(Node p, int value) {
        insertAfter(p, new Node(value, null));
    }

    public void insertBefore(Node p, Node newNode){
        if (p == null){
            return;
        }

        if (head == p){
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }

        if (q == null){
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p){
        if (head == null || p == null){
            return;
        }

        if (head == p){
            return;
        }

        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }

        if (q == null){
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value){
        if (head == null){
            return;
        }

        Node p = head;
        Node q = null;
        while (p != null && p.data != value){
            q = p;
            p = p.next;
        }

        if (p == null){
            return;
        }

        if (q == null){
            head = head.next;
        }else {
            q.next = q.next.next;
        }
    }

    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.println(p.data + " ");
            p = p.next;
        }
    }


    /**
     * 添加节点
     */
    public static Node createNode(int value) {
        return new Node(value, null);
    }


    /**
     * 链表节点定义
     */
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
