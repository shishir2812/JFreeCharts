package org.jfree.data.test;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import org.jfree.data.Range;

import org.junit.*;

public class RangeTest {

	private Range exampleRange;
	private Range exampleRange2;
	private Range exampleRange3;
	private Range exampleRange4;
	private Range exampleRange5;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
	}

	@Before
	public void setUp() throws Exception{
		exampleRange = new Range(-1, 1);
		exampleRange2 = new Range(0, 2);
		exampleRange3 = new Range(3, 5);
		exampleRange4 = new Range(0.5, 1.5);
		exampleRange5 = new Range(0, 10);
	}

	//Tests for combine()
	@Test
	public void combineNullRanges(){
		Range r = Range.combine(null,null);
		assertEquals("The combination of 2 null ranges should be null", null, r);
	}
	@Test
	public void combineFirstRangeNull(){
		Range r = Range.combine(null,exampleRange);
		Range expected = new Range(-1, 1);
		assertEquals("The combination of 1 null range (first arg) and 1 valid should return the valid range", expected, r);
	}
	@Test
	public void combineSecondRangeNull(){
		Range r = Range.combine(exampleRange,null);
		Range expected = new Range(-1, 1);
		assertEquals("The combination of 1 null range (second arg) and 1 valid should return the valid range",expected, r);
	}
	@Test
	public void combineSameRangeObject(){
		Range r = Range.combine(exampleRange,exampleRange);
		Range expected = new Range(-1, 1);
		assertEquals("The combination of the same range object should return the same object", expected, r);
	}
	@Test
	public void combineOverlappingRangesLowThenHigh(){
		Range r = Range.combine(exampleRange,exampleRange2);
		Range expected = new Range(-1, 2);
		assertEquals("The combination of (-1,1) and (0,2) overlapping ranges should be -1 to 2", expected, r);
	}
	@Test
	public void combineOverlappingRangesHighThenLow(){
		Range r = Range.combine(exampleRange2,exampleRange);
		Range expected = new Range(-1, 2);
		assertEquals("The combination of (0,2) and (-1,1) overlapping ranges should be -1 to 2", expected, r);
	}
	@Test
	public void combineNotOverlappingRangesLowThenHigh(){
		Range r = Range.combine(exampleRange2,exampleRange3);
		Range expected = new Range(0, 5);
		assertEquals("The combination of (0,2) and (3,5) overlapping ranges should be 0 to 5", expected, r);
	}
	@Test
	public void combineNotOverlappingRangesHighThenLow(){
		Range r = Range.combine(exampleRange3,exampleRange2);
		Range expected = new Range(0, 5);
		assertEquals("The combination of (3,5) and (0,2)  overlapping ranges should be 0 to 5", expected, r);
	}
	@Test
	public void combineContainedRangesFirstContainsSecond(){
		Range r = Range.combine(exampleRange2,exampleRange4);
		Range expected = new Range(0, 2);
		assertEquals("The combination of (0,2) and (0.5,1.5) ranges should be 0 to 2", expected, r);
	}
	@Test
	public void combineContainedRangesSecondContainsFirst(){
		Range r = Range.combine(exampleRange4,exampleRange2);
		Range expected = new Range(0, 2);
		assertEquals("The combination of (0.5,1.5) and (0,2) ranges should be 0 to 2", expected, r);
	}

	//Tests for expand()
	@Test(expected = InvalidParameterException.class)
	public void expandNullRange(){
		Range.expand(null,1,1);
		//it throws java.lang.IllegalArgumentException instead
	}
	@Test
	public void expandMarginsBBandBB(){
		Range r = Range.expand(exampleRange5,-0.1,-0.1);
		Range expected = new Range(1, 9);
		assertEquals("The expansion of (0,10) by margins (-0.1,-0.1)", expected, r);
	}
	@Test
	public void expandMarginsBBandAB(){
		Range r = Range.expand(exampleRange5,-0.1,0.1);
		Range expected = new Range(1, 11);
		assertEquals("The expansion of (0,10) by margins (-0.1,0.1)", expected, r);
	}
	@Test
	public void expandMarginsBBandB(){
		Range r = Range.expand(exampleRange5,-0.1,0);
		Range expected = new Range(1, 10);
		assertEquals("The expansion of (0,10) by margins (-0.1,0)", expected, r);
	}
	@Test
	public void expandMarginsBandBB(){
		Range r = Range.expand(exampleRange5,0,-0.1);
		Range expected = new Range(0, 9);
		assertEquals("The expansion of (0,10) by margins (0,-0.1)", expected, r);
	}
	@Test
	public void expandMarginsBandAB(){
		Range r = Range.expand(exampleRange5,0,0.1);
		Range expected = new Range(0, 11);
		assertEquals("The expansion of (0,10) by margins (0,0.1)", expected, r);
	}
	@Test
	public void expandMarginsBandB(){
		Range r = Range.expand(exampleRange5,0,0);
		Range expected = new Range(0, 10);
		assertEquals("The expansion of (0,10) by margins (0,0)", expected, r);
	}
	@Test
	public void expandMarginsABandBB(){
		Range r = Range.expand(exampleRange5,0.1,-0.1);
		Range expected = new Range(-1, 9);
		assertEquals("The expansion of (0,10) by margins (0.1,-0.1)", expected, r);
	}
	@Test
	public void expandMarginsABandAB(){
		Range r = Range.expand(exampleRange5,0.1,0.1);
		Range expected = new Range(-1, 11);
		assertEquals("The expansion of (0,10) by margins (0.1,0.1)", expected, r);
	}
	@Test
	public void expandMarginsABandB(){
		Range r = Range.expand(exampleRange5,0.1,0);
		Range expected = new Range(-1, 10);
		assertEquals("The expansion of (0,10) by margins (0.1,0)", expected, r);
	}

	//tests for intersects()
	@Test
	public void test_Intersects_Provided_Lowerbound_Less_Than_Upperbound()
	{
		Range toTest = new Range(0, 10);
		boolean result = toTest.intersects(2, 15);
		assertEquals("Testing intersects() where the provided lower bound < toTests upper bound", true, result);
		toTest = null;
	}

	@Test
	public void test_Intersects_Provided_Lowerbound_Equal_To_Upperbound()
	{
		Range toTest = new Range(0, 10);
		boolean result = toTest.intersects(10, 15);
		assertEquals("Testing intersects() where the provided lower bound == toTests upper bound", true, result);
		toTest = null;
	}

	@Test
	public void test_Intersects_Provided_Lowerbound_Greater_Than_Upperbound()
	{
		Range toTest = new Range(0, 10);
		boolean result = toTest.intersects(11, 15);
		assertEquals("Testing intersects() where the provided lower bound > toTests upper bound", false, result);
		toTest = null;
	}

	@Test
	public void test_Intersects_provided_Upperbound_Less_Than_Lowerbound()
	{
		Range toTest = new Range(0, 10);
		boolean result = toTest.intersects(-10, -5);
		assertEquals("Testing intersects() where the provided Upper bound < toTests lower bound", false, result);
		toTest = null;
	}


	@Test
	public void test_Intersects_provided_Upperbound_Equal_To_Lowerbound()
	{
		Range toTest = new Range(0, 10);
		boolean result = toTest.intersects(-10, 0);
		assertEquals("Testing intersects() where the provided Upper bound == toTests lower bound", true, result);
		toTest = null;
	}

	@Test
	public void test_Intersects_provided_Upperbound_Greater_Than_Lowerbound()
	{
		Range toTest = new Range(0, 10);
		boolean result = toTest.intersects(-10, 1);
		//		System.out.println(toTest);
		assertEquals("Testing intersects() where the provided Upper bound > toTests lower bound", true, result);
		toTest = null;
	}

	@Test
	public void test_Intersects_Provided_Range_Contained_Within_Range()
	{
		Range toTest = new Range(0, 10);
		boolean result = toTest.intersects(4, 8);
		assertEquals("Testing intersects() where the provided range is whithin toTests range", true, result);
		toTest = null;
	}

	//Tests for shift
	@Test(expected=NullPointerException.class)
	public void test_Shift_Null_Range()
	{
		Range toTest = null;
		Range.shift(toTest, 5);
	}

	@Test
	public void test_Shift_Neither_Bound_Hits_Zero()
	{
		Range toTest = new Range(0, 10);
		Range compare = new Range(5, 15);
		toTest = Range.shift(toTest, 5);
		assertEquals("Testing shift where the shift results in niether bound hitting zero:", compare, toTest);
		toTest = null;
		compare = null;
	}

	@Test
	public void test_Shift_Upper_Bound_Hits_Zero()
	{
		Range toTest = new Range(-20, -5);
		Range compare = new Range(-10, 0);
		toTest = Range.shift(toTest, 10);
		assertEquals("Testing shift where the shift results in the upper bound hitting zero:", compare, toTest);
		toTest = null;
		compare = null;
	}

	@Test
	public void test_Shift_Lower_Bound_Hits_Zero()
	{
		Range toTest = new Range(-5, 5);
		Range compare = new Range(0, 15);
		toTest = Range.shift(toTest, 10);
		assertEquals("Testing shift where the shift results in the lower bound hitting zero:", compare, toTest);
		toTest = null;
		compare = null;
	}

	@Test
	public void test_Shift_Both_Bounds_Hit_Zero()
	{
		Range toTest = new Range(-5, -1);
		Range compare = new Range(0, 0);
		toTest = Range.shift(toTest, 10);
		assertEquals("Testing shift where the shift results in both bounds hitting zero:", compare, toTest);
		toTest = null;
		compare = null;
	}

	//tests for contains
	@Test
	public void test_Contains_Greater_Than_Upper()
	{
		Range toTest = new Range(-5.0, 10);
		boolean result = toTest.contains(15);
		assertEquals("Testing contains with a value greater than the upper bound of range", false, result);
		toTest = null;
	}

	@Test
	public void test_Contains_Equal_To_Upper()
	{
		Range toTest = new Range(-5.0, 10);
		boolean result = toTest.contains(10.0);
		assertEquals("Testing contains with a value equal to the upper bound of range", true, result);
		toTest = null;
	}

	@Test
	public void test_Contains_In_Middle()
	{
		Range toTest = new Range(-5.0, 10);
		boolean result = toTest.contains(3.0);
		assertEquals("Testing contains with a value in the middle of the specified range:", true, result);
		toTest = null;
	}

	@Test
	public void test_Contains_Equal_To_Lower()
	{
		Range toTest = new Range(-5.0, 10);
		boolean result = toTest.contains(-5.0);
		assertEquals("Testing contains with a value equal to the lower bound of range", true, result);
		toTest = null;
	}
	@Test
	public void test_Contains_Less_Than()
	{
		Range toTest = new Range(0, 10);
		boolean result = toTest.contains(-5.0);
		assertEquals("Testing contains() with a value that is less than the lower bound of range", false, result);
		toTest = null;
	}


	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception { 
	}

}