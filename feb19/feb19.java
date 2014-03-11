package feb19;
import java.util.*;

public class feb19 {

	// returns 'true' iff src1 is a substring of src2
	public static boolean is_substring(char[] src1, int length1, char[] src2, int length2) {
		if (length1 > length2) {
			return false;
		} 
		A:
		for (int i = 0; i < length2 - length1 + 1; i++) {
			for (int j = 0; j < length1; j++) {
				if (src1[j] != src2[j+i]) {
					continue A;
				} 
			}
			return true;
		}
		return false;
	}

	// 'true' iff src1 is a substring of src2
	public static boolean is_rotation(String src1, String src2) {
		char[] comb = (src1+src1).toCharArray();
		if (src1.length() == src2.length()) {
			return is_substring(src2.toCharArray(), src1.length(), comb, src1.length() * 2 );
		} else {
			return false;	
		}
	}

	public static void zero_row_col(int[][] src, int size1, int size2) {

		// init row & col record -
		boolean[] row_record = new boolean[size1];
		for (int i = 0; i < size1; i++) {
			row_record[i] = false;
		}
		boolean[] col_record = new boolean[size2];
		for (int i = 0; i < size2; i++) {
			col_record[i]= false;
		}

		// if src[i][j] is zero, then store the 
		// info that there is a zero for ith row
		// and jth col -
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; j++) {
				if (src[i][j] == 0) {
					row_record[i] = true;
					col_record[j] = true;
				}
			}
		}

		//modify src based on the records -
		for (int i = 0; i < size1; i++) {
			if (row_record[i] == true) {
				for (int j = 0; j < size2; j++) {
					src[i][j] = 0;
				}			
			}
		}
		for (int j = 0; j < size2; j++) {
			if (col_record[j] == true) {
				for (int i = 0; i < size1; i++) {
					src[i][j] = 0;
				}
			}
		}


	}

	public static void matrix_print(int[][] src, int size1, int size2) {
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; j++) {
				System.out.print(src[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public static void matrix_rotate(int[][] src, int dim) {
		//work outward in - 
		int temp, first, last, offset;
		for (int layer = 0; layer < dim / 2; layer++) {
			first = layer;
			last = dim - layer - 1;
			for (int index = first; index < last; index++) {
				offset = index - first;
				
				//caching the first element -
				temp = src[first][index];
				
				//left to top -
				src[first][index] = src[last - offset][first];
				
				//bottom to left -
				src[last - offset][first] = src[last][last - offset];
				
				//right to bottom - 
				src[last][last - offset] = src[index][last];
				
				//cache to right
				src[index][last] = temp;
			}
		}		
	}
	
	public static int length_after_compress(char[] src, int length) {
		int result = 0, k = 0, same_counter = 0;
		for (int j = 0; j < length; j++) {
			if (src[j] == src[k]) {
				same_counter++;
				if (j == length - 1) {
					if (same_counter > 9) {
						System.out.println("more than 9 same chars together!");
						return 0;
					}
					result += 2;
					return result;
				}
			} else {
				if (same_counter > 9) {
					System.out.println("more than 9 same chars together!");
					return 0;
				}
				result += 2;
				k = j;
				j--;
				same_counter = 0;
			}
		}
		return result;
	}

	public static char int_to_char(int src) {
		switch(src) {
			case 0:
				return '0';
			case 1:
				return '1';
			case 2:
				return '2';
			case 3:
				return '3';
			case 4:
				return '4';
			case 5:
				return '5';
			case 6:
				return '6';
			case 7:
				return '7';
			case 8:
				return '8';
			case 9:
				return '9';
			default:
				return 'e';
		}
	}
	
	public static char[] compress_string(char[] src, int length) {
		int after_length = length_after_compress(src, length);
		if (after_length >= length) {
			System.out.println("after_length >= length");
			return src;
		} else { // an effective compression..
			// pre-alloc a chunk of memory to avoid overhead of multiple string allocation
			char[] result = new char[after_length + 1]; // 1 for '\0'
			int k = 0, same_counter = 0, new_index = 0;
			for (int j = 0; j < length; j++) {
				if (src[j] == src[k]) {
					same_counter++;
					if (j == length - 1) {//j at the last char then finish up and reutrn -
						if (same_counter > 9) {
							System.out.println("more than 9 same chars together!");
							return src;
						} else {
							result[new_index] = src[j];
							result[new_index + 1] = int_to_char(same_counter);
							result[new_index + 2] = '\0';
							return result;
						}
					}
				} else {// j encounters a new char
					if (same_counter > 9) {
						System.out.println("more than 9 same chars together!");
						return src;
					} else if (j == length - 1) {
						result[new_index] = src[k];
						result[new_index + 1] = int_to_char(same_counter);
						result[new_index + 2] = src[j];
						result[new_index + 3] = int_to_char(1);
						result[new_index + 4] = '\0';
						return result;
					} else {
						result[new_index] = src[k];
						result[new_index+1] = int_to_char(same_counter);
						new_index += 2;
						k = j;
						j--;
						same_counter = 0;
					}
				}	
			}
		}
		return "error".toCharArray();	
	}
	public static void addPercent20(char[] src, int length) {
		//see how many spaces are there
		int num_of_spaces = 0;
		int new_index;
		for (int i = 0; i < length - 1; i++) {
			if (src[i] == ' ') {
				num_of_spaces++;
			}
		}
		//start from the end
		new_index = num_of_spaces * 2 + length - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (new_index < 0) {
				System.out.println("impossible");
				return;
			}
			if (src[i] == ' ') {
				new_index -= 3;
				src[new_index+1] = '%';
				src[new_index+2] = '2';
				src[new_index+3] = '0';
			} else {
				src[new_index] = src[i];
				new_index--;
			}
		}
	}
	
	public static boolean arePermutation(String src1, String src2) {
		int len1 = src1.length();
		int len2 = src2.length();
		if (len1 != len2) {
			return false;
		}
		char[] ch1 = src1.toCharArray();
		char[] ch2 = src2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		for (int i = 0; i < len1; i++) {
			if (ch1[i] != ch2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static char[] reverseCharArray(String src) {
		int len = src.length();
		char[] result = src.toCharArray();
		char temp = '\0';
		for (int i = 0; i < len/2; i++) {
			temp = result[i];
			result[i] = result[len-i-1];
			result[len-i-1] = temp;
		}
		return result;
	}
	
	public static boolean isUniqueChars(String src) {
		int len = src.length();
		char chval = '\0';
		if (len > 256) {
			return false;
		}
		boolean[] boolTable = new boolean[256];
		for (int i = 0; i < len; i++) {
			chval = src.charAt(i);
			if (boolTable[chval]) {
				return false;
			} else {
				boolTable[chval] = true;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress_string("aaabbbc".toCharArray(), 7));
		int[][] a = new int[3][4];
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				a[i][j] = i * 3 + j;
			}
		}
		matrix_print(a, 3, 4);
		zero_row_col(a, 3, 4);
		matrix_print(a, 3, 4);
		//System.out.println(is_substring("waterbottlw".toCharArray(), 11 ,"terbottlewaterbottlewa".toCharArray(),22));
		System.out.println(is_rotation("waterbottle", "terbottlewa"));
		
		
	}

}
