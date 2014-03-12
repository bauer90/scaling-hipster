
// a dual-direction linked list
public class LinkedList {
	public Node first;
	
	// no-arg constructor
	public LinkedList() {
		first = null;
	}
	
	public LinkedList(int dat) {
		first = new Node(dat);
	}
	
	public boolean is_empty() {
		return (first == null);
	}
	
	// add dat to the end of L-list
	public int add_to_tail(int dat) {
		if (is_empty()) {
			first = new Node(dat);
			return 0;
		}
		Node ptr = first;
		while (ptr.next != null) {
			ptr = ptr.next;
		}
		Node new_node = new Node(dat);
		ptr.next = new_node;
		ptr.next.pre = ptr;
		return 0;
	}
	
	// add dat to the beginning of L-list
	public int add_to_head(int dat) {
		Node new_node = new Node(dat);
		new_node.next = first;
		new_node.pre = null;
		first = new_node;
		return 0;
	}
	
	// remove the last entry
	public int delete_from_tail() {
		if (is_empty()) {
			System.out.println("Error: attempting to do delete_from_tail() on an empty Linked List.");
			return -1;
		} else if (length() == 1) {
			first = null;
			return 0;
		} else {
			Node ptr = first;
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr = ptr.pre;
			ptr.next = null;
			return 0;
		}
	}
	
	// remove the first entry
	public int delete_from_head() {
		if (is_empty()) {
			System.out.println("Error: attempting to do delete_from_head() on an empty Linked List.");
			return -1;
		}
		first = first.next;
		first.pre = null;
		return 0;
	}
	
	public String toString() {
		if (length() == 0) {
			System.out.println("Empty Linked List.");
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Node ptr = first;
		while (ptr != null) {
			sb.append(Integer.toString(ptr.data) + " ");
			ptr = ptr.next;
		}
		return sb.toString();
	}
	
	public int length() {
		int result = 0;
		Node ptr = first;
		while (ptr != null) {
			result++;
			ptr = ptr.next;
		}
		return result;
	}
	
}
