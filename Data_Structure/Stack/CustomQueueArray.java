import java.util.Scanner;
import java.util.Arrays;

public class CustomQueueArray {
    private int capacity, front, rear;
    private int[] queueArray;

    CustomQueueArray(int capacity){
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * to check if queue is full
     * @return boolean
     */
    public boolean isFull(){
        return (this.rear == (capacity - 1));
    }

    /**
     * to check if queue is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return ((this.front > this.rear) || this.front == -1);
    }

    /**
     * to print the overflow message
     */
    private void isOverFlow(){
        System.out.println("Queue is Full!");
    }

    /**
     * to print the underflow message
     */
    private void isUnderFlow(){
        System.out.println("Queue is Empty");
    }

    /**
     * insert first item in the queue
     */
    private void insertFirstElement(){
        this.front = 0;
        this.rear = 0;
    }

    /**
     * to insert element in the queue
     * @param data {int} - element to insert in the queue
     */
    public void enqueue(int data){
        if(this.isFull()){
            this.isOverFlow();
        }else{
            if(this.isEmpty()){
                this.insertFirstElement();
            }else{
                moveForward(this.rear);
            }
            this.queueArray[rear] = data;
            System.out.println("Element Inserted");
        }
    }

    /**
     * to check if front has reached end (rear)
     * @return boolean
     */
    private boolean needsReset(){
        return this.front == this.rear;
    }

    /**
     * to reset the front and rear position
     */
    private void resetQueue(){
        this.front = -1;
        this.rear = -1;
    }

    /**
     * increament the position by 1
     * @param position {boolean} - position element
     */
    static private void moveForward(int position){
        position++;
    }

    /**
     * to remove the element from the queue
     */
    public void dequeue(){
        if(this.isEmpty()){
            this.isUnderFlow();
        }else{
            System.out.println("Element removed " + this.queueArray[front]);
            if(this.needsReset()){
                this.resetQueue();
            }else{
                moveForward(this.front);
            }
        }
    }

    /**
     * to display elements of the queue
     */
    public void display(){
        if(this.isEmpty()){
            this.isUnderFlow();
        }else{
            for(int i = front; i <= rear; i++){
                System.out.println("Items in the queue");
                System.out.println(this.queueArray[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Queue Capacity: ");
        int capacity = input.nextInt();
        CustomQueueArray queue1 = new CustomQueueArray(capacity);
        System.out.println("Queue has been created");
        System.out.println("-----------------------");

        System.out.println("Operations to Perform");
        System.out.println("1. Display Queue");
        System.out.println("2. Enqueue Item");
        System.out.println("3. Dequeue Item");
        System.out.println("4. Exit");
        int option;
        do {
            System.out.println("Enter the option: ");
            option = input.nextInt();
            switch (option){
                case 1: {
                    queue1.display();
                    break;
                }
                case 2: {
                    System.out.println("Enter item: ");
                    int item = input.nextInt();
                    queue1.enqueue(item);
                    break;
                }
                case 3:{
                    queue1.dequeue();
                    break;
                }
                case 4:{
                    System.out.println("Program Ended!");
                    break;
                }
                default:{
                    System.out.println("Invalid option! try again!");
                }
            }

        }while(option != 4);
    }
}