
public class LinkedList {

    public Node head;
    public Node tail;

    LinkedList(Node node){
        this.head = node;
        this.tail = node;
    }

    public void append(Integer data){

        Node newNode = new Node(data);

        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public void prepend(Integer data){

        Node newHead = new Node(data);

        newHead.next = this.head;
        this.head = newHead;
    }


    private void _deleteTailNode(Node node){
        node.next = null;
        this.tail = node;
    }

    static private void _deleteNode(Node node){
        node.next = node.next.next;
    }

    private void _deleteHeadNode(){
        this.head = this.head.next;
    }

    public void deleteNode(Integer data){

        if(this.head.data == data){
            _deleteHeadNode();
            return;
        }

        Node current = this.head;

        while(current.next != null){
            if(current.next.data == data){
                if(current.next == this.tail){
                    _deleteTailNode(current);
                }else{
                    _deleteNode(current);
                }
                return;
            }
            current = current.next;
        }
    }
    public void display(){

        Node current = this.head;

        if(current == null){
            System.out.println("Empty List");
        }else{
            while(current != null){
                System.out.print(current.data + " <- ");
                current = current.next;
            }
        }

        System.out.println();
        System.out.println("Head -> " + this.head.data);
        System.out.println("Tail -> " + this.tail.data);
    }
}