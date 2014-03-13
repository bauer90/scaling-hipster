import java.util.Hashtable;public class mar10 {	// ... -> thousand -> hundred -> ten -> one -> null	public static int list_addition_rev(LinkedList src1, LinkedList src2) {		int result = 0;		return result;	}	// -> one -> ten -> hundred - > thousand ...	public static int list_addition(LinkedList src1, LinkedList src2) {		int result = 0, carry = 0, decimal = 1, temp = 0;		Node node_tmp1 = src1.first;		Node node_tmp2 = src2.first;		while ( !(node_tmp1 == null && node_tmp2 == null) ) {			temp = decimal * (carry 								+ (node_tmp1 == null ? 0 : node_tmp1.data)								+ (node_tmp2 == null ? 0 : node_tmp2.data));			result = temp / 10;			carry = temp % 10;			if (node_tmp1 != null) {				node_tmp1 = node_tmp1.next;			}			if (node_tmp2 != null) {				node_tmp2 = node_tmp2.next;			}			decimal *= 10;		}		return result;	}	// cat src2 after src1 -	public static LinkedList list_cat(LinkedList src1, LinkedList src2) {		if (src2.is_empty()) {			return src1;		} else if (src1.is_empty()) {			return src2;		} else {			Node node_tmp = src1.first;			while (node_tmp.next != null) {				node_tmp = node_tmp.next;			}			node_tmp.next = src2.first;			src2.first.pre = node_tmp;		}		return src1;	}	// linkedlist partition	public static LinkedList list_partition(LinkedList lst, int num) {		if (lst.is_empty()) {			System.out.print("list_partition() called on an empty list.\n");			return null;		}		Node node_tmp = lst.first;		LinkedList before_list = new LinkedList();		LinkedList after_list = new LinkedList();		// copy all nodes < num into [before_list]		// and all nodes >= num into [after_list]		while (node_tmp != null) {			if (node_tmp.data < num) {				before_list.add_to_tail(node_tmp.data);			} else {				after_list.add_to_tail(node_tmp.data);			}			node_tmp = node_tmp.next;		}		return list_cat(before_list, after_list);	}	// delete [node] on a singly-linked lst 	public static int delete_node(LinkedList lst, Node node) {		if (lst.is_empty()) {			System.out.print("delete_node() called on an empty L-list.\n");			return -1;		}		// copy next node's data to this one -		node.data = node.next.data;		// point this next to next's next -		node.next = node.next.next;		node.next.pre = node;		return 0;	}	// k = 1 will return the last element.	public static int k_th_last(LinkedList src, int k) {		if (src.is_empty() || k < 1) {			System.out.println("k_th_last() called on an empty L-list or invalid k.");			return -1;		}		Node leading = src.first; 		Node following = src.first;		// set the position for the leading pointer -		for (int i = 0; i < k - 1; i++) {			leading = leading.next;			if (leading == null) {				System.out.println("k_th_last(): k out of index.");				return -1;			}		}		// two pointers move together until leading hits the tail -		while (leading.next != null) {			following = following.next;			leading = leading.next;		}		return following.data;	}	// removes duplicates in a linkedlist 'src' (unsorted).	// returns 0 on success; otherwise -1.	public static int remove_dup_1(LinkedList src) {		if (src.is_empty()) {			System.out.println("Error: attempting to call remove_dup on an empty L-list.");			return -1;		}		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();		Node ptr = src.first;		while (ptr != null) {			if (table.containsKey(ptr.data)) {				if (ptr.next == null) {					src.delete_from_tail();					return 0;				} else {					ptr.next.pre = ptr.pre;					ptr.pre.next = ptr.next;					ptr = ptr.next;				}			} else {				table.put(ptr.data, true);				ptr = ptr.next;			}		}		return 0;	} 		// not using buffer otherwise same as above.	public static int remove_dup_2(LinkedList src) {		if (src.is_empty()) {			System.out.println("Error: attempting to call remove_dup on an empty L-list.");			return -1;		}		Node ptr1 = src.first, ptr2 = null;		// for each entry, search to see any dup and remove -		while (ptr1.next != null) {			ptr2 = ptr1.next;			while (ptr2 != null) {				if (ptr2.data == ptr1.data) {					if (ptr2.next == null) {						src.delete_from_tail();						break;					} else {						ptr2.next.pre = ptr2.pre;						ptr2.pre.next = ptr2.next;						ptr2 = ptr2.next;					}				} else {					ptr2 = ptr2.next;				}			}			ptr1 = ptr1.next;		}		return 0;	}		public static void main(String[] args) {		// TODO Auto-generated method stub		LinkedList lst1 = new LinkedList();		LinkedList lst2 = new LinkedList();		for (int i = 0; i < 3; i++) {			lst1.add_to_tail(i);		}		for (int j = 3; j < 6; j++) {			lst2.add_to_tail(j);		}		System.out.println(list_addition(lst1,lst2));	}	}