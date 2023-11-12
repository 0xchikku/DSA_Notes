
public class DoublyLinkedList{

    private Node head;

    private class Node{
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
        }
    }

    DoublyLinkedList(){
        this.head = null;
    }

    public void insertFirst(int val){

        Node newNode = new Node(val);

        newNode.next = this.head;
        newNode.prev = null;
        if(this.head != null){
            this.head.prev = newNode;
        }
        this.head = newNode;
    }

    public void display(){
        Node node = this.head;

        while(node != null){
            System.out.print(node.val + " <-> ");
            node = node.next;
        }

        System.out.println();
    }

    public void deleteNode(int val){

        Node current = this.head;

        // deleting first node
        if(this.head.val == val){
            current.next.prev = current.prev;
            this.head = current.next;
            return;
        }

        while (current != null){
            if(current.val == val){
                // deleting last node
                if(current.next == null){
                    current.prev.next = null;
                    return;
                }else{ //! deleting in between
                    Node prevNode = current.prev;
                    Node nextNode = current.next;

                    prevNode.next = current.next;
                    nextNode.prev = current.prev;
                    return;
                }
            }
            current = current.next;
        }
    }
}