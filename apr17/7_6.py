
"""
Use slope-and-y-intercept method to represent
line segments, so that all line segments belonging
to the same straight line will have the same and unique
representation. 

First, iterate through every two segments, and along
the way, count the number of occurances for each unique
representation. In the end, the representation that has
the  greatest number of occurances shall be the
"most common line".
"""

class point_2d:
    def __init__(self, _x, _y):
        self.x = _x
        self.y = _y

class line_2d:
    def __init__(self, _slope, _y_inter):
        self.slope = _slope
        self.y_inter = _y_inter


# given a set of points (of class line_2d)
# returns the line that gretest number of points
# going through.
def most_common_line(points):
