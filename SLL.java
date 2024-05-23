import java.util.*;


// demo of git bash
public class SinglyLinkedList{
  
    private Node head;

  SinglyLinkedList(){
    this.head = null;
  }
  static class Node{
    private String data;
    private Node next;

    Node(String s){
      this.data = s;
      this.next = null;
    }
  }


  // **************************       Insertion      ******************************

  public void insertAtStart(String d){
     Node newNode = new Node(d);
     newNode.next = head;
     head = newNode;
  }

  public void insertAtEnd(String d){
    Node newNode = new Node(d);
    if(head == null){
      insertAtStart(d);
      return;
    }
    Node current = head;
    while(current.next != null){
      current = current.next;
    }
    current.next = newNode;

  }

  public void insertInBetween(String d , String target ){
    Node newNode = new Node(d);
    Node current = head;
    while (current != null) {
      if(current.data.equals(target)) {
        break;
      }
      current = current.next;
    }
    if(current == null){
      System.out.println("Target Not Found in the List : ( ) ");
    }
    System.out.println("************");
    System.out.println(current.data);
    System.out.println("************");
    newNode.next = current.next;
    current.next = newNode;
    
  }



  // ***************************    Deletion    **********************8

  // 1  . by position  
  
  public void deleteNodeByPosition(int pos){
    Node current = head;
    if(head == null){
      System.out.println("list is Empty : ( ");
      
    }

    if(pos == 0){
      current = current.next;
    }

    for(int i=0 ; i<pos-1;i++){
      current = current.next;
    }

    if(current == null || current.next == null){
      System.out.println("Invalid Position , Data nor found here  : ( ");
      return;
    }

    current.next = current.next.next;
    System.out.println("Node deleted successfully :) ");

  }

  // 2. by data 

  public void deleteNodeByData(String target){
     Node current = head;
    if(head == null){
      System.out.println("List is empty : ( ");
    }
    while(current != null){
      if(current.next.data.equals(target)){
        break;
      }
      current = current.next;
    }

    if(current == null || current.next == null){
      System.out.println("data not found to delete : ( ");
    }

    current.next = current.next.next ;
    System.out.println("Node deleted successfully :) ");
    
  }


  // **********************  Searching operation  ***********************

  public void searchNodeByPosition(int pos){
    Node current = head; 
    if(head == null){
      System.out.println("list is Empty : ( ");
      return;
    }
    if(pos == 0){
      System.out.println("Node Found with data :  " + current.data);
      return;
    }
    for(int i = 0; i<pos  && current != null; i++){
      current = current.next;
    }
    if(current == null){
      System.out.println("invalid Position entered , no node present : ( ");
      return;
    }
    
    System.out.println("Node Found with data :  " + current.data);

    
  }

  public void searchNodeByData(String target){
    Node current = head;
    int pos = 0;
    if(head == null){
      System.out.println("List is Empty : ( ");
    }
    

    while(current != null){
      if(current.data.equals(target)){
        System.out.println("Node found at the position :  " + pos);
        break;
      }
      pos++;
      current = current.next;
    }
    if(current == null){
      System.out.println("Invalid data entered , not present in LinekdLsit : ( ");
      return;
    }
  }


  // ********************************** Printing LinkedList  ***********************

  public void printLinkedList(){
    if(head == null){
      System.out.println("List is Empty :( ");
    }
    Node current = head ; 
    while(current != null){
      System.out.print(current.data + " ---> ");
      current = current.next;
    }
    System.out.println();
  }


  ///////////////// MenuList /////////////

  // main menu
  public static int menuList(){
    Scanner sc = new Scanner(System.in);
     System.out.println("0.Exit");
     System.out.println("1.Insert Node");
     System.out.println("2.Delete Node ");
     System.out.println("3.Print LinkedList");
     System.out.println("4.Search Node "); 
     System.out.println("Enter Your Choice :  ");
    return sc.nextInt();
  }

  //menu to insert the nodes

  public static int menuToInsertNode(){
    Scanner sc = new Scanner(System.in);
     System.out.println("0.Exit");
     System.out.println("1.Insert Node At Start");
     System.out.println("2.Insert Node At End ");
     System.out.println("3.Insert Node In Between  "); 
     System.out.println("Enter Your Choice :  ");
    return sc.nextInt();
  }

  // menu to delete the node

  public static int menuToDeleteNode(){
    Scanner sc = new Scanner(System.in);
     System.out.println("0.Exit");
     System.out.println("1.Delete By Value ");
     System.out.println("2.Delete By Position ");
     System.out.println("Enter Your Choice :  ");
    return sc.nextInt();
  }

  
 // menu to search the node 
  
  public static int menuToSearchNode(){
    Scanner sc = new Scanner(System.in);
     System.out.println("0.Exit");
     System.out.println("1.Search By Value ");
     System.out.println("2.Search By Position ");
     System.out.println("Enter Your Choice :  ");
    return sc.nextInt();
  }
  
  
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    SinglyLinkedList list  = new  SinglyLinkedList();

    int choice;

    while((choice = menuList()) != 0){
      switch(choice){
        case 1 : 
          System.out.println("Insertion Operation in LinkedList :) ");
          while((choice = menuToInsertNode()) !=0){
                System.out.print("Enter the data to Insert  :  ");
                String d = sc.nextLine();
            switch(choice){
              case 1 :
                     list.insertAtStart(d);
                break;
              case 2 : 
                   list.insertAtEnd(d);
                break;
              case 3 : 
                System.out.print("Enter the node data after which your want to insert  :  ");
                String target = sc.nextLine();
                  list.insertInBetween(d , target);
                break;
            }
          }
          
          break;
        case 2 :
          System.out.println("Deletion Operation in LinkedList :) ");
          while((choice = menuToDeleteNode()) !=0){            
          switch(choice){
            case 1 :
                   System.out.print("Enter the data which you want to delete from LinkedList  :   ");        
                   list.deleteNodeByData(sc.nextLine());
              break;
            case 2 : 
                   System.out.print("Enter the position which you want to delete from LinkedList  :   ");
                   list.deleteNodeByPosition(sc.nextInt());
              break;
           
             }
          }
          break;
        case 3 :
          System.out.println("Printing Operation in LinkedList  :   ");
          list.printLinkedList();
          break;
        case 4 :
          System.out.println("Searching Operation in LinkedList  :  ");
          while((choice = menuToSearchNode()) !=0){            
          switch(choice){
            case 1 :
                   System.out.print("Enter the data which you want to Search in  LinkedList  :   ");        
                   list.searchNodeByData(sc.nextLine());
              break;
            case 2 : 
                   System.out.print("Enter the position which you want to Search in  LinkedList  :   ");
                   list.searchNodeByPosition(sc.nextInt());
              break;

             }
          }
      }
    }
  }

}















/*
  public void insertNode(String d ){
    Scanner sc = new Scanner(System.in);
    Node newNode = new Node(d);


    if(head == null){
      head = newNode;
      return;
    }else{
      System.out.print("Where you want to Insert (start -s /end - e/between - b) :   ");
      String insertAt = sc.nextLine();
      Node current = head;
      // at starting 
    if(insertAt == "s"){ 
          newNode.next = current;
          current = newNode;
          return;
        }
      System.out.println(current.data);
        /// at end 


        if(insertAt == "e"){
          while(current != null){
            current = current.next;
          }
          current.next = newNode;
          newNode.next = null;
          return;
        }

        // in between 

        if(insertAt == "b"){

          // Node current = head;
          System.out.print("Enter the position  :  ");
          int pos = sc.nextInt();
          int i = 0;

          for( i = 0; i<pos-1; i++){
            if(i == 0)
            newNode.next = current;
            current = newNode;
            return;
           }
          current.next = newNode;
          newNode.next = current.next;

          if(current == null){
            System.out.println("Invalid Position Entered  : ( ");
          }
          return;
        }
    }

  }
*/

