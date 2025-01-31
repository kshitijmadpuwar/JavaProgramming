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
    

       /* Search for key in given arraylist if it found give position of key otherwise
     return -1.(if key is not find)___Using Recursion
      */
      public int helper(Node head, int key){
           if(head == null){
            return -1;
           }

           if(head.data == key){
            return 0;
           }

           int idx= helper(head.next, key);
           if(idx == -1){
            return -1;
           }

            return idx+1;
      }

      public int recSearch(int key){
        return helper(head,key);
      }

      public void reverseLl(){//_O(n);

        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
      }

      /*Find and Remove nth number from end. Given linkedlist
        Amazon, Qualcom, Flipkart
      */
      public void removeNthfromend(int n){

        int sz=0;
        Node temp= head;
        while(temp != null){
             temp = temp.next;
             sz++;
        }

        if(n == sz){
            head = head.next;
            return;
        }
        
        //sz - n;
        int i=1;
        int iToFind = sz - n;
        Node prev = head;
        
        while (i < iToFind){
            prev = prev.next;
            i++;
        }
        
        prev.next = prev.next.next;
        return;
      }


      //To  find the Panlindrome 
      // Flow fast approach

      public Node findMiddle(Node head){//IF this code we run for even LL we wll get last second value.
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;//1+;
            fast = fast.next.next;//2+;
        }

        return slow;
      }

      public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        //step01-> to find mid
        Node mid = findMiddle(head);


        //step02->To Reverse half list
        Node curr = mid;
        Node prev = null;
        while(curr != null){

           Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // step03-> To Compare the linkedlist
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
         return true;

      }

      public static boolean isCycle(){//floy's Algorithon to find Cycle

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
              slow = slow.next;
              fast = fast.next.next;

              if(slow == fast){
                return true;
              }

        }
        return false;
      }


// TO remove the Cycle in linkedlist.
      public static void remCycle(){
    // Detect the cycle
        Node slow = head;
        Node fast = head;
        boolean Cycle = false;

        while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
          if(slow == fast ){
            Cycle = true;
            break;
          }

        }
        if(Cycle == false){
          return;
        }

        //find  meeting point cycle
        slow = head;
        Node prev = null;

        while(slow != fast){
          prev = fast;
          slow = slow.next;
          fast = fast.next;
        }
       // Remove Cycle
        prev.next= null;
      }


      // THis code gives you mid value of even Linkedlist "Second node"
      private Node getmid(Node head){
         Node slow = head;
         Node fast = head.next;//to get Second node value
         while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
         }
         return slow; //mid Node
      }

      private Node merge(Node head1, Node head2){
        Node mergedll = new Node(-1);
        Node temp =mergedll;
        while(head1 != null && head2 != null){
          if(head1.data <= head2.data){
            temp.next = head1;
            head1 = head1.next;
            temp=temp.next;
          }else{
            temp.next = head2;
            head2 = head2.next;
            temp=temp.next;
          }
        }

        while(head1 != null){
          temp.next = head1;
          head1=head1.next;
          temp = temp.next;
        }  
        while(head2 != null){
          temp.next = head2;
          head2=head2.next;
          temp = temp.next;
        }

        return mergedll.next;
      }

      public Node mergeSort(Node head){
       if(head == null || head.next == null){
        return head;
       }
        // Find the mid
        Node mid= getmid(head);

        //Divide LinkedList -> left half & right half
         Node rightHead = mid.next;
         mid.next = null;
         Node newleft = mergeSort(head);
         Node newright = mergeSort(rightHead);


        //Merge Linkedlist
        return merge(newleft, newright);

      }
    // Print the linkedlist in zigzag fasion
      public void zigZagLL(){
        //Find the mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;//mid value

        // Reverse second half linkelist
           Node curr = mid.next;
           mid.next = null;
           Node prev = null;
           Node next;

           while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
           }
         
           Node left = head;
           Node right = prev;
           Node nextL , nextR;

        // merge or joint linkedlist in zigzag manner
        while(left != null && right != null){
          nextL = left.next;
          left.next = right;
          nextR = right.next;
          right.next = nextL;

          left = nextL;
          right = nextR;

        }


      }

      //Find the insertion point of two linkedlist
     // Brute-force approach to find the intersection point of two linked lists
    public Node getIntersectionNode(Node head1, Node head2) {
    
      while (head2 != null) {
          Node temp = head1;

          // Compare head2 with all nodes of head1
          while (temp != null) {
              if (temp == head2) { 
                  return head2;
              }
              temp = temp.next; // Move to the next node in head1
          }
          head2 = head2.next; // Move to the next node in head2
      }

      return null; // If no intersection is found, return null
  }

    public static void main(String args[]){
        LinkedList ll= new LinkedList();
        Node head1, head2;
        // Creating first linked list
        head1 = new Node(10);
        Node newNode = new Node(15);
        head1.next = newNode;
        newNode = new Node(30);
        head1.next.next = newNode;
        head1.next.next.next = null;

        // Creating second linked list
        head2 = new Node(3);
        newNode = new Node(6);
        head2.next = newNode;
        newNode = new Node(9);
        head2.next.next = newNode;
        head2.next.next.next = head1.next; // Intersection at Node with value 15

        Node intersectionPoint = ll.getIntersectionNode(head1, head2);
        if (intersectionPoint == null) {
            System.out.println("No Intersection Point");
        } else {
            System.out.println("Intersection Point: " + intersectionPoint.data);
        }

    }
}
