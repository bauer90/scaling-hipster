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
        s = 'data = ' + str(self.data) + ' | parent = ' + str(self.parent.data)
        if self.left is not None:
            s += ' | left = ' + str(self.left.data)
        else:
            s += ' | no left child '
        if self.right is not None:
            s += ' | right = ' + str(self.right.data)
        else:
            s += ' | no right child '
        print s

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

    # will be called as a utility function in 
    # BinaryTree class. val_exist() inspection 
    # will be done there.
    def insert_recur(self, _val):
        if (_val <= self.data) and (self.left is None):
            self.left = BinaryNode(_val)
            self.left.parent = self
        elif (_val > self.data) and (self.right is None):
            self.right = BinaryNode(_val)
            self.right.parent = self
        elif (_val <= self.data) and (self.left is not None):
            self.left.insert_recur(_val)
        else: # -> (_val > self.data) and (self.right is not None)
            self.right.insert_recur(_val)

    def delete_node(self):
        pass


class BinaryTree:
    def __init__(self):
        self.root = None

    def is_empty(self):
        return self.root is None

    def insert(self, _data):
        if self.val_exist(_data):
            print 'val exists already.'
            return
        elif self.is_empty():
            self.root = BinaryNode(_data)
            self.root.parent = self.root
        else:
            cur = self.root
            while 1:
                if _data < cur.data:
                    if cur.left is None:
                        cur.left = BinaryNode(_data)
                        cur.left.parent = cur
                        break
                    else:
                        cur = cur.left
                else:
                    if cur.right is None:
                        cur.right = BinaryNode(_data)
                        cur.right.parent = cur
                        break
                    else:
                        cur = cur.right
        return

<<<<<<< HEAD
    def delete(self, _node):
        pass


        
=======
    def insert_recursive(self, _data):
        if self.val_exist(_data):
            print 'val exists already'
            return
        elif self.is_empty():
            self.root = BinaryNode(_data)
            self.root.parent = self.root
        else:
            self.root.insert_recur(_data)

    def tree_max_val(self):
        return self.root.max_val()

    def tree_min_val(self):
        return self.root.min_val()
>>>>>>> FETCH_HEAD

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
                break
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
            self.insert_recursive(int(rand.random() * 100))
        