import random as rand
import sys

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

    def suc_node(self, tree):
        if self.right is not None:
            return self.right.min_val()
        elif tree.tree_max_val() == self.data:
            return self.data
        else:
            cur = self
            par = self.parent
            while (par is not cur) and (par.right is cur):
                cur = cur.parent
                par = cur.parent
            return par.data

    def pre_node(self, tree): #symmetric with suc_node()
        if self.left is not None:
            return self.left.max_val()
        elif tree.tree_min_val() == self.data:
            return self.data
        else:
            cur = self
            par = self.parent
            while (par is not cur) and (par.left is cur):
                cur = cur.parent
                par = cur.parentn
            return par.data

    def max_val(self):
        if self is None:
            return - sys.maxint - 1
        else:
            cur = self
            while cur.right is not None:
                cur = cur.right
            return cur.data

    def min_val(self):
        if self is None:
            return sys.maxint
        else:
            cur = self
            while cur.left is not None:
                cur = cur.left
            return cur.data


class BinaryTree:
    def __init__(self):
        self.root = None
        self.size = 0

    def is_empty(self):
        return self.size == 0

    def insert(self, _data):
        if self.val_exist(_data):
            print 'val exists already.'
            return
        elif self.is_empty():
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
                else:
                    if cur.right is None:
                        cur.right = BinaryNode(_data)
                        cur.right.parent = cur
                        self.size += 1
                        break
                    else:
                        cur = cur.right
        return

    def tree_max_val(self):
        return self.root.max_val()

    def tree_min_val(self):
        return self.root.min_val()

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
        rand.seed()
        for i in range(0, _num):
            self.insert(int(rand.random() * 100))
        