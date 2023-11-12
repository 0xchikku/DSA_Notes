

public class Main{

    public static void main(String[] args){

        DoublyLinkedList list = new DoublyLinkedList();

        for(int  i = 0; i < 9; i++){
            list.insertFirst(i);
        }

        list.display();

        list.deleteNode(2);
        list.display();

        list.deleteNode(0);
        list.display();

        list.deleteNode(8);
        list.display();

    }
}