import random as rd

class BinaryNode:
    left, right, data, parent = None, None, 0, None

    def __init__(self, _data):
        self.left = None
        self.right = None
        self.data = _data
        self.parent = None

    def is_leaf(self):
        return (self.left is None) and (self.right is None)

    def print_info(self):
        print 'data =', self.data, 'parent = ', self.parent.data

class BinaryTree:
    def __init__(self):
        self.root = None
        self.size = 0

    def is_empty(self):
        return self.size == 0

    def insert(self, _data):
        if self.is_empty():
            self.root = BinaryNode(_data)
            self.root.parent = self.root
            self.size += 1
        else:
            cur = self.root
            while 1:
                if _data < cur.data:
                    if cur.left is None:
                        cur.left = BinaryNode(_data)
                        cur.left.parent = cur
                        self.size += 1
                        break
                    else:
                        cur = cur.left
                        continue
                else:
                    if cur.right is None:
                        cur.right = BinaryNode(_data)
                        cur.right.parent = cur
                        self.size += 1
                        break
                    else:
                        cur = cur.right
                        continue
        return

    def val_exist(self, _val):
        if self.is_empty():
            return False
        cur = self.root
        while 1:
            if cur.data == _val:
                return True
            elif (cur.left is not None) and (_val < cur.data):
                cur = cur.left
            elif (cur.right is not None) and (_val > cur.data):
                cur = cur.right
            else:
                return False
        return False

    def print_all_nodes(self, _root):
        if _root is None:
            pass
        elif _root.is_leaf():
            _root.print_info()
        else:
            self.print_all_nodes(_root.left)
            _root.print_info()
            self.print_all_nodes(_root.right)

    def print_tree(self):
        self.print_all_nodes(self.root)

    def insert_randoms(self, _num):
        rd.seed()
        for i in range(0, _num):
            self.insert(int(rd.random() * 100))
        