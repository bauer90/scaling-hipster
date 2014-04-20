# find the next k to the given list
def next_smallest(lst):
	smallest = lst[len(lst) - 1] * 3 # an intuitive guess
	for dat in lst:
		times_3 = dat * 3
		times_5 = dat * 5
		times_7 = dat * 7
		if (times_3 < smallest) and (not times_3 in lst):
			return times_3
		elif (times_5 < smallest) and (not times_5 in lst):
			return times_5
		elif (times_7 < smallest) and (not times_7 in lst):
			return times_7
		else:
			continue
	return smallest

# pre-mature way of finding the kth 
# where the 1st is 1 and 2nd is 3, etc.
# which takes O(n^2) time
def kth_simple(k):
	result_list = [1]
	for i in range(0, k):
		result_list.append(next_smallest(result_list))
	return result_list[k - 1]


# an improved version of 'kth'
def kth_better(k):
	