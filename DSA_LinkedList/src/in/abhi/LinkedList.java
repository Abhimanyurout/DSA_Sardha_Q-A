package in.abhi;

public class LinkedList {
		public static class Node{
			int data;
			Node next;
			
			public Node(int data) {
				this.data=data;
				this.next=null;
			}
		}
		public static Node head;
		public static Node tail;
		public static int size;
		
		public void addFirst(int data) {
			//first step:Create new node
			
			Node newNode=new Node(data);
			size++;
			if(head==null) {
				head=tail=newNode;
				return;
			}
//			step-2:newNode next=head
			newNode.next=head;
			//step3:head=newNode
			head=newNode;
			
		}
		
		public void addLast(int data) {
			Node newNode=new Node(data);
			size++;
			if(head==null) {
				head=tail=newNode;
			}
			tail.next=newNode;
			tail=newNode;
			
		}
		
		public void print() {
			if(head==null) {
				System.out.println("LL is empty");
				return;
			}
			
			Node temp=head;
			while(temp !=null) {//TC=O(n)
				System.out.print(temp.data+" -> ");
				temp=temp.next;
			}
			System.out.println("null");
		}
		
		public void add(int idx,int data) {//TC=O(n)
			if(idx==0) {
				addFirst(data);
				return;
			}
			
			Node newNode=new Node(data);
			size++;
			Node temp=head;
			int i=0;
			
			while(i<idx-1) {
				temp=temp.next;
				i++;
			}
			newNode.next=temp.next;
			temp.next=newNode;
			
		}
		
		public int removeFirst() {
			if(size==0) {
				System.out.println("LL is empty");
				return Integer.MIN_VALUE;
			}else if(size==1){
				int val=head.data;
				head=tail=null;
				size=0;
				return val;
			}
			int val=head.data;
			head=head.next;
			size--;
			return val;
		}
		public int removeLast() {
			if(size==0) {
				System.out.println("LL is empty");
				return Integer.MIN_VALUE;
			}else if(size==1) {
				int val=head.data;
				head=tail=null;
				size=0;
				return val;
				
			}
			//prev : i=size-2
			Node prev=head;
			for(int i=0;i<size-2;i++) {
				prev=prev.next;
			}
			int val=prev.next.data;
			prev.next=null;
			tail=prev;
			size--;
			return val;
		}
		
		//iterative Search
		public int itrSearch(int key) {//TC= O(n)
			Node temp=head;
			int i=0;
			while(temp != null) {
				if(temp.data==key) {
					return i;
				}else {
					temp = temp.next;
					i++;
				}
			}
			return -1;
		}
		//Recursive Search
		public int helper(Node head,int key) {//TC= O(n)
			if(head==null) {
				return -1;
			}
			if(head.data==key) {
				return 0;
			}
			int idx = helper(head.next, key);
			if(idx==-1) {
				return -1;
			}
			return idx+1;
		}
		
		public int recSearch(int key) {
			return helper(head,key);
		}
		
		//reverse Node
		public void reverse() {
			Node prev=null;
			Node curr=tail=head;
			Node next;
			
			while(curr !=null) {
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			head=prev;
		}
		
		//find and remove Nth node form end
		
		public void deleteNthformNode(int n) {
			//calculated size
			int sz=0;
			Node temp=head;
			if(temp != null) {
				temp=temp.next;
				sz++;
			}
			if(n==sz) {
				head=head.next;
				return;
			}
			//sz-n
			int i=1;
			int iToFind=sz-n;
			Node prev=head;
			while(i<iToFind) {
				prev=prev.next;
				i++;
			}
			prev.next=prev.next.next;
			return;
		}
		//Find middle of the node
		//Slow-fast Approach
		public Node findMid(Node head) {
			Node slow=head;
			Node fast=head;
			while(fast !=null && fast.next !=null) {
				slow=slow.next;//+1
				fast=fast.next.next;//+2
			}
			return slow;//this the mid of ll
		}
		
		public boolean checkPalindrome() {
			if(head==null || head.next ==null) {
				return true;
			}
			//step:1-find mid
			Node midNode=findMid(head);
			
			//step:2-2nd half reverse
			Node prev=null;
			Node curr=midNode;
			Node next;
			while(curr !=null) {
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			Node right=prev;
			Node left=head;
			
			//step:3- check 1st and 2nd half
			
			while(right !=null) {
				if(left.data !=right.data) {
					return false;
				}
				left=left.next;
				right=right.next;
			}
			return true;
		}
		
		
		//cycle is exits or not in a ll
		public static boolean isCycle() {
			Node slow=head;
			Node fast=head;
			
			while(fast !=null && fast.next !=null) {
				slow=slow.next;
				fast=fast.next.next;
				if(slow==fast) {
					return true;
				}
			}
			return false;
		}
		
		//Detect cycle
		public static void removeCycle() {
			//detect cycle
			Node slow=head;
			Node fast=head;
			boolean cycle=false;
			
			while(fast !=null && fast.next !=null) {
				slow=slow.next;
				fast=fast.next.next;
				if(fast==slow) {
					cycle=true;
					break;
				}
			}
			if(cycle==false) {
				return;
			}
			
			//find meet point			
			slow=head;
			Node prev=null;
			while(slow !=fast) {
				prev=fast;
				slow=slow.next;
				fast=fast.next;
			}
			
			//remove Cycle -> last.next=null
			prev.next=null;
		}
		
		//mergesort
		private Node getMid(Node head) {
			
			Node slow=head;
			Node fast=head.next;
			
			while(fast !=null && fast.next !=null) {
				slow=slow.next;
				fast=fast.next.next;
			}
			return slow;			
		}
		
		private Node merge(Node head1,Node head2) {
			Node mergeLL=new Node(-1);
			Node temp=mergeLL;
			
			while(head1 !=null && head2 !=null) {
				if(head1.data<=head2.data) {
					temp.next=head1;
					head1=head1.next;
					temp=temp.next;
				}else {
					temp.next=head2;
					head2=head2.next;
					temp=temp.next;
				}
			}

			while(head1 !=null) {
				temp.next=head1;
				head1=head1.next;
				temp=temp.next;
			}
			while(head2 !=null) {
				temp.next=head2;
				head2=head2.next;
				temp=temp.next;
			}
			return mergeLL.next;
			
		}
		
		public Node mergeSort(Node head) {
			if(head==null || head.next==null) {
				return head;
			}
			
			//find mid
			Node mid=getMid(head);
			//left & right Ms
			Node rightHead=mid.next;
			mid.next=null;
			
			Node newLeft=mergeSort(head);
			Node newRight=mergeSort(rightHead);
			
			//merge
			return merge(newLeft,newRight);
			
		}
		
		public void zigZag() {
			//find mid
			Node slow=head;
			Node fast=head.next;
			
			while(fast !=null && fast.next !=null) {
				slow=slow.next;
				fast=fast.next.next;
			}
			Node mid=slow;
			
			//reverse 2nd half
			Node curr=mid.next;
			mid.next=null;
			Node prev=null;
			Node next;
			
			
			
			
		}
		
		public static void main(String[] args) {
			LinkedList ll=new LinkedList();
			ll.addFirst(2);
			ll.addFirst(1);
			ll.addLast(3);
			ll.addLast(4);
		// Add in middle idx	
//			ll.add(2, 9);
//			ll.add(0, 5);
			
//			ll.print();
//			ll.removeFirst();
//			ll.print();
//			System.out.println("size :"+size);
////			ll.removeLast();
////			ll.print();
////			System.out.println(ll.size);
////			System.out.println(ll.recSearch(3));
////			System.out.println(ll.recSearch(31));
//			ll.reverse();
//			ll.print();
////			ll.deleteNthformNode(3);
//			ll.print();
//			System.out.println(ll.checkPalindrome());
			
			//Cycle ll
			
//			head=new Node(1);
//			Node temp=new Node(2);
//			head.next=temp;
//			head.next.next=new Node(3);
//			head.next.next.next=temp;
//			
//			System.out.println(isCycle());
//			removeCycle();
//			System.out.println(isCycle());
//			
//			ll.addFirst(1);
//			ll.addFirst(2);
//			ll.addFirst(3);
//			ll.addFirst(4);
//			ll.addFirst(5);
//			
//			ll.print();
//			ll.head=ll.mergeSort(ll.head);
//			ll.print();
			ll.print();
			ll.deleteNthformNode(2);
			ll.print();
			
			

			
	}

}
