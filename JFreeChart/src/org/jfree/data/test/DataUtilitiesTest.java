package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest {

	// tests for calculateColumnTotal()
	@Test(expected = InvalidParameterException.class)
	public void calculateColumnTotalForNullTable() {
		DataUtilities.calculateColumnTotal(null, 0);
		// throws NullPointerException instead
	}

	@Test
	public void calculateColumnTotalBLB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(5));
			}
		});
		// exercise - testing index -1
		double result = DataUtilities.calculateColumnTotal(values, -1);
		// verify
		//docs say it will return 0 upon invalid input
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotalLB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(5));
				one(values).getValue(0, 0);
				will(returnValue(1));
				one(values).getValue(1, 0);
				will(returnValue(1));
				one(values).getValue(2, 0);
				will(returnValue(1));
				one(values).getValue(3, 0);
				will(returnValue(1));
				one(values).getValue(4, 0);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotalALB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(5));
				one(values).getValue(0, 1);
				will(returnValue(1));
				one(values).getValue(1, 1);
				will(returnValue(1));
				one(values).getValue(2, 1);
				will(returnValue(1));
				one(values).getValue(3, 1);
				will(returnValue(1));
				one(values).getValue(4, 1);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 1);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotalBUB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(5));
				one(values).getValue(0, 3);
				will(returnValue(1));
				one(values).getValue(1, 3);
				will(returnValue(1));
				one(values).getValue(2, 3);
				will(returnValue(1));
				one(values).getValue(3, 3);
				will(returnValue(1));
				one(values).getValue(4, 3);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 3);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotalUB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(5));
				one(values).getValue(0, 4);
				will(returnValue(1));
				one(values).getValue(1, 4);
				will(returnValue(1));
				one(values).getValue(2, 4);
				will(returnValue(1));
				one(values).getValue(3, 4);
				will(returnValue(1));
				one(values).getValue(4, 4);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 4);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotalAUB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(5));
			}
		});
		// exercise - testing index > numCols
		double result = DataUtilities.calculateColumnTotal(values, 5);
		// verify
		//docs say it will return 0 upon invalid input
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotalNOM() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(5));
				one(values).getValue(0, 2);
				will(returnValue(1));
				one(values).getValue(1, 2);
				will(returnValue(1));
				one(values).getValue(2, 2);
				will(returnValue(1));
				one(values).getValue(3, 2);
				will(returnValue(1));
				one(values).getValue(4, 2);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 2);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	// tests for createNumberArray
	@Test(expected = InvalidParameterException.class)
	public void createNumberArrayNull() {
		DataUtilities.createNumberArray(null);
		// throws IllegalArgumentException instead
	}

	@Test(expected = InvalidParameterException.class)
	public void createNumberArrayEmpty() {
		double a[] = {};
		DataUtilities.createNumberArray(a);
		
		// throws an AssertionError instead
	}

	@Test
	public void createNumberArrayValid() {
		double a[] = { 1.5, 2.5, 3.5};
		Number r[] = DataUtilities.createNumberArray(a);
		Number expected[] = { 1.5, 2.5, 3.5};
		assertArrayEquals(expected, r);
	}
	
	// tests for createNumberArray2D
	@Test(expected = InvalidParameterException.class)
	public void createNumberArray2DNull() {
		DataUtilities.createNumberArray2D(null);
		// throws IllegalArgumentException instead
	}

	@Test(expected = InvalidParameterException.class)
	public void createNumberArray2DEmpty() {
		double a[][] = { {} };
		DataUtilities.createNumberArray2D(a);
		// throws an AssertionError instead
	}

	@Test
	public void createNumberArray2DValid() {
		double a[][] = { { 1, 2, 3 }, { 1.5, 2.5, 3.5 }, { -2, -1, 0 } };
		Number r[][] = DataUtilities.createNumberArray2D(a);
		Number expected[][] = { { 1.0, 2.0, 3.0 }, { 1.5, 2.5, 3.5 }, { -2.0, -1.0, 0.0 } };
		assertArrayEquals(expected, r);
	}

	@Test(expected = InvalidParameterException.class)
	public void createNumberArray2DInnerNull() {
		double a[][] = { { 1, 2, 3 }, null, { -2, -1, 0 } };
		DataUtilities.createNumberArray2D(a);
		// throws IllegalArgumentException instead
	}

	@Test
	public void createNumberArray2DInnerEmpty() {
		double a[][] = { { 1, 2, 3 }, {}, { -2, -1, 0 } };
		Number r[][] = DataUtilities.createNumberArray2D(a);
		Number expected[][] = { { 1.0, 2.0, 3.0 }, {}, { -2.0, -1.0, 0.0 } };
		assertArrayEquals(expected, r);
	}

	// tests for calculateRowTotal()
	@Test(expected = InvalidParameterException.class)
	public void calculateRowTotalForNullTable() {
		DataUtilities.calculateRowTotal(null, 0);
		// throws NullPointerException instead
	}

	@Test
	public void calculateRowTotalBLB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(5));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, -1);
		
		// verify
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotalLB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
				one(values).getValue(0, 0);
				will(returnValue(1));
				one(values).getValue(0, 1);
				will(returnValue(1));
				one(values).getValue(0, 2);
				will(returnValue(1));
				one(values).getValue(0, 3);
				will(returnValue(1));
				one(values).getValue(0, 4);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotalALB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
				one(values).getValue(1, 0);
				will(returnValue(1));
				one(values).getValue(1, 1);
				will(returnValue(1));
				one(values).getValue(1, 2);
				will(returnValue(1));
				one(values).getValue(1, 3);
				will(returnValue(1));
				one(values).getValue(1, 4);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 1);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotalBUB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
				one(values).getValue(3, 0);
				will(returnValue(1));
				one(values).getValue(3, 1);
				will(returnValue(1));
				one(values).getValue(3, 2);
				will(returnValue(1));
				one(values).getValue(3, 3);
				will(returnValue(1));
				one(values).getValue(3, 4);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 3);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotalUB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
				one(values).getValue(4, 0);
				will(returnValue(1));
				one(values).getValue(4, 1);
				will(returnValue(1));
				one(values).getValue(4, 2);
				will(returnValue(1));
				one(values).getValue(4, 3);
				will(returnValue(1));
				one(values).getValue(4, 4);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 4);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotalAUB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 5);
		// verify
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotalNOM() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
				one(values).getValue(2, 0);
				will(returnValue(1));
				one(values).getValue(2, 1);
				will(returnValue(1));
				one(values).getValue(2, 2);
				will(returnValue(1));
				one(values).getValue(2, 3);
				will(returnValue(1));
				one(values).getValue(2, 4);
				will(returnValue(1));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 2);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}

	//tests for getCumulativePercentage
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentageForNullTable() {
		DataUtilities.getCumulativePercentages(null);
		// throws NullPointerException instead
	}
	@Test
	public void getCumulativePercentageNOM(){
		//Setup
		Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				
				atLeast(1).of(values).getItemCount();
				will(returnValue(3));
				
				//key/value pair 
				atLeast(1).of(values).getKey(0); //get Key at index 0
				will(returnValue(0));			
				atLeast(1).of(values).getValue(0); // get value at key=0
				will(returnValue(5));
				
				//key/value pair 
				atLeast(1).of(values).getKey(1); 
				will(returnValue(1));			
				atLeast(1).of(values).getValue(1); 
				will(returnValue(9));
				
				//key/value pair 
				atLeast(1).of(values).getKey(2);
				will(returnValue(2));			
				atLeast(1).of(values).getValue(2);
				will(returnValue(2));
				
			}
		});
		Mockery mockingContext2 = new Mockery();
		final KeyedValues expected = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{
				
				atLeast(1).of(expected).getItemCount();
				will(returnValue(3));
				
				//key/value pair 
				atLeast(1).of(expected).getKey(0); //get Key at index 0
				will(returnValue(0));			
				atLeast(1).of(expected).getValue(0); // get value at key=0
				will(returnValue(0.3125)); // this is the expected cumulative percentage 
				
				//key/value pair 
				atLeast(1).of(expected).getKey(1); 
				will(returnValue(1));			
				atLeast(1).of(expected).getValue(1); 
				will(returnValue(0.875));
				
				//key/value pair 
				atLeast(1).of(expected).getKey(2);
				will(returnValue(2));			
				atLeast(1).of(expected).getValue(2);
				will(returnValue(1.0));
				
			}
		});
				// exercise
				KeyedValues result = DataUtilities.getCumulativePercentages(values);
				// verify
				for(int i = 0 ; i < result.getItemCount(); i++){
					int key = (int) result.getKey(i);
					assertEquals("Expect each result value == expected value",expected.getValue(key).doubleValue(), result.getValue(0).doubleValue(), .000000001d);
				}
				// tear-down: NONE in this test method
			
	}
	
	@Test(expected = ArithmeticException.class)
	public void getCumulativePercentageDivByZero(){
		//Setup
		Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				
				atLeast(1).of(values).getItemCount();
				will(returnValue(2));
				
				//key/value pair 
				atLeast(1).of(values).getKey(0); //get Key at index 0
				will(returnValue(0));			
				atLeast(1).of(values).getValue(0); // get value at key=0
				will(returnValue(0));
				
				
				//key/value pair 
				atLeast(1).of(values).getKey(1);
				will(returnValue(1));			
				atLeast(1).of(values).getValue(1);
				will(returnValue(0));
				
			}
		});
		Mockery mockingContext2 = new Mockery();
		final KeyedValues expected = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{
				
				atLeast(1).of(expected).getItemCount();
				will(returnValue(2));
				
				//key/value pair 
				atLeast(1).of(expected).getKey(0); //get Key at index 0
				will(returnValue(0));			
				atLeast(1).of(expected).getValue(0); // get value at key=0
				will(returnValue(0)); // this is the expected cumulative percentage 
				
				//key/value pair 
				atLeast(1).of(expected).getKey(1);
				will(returnValue(1));			
				atLeast(1).of(expected).getValue(1);
				will(returnValue(0));
				
			}
		});
				// exercise
				//expect a div by zero (arithmetic exception) here
				//but it is not thrown, they must check if numerator is 0 then they don't do the division
				DataUtilities.getCumulativePercentages(values);
	}


}


