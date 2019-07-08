package com.bridjit.learning.learning;

public class Node {

	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void add(Node node) {
		if (value > node.value) {
			this.addLeft(node);
		} else if (value < node.value) { // avoid = case we skip adding the same node twice
			this.addRight(node);
		}
	}

	private void addLeft(Node n) {
		if (this.left == null) {
			this.left = n;
		} else {
			Node addLeft = this.left;
			while (addLeft.left != null && addLeft.value > n.value) {
				addLeft = addLeft.left;
			}
			addLeft.add(n);
		}
	}

	private void addRight(Node n) {
		if (this.right == null) {
			this.right = n;
		} else {
			Node addRight = this.right;
			while (addRight.right != null && addRight.value < n.value) {
				addRight = addRight.right;
			}
			addRight.add(n);
			this.right.add(n);
		}
	}

	/**
	 * using iterative to avoid stackoverflow exception due to large recursive calls
	 * on the jvm heap for bug nodes that go beyond 100_000
	 */
	public Node find(int i) {
		if (value == i) {
			return this;
		} 

		// left search
		if (value > i) {
			Node searchLeft = this;
			while (searchLeft.left != null && searchLeft.value > i) { // go left
				searchLeft = searchLeft.left;
			}
			// check if we stop in the good value
			if(searchLeft.value == i) return searchLeft;
			// or turn to other side of node using recursion
			if (searchLeft.right != null) {
				if (searchLeft.right.value >= i) {
					return searchLeft.right.find(i);
				}
			}
			// stop if searching in the other side is not possible
			return null;
		} 

		// right search
		if (value < i) {
			Node searchRight = this;
			while (searchRight.right != null && searchRight.value < i) { // go right
				searchRight = searchRight.right;
			}
			//check if we stop in the good value
			if(searchRight.value == i) return searchRight;
			
			// turn other side using recursion if possible
			if (searchRight.left != null) { // is there a turn ??
				if (searchRight.left.value <= i) { // should I turn ???
					return searchRight.left.find(i);
				}
			}
			// dont go further there no hope
			return null;
		}
		return null;
	}
}
