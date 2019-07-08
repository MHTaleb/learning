package com.bridjit.learning.learning;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {
	private int value;
	private Node node;
	private Node positivesNode;
	private Node negativesNode;
	
	@Before
	public void init() {
		this.value = 1 ;
		this.node = new Node(value);
		
		this.positivesNode = new Node(0); // 0 5 3 9 11 7 10
		this.positivesNode.add(new Node(5));
		this.positivesNode.add(new Node(3));
		this.positivesNode.add(new Node(9));
		this.positivesNode.add(new Node(11));
		this.positivesNode.add(new Node(7));
		this.positivesNode.add(new Node(10));
		
		this.negativesNode = new Node(0); // 0 -5 -3 -9 -11 -7 -10
		this.negativesNode.add(new Node(-5));
		this.negativesNode.add(new Node(-3));
		this.negativesNode.add(new Node(-9));
		this.negativesNode.add(new Node(-11));
		this.negativesNode.add(new Node(-7));
		this.negativesNode.add(new Node(-10));
		
		
	}
	
	/**
	 * empty node creation test
	 * a node have by default null left and right siblings
	 * */
	@Test
	public void createNode() {
		
		Assert.assertNotNull(node);
		Assert.assertEquals(1, node.getValue());
		Assert.assertNull(node.getLeft());
		Assert.assertNull(node.getRight());
	}
	

	/**
	 * check that a simple add to left node is working
	 * */
	@Test
	public void addNodeLeftLVL1() {
		this.node.add(new Node(-1));
		Assert.assertEquals(-1, this.node.getLeft().getValue(),0);
	}
	
	/**
	 * check that a simple add to right node is working
	 * */
	@Test
	public void addNodeRightLVL1() {
		this.node.add(new Node(2));
		Assert.assertEquals(2, this.node.getRight().getValue(),0);
	}
	
	/**
	 * Test find return null when value not found
	 * */
	public void testFindPositiveNotFound() {
		Assert.assertNull(this.positivesNode.find(4));
	}
	
	public void testFindNegativeNotFound() {
		Assert.assertNull(this.negativesNode.find(-15));
	}
	
	public void testPositiveFound() {
		Assert.assertEquals(9, this.positivesNode.find(9).getValue(),0);
	}
	
	public void testNegativeFound() {
		Assert.assertEquals(-5, this.positivesNode.find(-5).getValue(),0);
	}
	
	
	/**
	 * positivesNode
	 * 
	 * check that the adding of the following value gives the right schema
	 * parent = 0
	 * adding = 5 3 9 11 7 10
	 * 
	 * check that 3 is the left of 5   V1
	 * check that 9 is the right of 5  V2
	 * check that 11 is the right of 9 V3
	 * check that 7 is the left of 9   V4
	 * check that 10 is the left of 11 V5
	 * check that 11 have no right     V6
	 * */
	
	
	@Test
	public void checkAddingPositivesV1(){
		Assert.assertEquals(this.positivesNode.find(5).getLeft().getValue(),3,0);
	}
	
	@Test
	public void checkAddingPositivesV2(){
		Assert.assertEquals(this.positivesNode.find(5).getRight().getValue(),9,0);
	}
	
	@Test
	public void checkAddingPositivesV3(){
		Assert.assertEquals(this.positivesNode.find(9).getRight().getValue(),11,0);
	}
	
	@Test
	public void checkAddingPositivesV4(){
		Assert.assertEquals(this.positivesNode.find(9).getLeft().getValue(),7,0);
	}
	
	@Test
	public void checkAddingPositivesV5(){
		Assert.assertEquals(this.positivesNode.find(11).getLeft().getValue(),10,0);
	}
	
	@Test
	public void checkAddingPositiveV6() {
		Assert.assertNull(this.positivesNode.find(11).getRight());
	}
	
	

	/**
	 * negativesNode
	 * 
	 * check that the adding of the following value gives the right schema
	 * parent = 0
	 * adding = -5 -3 -9 -11 -7 -10
	 * 
	 * check that -3 is the right of -5   V1
	 * check that -9 is the left of -5  V2
	 * check that -11 is the left of -9 V3
	 * check that -7 is the right of -9   V4
	 * check that -10 is the right of -11 V5
	 * check that -11 have no left     V6
	 * */
	
	
	@Test
	public void checkAddingNegativesV1(){
		Assert.assertEquals(this.negativesNode.find(-5).getRight().getValue(),-3,0);
	}
	
	@Test
	public void checkAddingNegativesV2(){
		Assert.assertEquals(this.negativesNode.find(-5).getLeft().getValue(),-9,0);
	}
	
	@Test
	public void checkAddingNegativesV3(){
		Assert.assertEquals(this.negativesNode.find(-9).getLeft().getValue(),-11,0);
	}
	
	@Test
	public void checkAddingNegativesV4(){
		Assert.assertEquals(this.negativesNode.find(-9).getRight().getValue(),-7,0);
	}
	
	@Test
	public void checkAddingNegativesV5(){
		Assert.assertEquals(this.negativesNode.find(-11).getRight().getValue(),-10,0);
	}
	
	@Test
	public void checkAddingNegativesV6() {
		Assert.assertNull(this.negativesNode.find(-11).getLeft());
	}
	
	/**
	 * the small exercise test case
	 * */
	@Test
	public void testSmall() {
		final Node small = new  Node(9);
		IntStream.of(7,5,8,2,6,13,17,16).forEach(v -> small.add(new Node(v)));

		Assert.assertEquals(small.find(9).getValue(), small.getValue());
		Assert.assertEquals(small.find(8).getValue(), 8);
		
		Assert.assertNull(small.find(8).getLeft());
		Assert.assertNull(small.find(8).getRight());

		Assert.assertNull(small.find(16).getLeft());
		Assert.assertNull(small.find(16).getRight());

		Assert.assertEquals(small.find(17).getLeft().getValue(), 16);
		
		Assert.assertEquals(small.find(5).getLeft().getValue(), 2);
		
	}
	
	/**
	 * the large exercise test case
	 * */
	@Test
	public void testLarge() {
		final Node large = new  Node(100000);
		IntStream.rangeClosed(0, 100200).map(v ->100200-v).forEach(v -> large.add(new Node(v)));

		Assert.assertEquals(large.find(0).getValue(), 0);
		Assert.assertNull(large.find(0).getLeft());
		Assert.assertNull(large.find(0).getRight());
		

		Assert.assertNull(large.find(1).getRight());
		Assert.assertEquals(large.find(1).getLeft().getValue(),0);
	}
	
}
