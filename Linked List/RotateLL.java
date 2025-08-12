


class  RotateLL{
    class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
    public Node rotate(Node head, int k) {
        
        int len = listLength(head);
        k = k%len;
        if(k==0){
            return head;
        }
        Node temp = head,h1 = head;
        while(k>1){
            temp = temp.next;
            k--;
        }
        Node h2 = temp.next;
        temp.next = null;
        Node nh1 = rotatePart(h1);
        Node nh2 = rotatePart(h2);
        
        head.next = nh2;
        Node res = rotatePart(nh1);
        return res;
        
    }
    
    //Calculating length of the linked list
    public static int listLength(Node head){
        int count = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    //Rotating Part of a linked list
    public static Node rotatePart(Node head){
        Node p=null,c=head;
        while(c!=null){
            Node n = c.next;
            c.next = p;
            p=c;
            c=n;
        }
        return p;
    }
}