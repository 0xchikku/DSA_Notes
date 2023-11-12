


public class Main {
    public static void main(String[] args){
        System.out.println("Main Function");

        Node node = new Node(1);
        LinkedList list = new LinkedList(node);

        for(Integer i = 2; i <= 5; i++){
            list.append(i);
        }

        for(Integer i = 6; i <= 8; i++){
            list.prepend(i);
        }

        list.display();

        // delete head
        list.deleteNode(8);
        list.display();

        // delete tail
        list.deleteNode(5);
        list.display();

        //delete node
        list.deleteNode(1);
        list.display();
    }
}