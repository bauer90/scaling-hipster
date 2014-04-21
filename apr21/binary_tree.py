class BinaryNode:
    left, right, data, parent = None, None, 0, None

    def __init__(self, _data):
        self.left = None
        self.right = None
        self.data = _data
        self.parent = None

class BinaryTree:
    root = None
    size = 0

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
                    if cur.left == None:
                        cur.left = BinaryNode(_data)
                        cur.left.parent = cur
                        self.size += 1
                        break
                    else:
                        cur = cur.left
                        continue
                else:
                    if cur.right == None:
                        cur.right = BinaryNode(_data)
                        cur.right.parent = cur
                        self.size += 1
                        break
                    else:
                        cur = cur.right
                        continue
        return

