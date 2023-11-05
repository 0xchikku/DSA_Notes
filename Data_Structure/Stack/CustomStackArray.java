import java.util.Arrays;
import java.util.Scanner;

public class CustomStackArray {

  private int top = -1;
  private int stackSize;
  private int[] stackArray;
  Scanner input = new Scanner(System.in);

  CustomStackArray(int stackSize){
    this.stackSize = stackSize;
    this.stackArray = new int[stackSize];
  }

  public boolean underFlow(){
    return this.top == -1;
  }

  public boolean overFlow(){
    return this.top == (this.stackSize - 1);
  }

  public void push(){
    if(!overFlow()){
      System.out.println("Enter the number: ");
      int element = input.nextInt();
      this.top++;
      this.stackArray[top] = element;
      System.out.println(element + " Inserted!");
    }else{
      System.out.println("--- Stack is Full ---");
    }
  }

  public void pop(){
    if(!underFlow()){
      this.stackArray[top] = 0;
      this.top--;
      System.out.println("Removed!");
    }else{
      System.out.println("--- Stack is Empty ---");
    }
  }

  public void display(){
    if(!underFlow()){
      System.out.println(Arrays.toString(stackArray));
    }else{
      System.out.println("--- Stack is Empty ---");
    }
  }

  public static void main(String[] args) {
    System.out.println("------- Stack Program -------");
    System.out.println("Enter the size of the stack: ");
    Scanner input = new Scanner(System.in);
    int stackSize = input.nextInt();
    boolean runProgram = true;

    CustomStackArray stack = new CustomStackArray(stackSize);


    while(runProgram){
      System.out.println("------- Main Menu -------");
      System.out.println("What operation do you want to perform?: ");
      System.out.println("1. Push \n2. Pop \n3. Display \n0. Main Menu \n --- Enter any key to exit ---");

      int option = input.nextInt();
      switch (option){
        case 0:{
          continue;
        }
        case 1:{
          // push
          stack.push();
          break;
        }
        case 2:{
          //pop
          stack.pop();
          break;
        }
        case 3:{
          // display
          stack.display();
          break;
        }
        default:{
          System.out.println("--- Program End ---");
          runProgram = false;
          break;
        }
      }
    }
  }
}