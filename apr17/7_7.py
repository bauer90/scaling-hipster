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

# remove all occurances of val from lst
def remove_min_from(lst):    
    if (len(lst) <= 0):
        return
    min_val = min(lst)
    while min_val in lst:
        lst.remove(min_val)
    return min_val

def add_mults_to(val, lst):
    lst.append(val * 3)
    lst.append(val * 5)
    lst.append(val * 7)

# pre-mature way of finding the kth 
# where the 1st is 1 and 2nd is 3, etc.
# which takes O(n^2) time
def kth_simple(k):
    if k < 1:
        return 0
    result_list = [1]
    for i in range(0, k):
        result_list.append(next_smallest(result_list))
    return result_list[k - 1]

# an improved version of 'kth'
def kth_better(k):
    if k < 1:
        return 0
    lst = [1]
    for i in range(0, k):
        val = remove_min_from(lst)
        add_mults_to(val, lst)
    return val