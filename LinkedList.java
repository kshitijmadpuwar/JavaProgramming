public class LinkedList {
    public static class Node{
      int data;
      Node next;

      public Node(int data){
         this.data=data;
         this.next=null;

      }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        // step01-> create new node
        Node newNode=new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        //step02-> newNode next= head
        newNode.next=head; //Link

        //step03-> head=newNode
        head=newNode;
    }

    //To add in last
    public void addlast(int data){
       
       
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next=newNode;

        tail =  newNode;
    }

    // To first the linkedList
    public void printLL(){
        Node tep = head;
        while(tep != null){
          
            System.out.print(tep.data+ "->");
            tep = tep.next;
        }
        System.out.println("Null");

    }

    public void addMiddle(int idx, int data){
       if(idx == 0){
        addFirst(data);
        return;
       }
        Node newNode = new Node(data);
        size++;
        Node tep = head;
        int i=0;

        while (i < idx-1) { 
            tep=tep.next;
            i++;
        }
         newNode.next = tep.next;
         tep.next = newNode;
    }

    public int removeFirst(){
        if(size ==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val=head.data;
        head = head.next;
        size--;
        return val;
    }

     public int removeLast(){
        if(size ==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i=size-2
        Node prev = head;
        for(int i=0; i< size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
     }
    
     /* Search for key in given arraylist if it found give position of key otherwise
     return -1.(if key is not find)  
      */
      public int itrSearch(int key){
        Node tep = head;
        int i=0;
         while(tep != null){
          if(tep.data == key){
            return i;
          }
            tep = tep.next;
            i++;
          
         }

         return -1;
      }
    
    public static void main(String args[]){
        LinkedList ll= new LinkedList();
        ll.printLL();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addlast(3);
        ll.addlast(4);
        ll.addMiddle(4, 5);
        ll.printLL();

        System.out.println(size);
        System.out.println(ll.removeFirst());
        ll.printLL();

        ll.removeLast();
        ll.printLL();
        System.out.println(size);//2->3->4->Null
        System.out.println(ll.itrSearch(3));


        
        

        


    }
}
