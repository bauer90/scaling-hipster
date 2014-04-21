class BinaryNode:
	left, right, data = None, None, 0

	def __init__(self, _data):
		self.left = None
		self.right = None
		self.data = _data

class BinaryTree:
	root = None

	def __init__(self):
		self.root = None

	def is_empty(self):
		return self.root == None

	def insert(self, _node, _data):
		if self.is_empty():
			self.root = BinaryNode(self.root, _data);
		else:
			if _data <= root.data:
				self.insert(_node.left, _data)
			else:
				self.insert(_node.right, _data)
		return

