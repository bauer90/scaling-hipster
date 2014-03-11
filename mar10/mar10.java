package mar10;
import java.util.Hashtable;


public class mar10 {
	// removes duplicates in a linkedlist 'src' (unsorted).
	// returns 0 on success; otherwise -1.
	public static int remove_dup_1(LinkedList src) {
		if (src.is_empty()) {
			System.out.println("Error: attempting to call remove_dup on an empty L-list.");
			return -1;
		}
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node ptr = src.first;
		while (ptr != null) {
			if (table.containsKey(ptr.data)) {
				if (ptr.next == null) {
					src.delete_from_tail();
					return 0;
				} else {
					ptr.next.pre = ptr.pre;
					ptr.pre.next = ptr.next;
					ptr = ptr.next;
				}
			} else {
				table.put(ptr.data, true);
				ptr = ptr.next;
			}
		}
		return 0;
	} 
	
	// not using buffer otherwise same as above.
	public static int remove_dup_2(LinkedList src) {
		if (src.is_empty()) {
			System.out.println("Error: attempting to call remove_dup on an empty L-list.");
			return -1;
		}
		Node ptr1 = src.first, ptr2 = null;
		// for each entry, search to see any dup and remove -
		while (ptr1.next != null) {
			ptr2 = ptr1.next;
			while (ptr2 != null) {
				if (ptr2.data == ptr1.data) {
					if (ptr2.next == null) {
						src.delete_from_tail();
						break;
					} else {
						ptr2.next.pre = ptr2.pre;
						ptr2.pre.next = ptr2.next;
						ptr2 = ptr2.next;
					}
				} else {
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList lst = new LinkedList(3);
		lst.add_to_tail(4);
		lst.add_to_tail(3);
		for (int i = 0; i < 20; i++) {
			lst.add_to_tail(i*72 % 34);
		}
		System.out.println(lst.toString());
		remove_dup_1(lst);
		System.out.println(lst.toString());

	}

}
