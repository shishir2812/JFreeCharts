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

	
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception { 
	}

}