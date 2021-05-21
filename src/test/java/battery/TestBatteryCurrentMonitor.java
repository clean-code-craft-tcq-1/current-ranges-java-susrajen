package test.java.battery;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import main.java.battery.BatteryCurrentMonitor;

public class TestBatteryCurrentMonitor {
	@Test
	public void whenCurrentRangeValueIsEmpty_returnFalse() {
		assertFalse(BatteryCurrentMonitor.checkIfCurrentReadingsIsEmpty(Collections.emptyList()));
	}

	@Test
	public void whenCurrentRangeValueIsNotEmpty_returnTrue() {
		List<Integer> currentReadings = new ArrayList<Integer>();
		currentReadings.add(3);
		currentReadings.add(4);
		assertTrue(BatteryCurrentMonitor.checkIfCurrentReadingsIsEmpty(currentReadings));
	}
	
	// Test fails because negative range difference condition is not added
	@Test 
	public void whenCurrentReadingsIsPassed_expectAListOfRanges() {
		List<Integer> currentReadings = Arrays.asList(3,7,2,4,8,9);
		ArrayList<ArrayList<Integer>> rangeList = BatteryCurrentMonitor.determineRangesInAChargingSession(currentReadings);
		System.out.println("rangeList : " + rangeList);
		assertTrue(rangeList.get(0).size() == 3);
	}
}
