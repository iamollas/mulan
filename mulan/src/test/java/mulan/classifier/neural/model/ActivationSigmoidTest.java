/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package mulan.classifier.neural.model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ActivationSigmoidTest {
	
	private static final double DOUBLES_EQUAL_DELTA = 0.000001;
	private static final double EXPECTED_FUNCT_MAX = 1.0;
	private static final double EXPECTED_FUNCT_MIN = 0.0;
	private static final double[] INPUT_VALUES = {Double.NEGATIVE_INFINITY, -10.99, -1.99, 0, 
												 1.99, 10.99,  Double.POSITIVE_INFINITY};
	private static final double[] EXPECTED_FUNCT_OUT_VALUES = {0, 0.000016, 0.120256, 0.5, 
			0.879743, 0.999983, 1};
	private static final double[] EXPECTED_FUNCT_DERIVATIVE_VALUES = {0, 0.000016,  0.105795, 
			0.25, 0.105795, 0.000016, 0};
	
	private ActivationSigmoid function;
	
	@Before
	public void setUp(){
		function = new ActivationSigmoid();
	}
	
	@After
	public void tearDown(){
		function = null;
	}
	
	@Test
	public void testActivate(){
		for(int i = 0; i < INPUT_VALUES.length; i++){
			double functOutput = function.activate(INPUT_VALUES[i]);
			assertEquals("The function output is not as expected.", EXPECTED_FUNCT_OUT_VALUES[i], functOutput, DOUBLES_EQUAL_DELTA);			
		}
	}
	
	@Test
	public void testDerivative(){
		for(int i = 0; i < INPUT_VALUES.length; i++){
			double functOutput = function.derivative(INPUT_VALUES[i]);
			assertEquals("The function derivation output is not as expected.", EXPECTED_FUNCT_DERIVATIVE_VALUES[i], functOutput, DOUBLES_EQUAL_DELTA);			
		}
	}
	
	@Test
	public void testGetMax(){
		double max = function.getMax();
		assertEquals("Maximu of the function is not as expected.", EXPECTED_FUNCT_MAX, max, 0);
	}
	
	@Test
	public void testGetMin(){
		double min = function.getMin();
		assertEquals("Minimum of the function is not as expected.", EXPECTED_FUNCT_MIN, min, 0);
	}
}
