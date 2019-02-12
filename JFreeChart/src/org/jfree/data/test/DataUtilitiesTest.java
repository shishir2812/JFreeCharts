package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest {
	
	//tests for calculateColumnTotal()
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
		mockingContext.checking(new Expectations() {{
			oneOf(values).getRowCount();
			will(returnValue(5));
		}});
		//exercise 
		double result = DataUtilities.calculateColumnTotal(values, -1);
		// verify
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}
	@Test
	public void calculateColumnTotalLB() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
			one(values).getRowCount();
			will(returnValue(5));
		}});
		//exercise 
		double result = DataUtilities.calculateColumnTotal(values, 5);
		// verify
		assertEquals(0, result, .000000001d);
		// tear-down: NONE in this test method
	}
	@Test
	public void calculateColumnTotalNOM() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
		double result = DataUtilities.calculateColumnTotal(values, 2);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}
	

	
	//tests for calculateRowTotal()
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
		mockingContext.checking(new Expectations() {{
			oneOf(values).getColumnCount();
			will(returnValue(5));
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
			one(values).getColumnCount();
			will(returnValue(5));
		}});
		//exercise 
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
		mockingContext.checking(new Expectations() {{
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
		}});
		//exercise 
		double result = DataUtilities.calculateRowTotal(values, 2);
		// verify
		assertEquals(5, result, .000000001d);
		// tear-down: NONE in this test method
	}
}