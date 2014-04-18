
"""
  Use slope-and-y-intercept method to represent
line segments, so that all line segments belonging
to the same straight line will have the same and unique
representation. 

  First, iterate through every segments (pair of points), 
and along the way, count the number of occurances for 
each unique representation. In the end, the representation 
that has the  greatest number of occurances shall be the
"most common line".
"""

class point_2d:
    def __init__(self, _x, _y):
        self.x = _x
        self.y = _y
    
def gen_points(num):
    result = []
    for i in range(0, num):
        for j in range(0, i):
            result.append(point_2d(i, j))
    return result

def print_points(pts):
    for p in pts:
        print p.x, p.y

class line_2d:
    def __init__(self, _slope, _y_inter):
        self.slope = _slope
        self.y_inter = _y_inter

# transforms two points {p1,p2} to a straight line
# represented by the slope-and-y-intercept method.
def to_line_2d(p1, p2):
    slope = (p1.y - p2.y) * 1.0 / (p1.x - p2.x)
    y_int = (p2.y - (p2.x * 1.0 / p1.x) * p1.y) / (1 - (p2.x * 1.0 / p1.x))
    return line_2d(slope, y_int)

def most_common_key(dict_src):
    keys = dict_src.keys()
    num_occur = 0
    for key in keys:
        if (dict_src[key] > num_occur):
            num_occur = dict_src[key]
    for key in keys:
        if (dict_src[key] == num_occur):
            return key

# given a list of point_2d's 
# returns the line that gretest number of points
# going through.
def most_common_line(points):
    pts = set(points)
    num_pts = len(pts) # num of points
    if num_pts == 0:
        return line_2d(0,0)
    elif num_pts == 1:
        return to_line_2d(pts[0], point_2d(0, 0))
    line_dict = dict()
    # iterate thru every pair of points
    for first_pt in range(0, num_pts):
        for second_pt in range(first_pt + 1, num_pts):
            line = to_line_2d(point_2d(first_pt, second_pt))
            if line in line_dict.keys():
                line_dict.update({line: 0})
            else:
                line_dict.update({line: line_dict[line] + 1})
    return most_common_key(line_dict)

