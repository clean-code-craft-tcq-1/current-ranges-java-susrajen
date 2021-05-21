package main.java.battery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BatteryCurrentMonitor {

	public static ArrayList<ArrayList<Integer>> determineRangesInAChargingSession(List<Integer> currentReadings) {
		ArrayList<ArrayList<Integer>> listOfRanges = new ArrayList<ArrayList<Integer>>();
		if(checkIfCurrentReadingsIsEmpty(currentReadings)) {
		
			int valueToCompare = sortReadingsAndGetTheFirstValue(currentReadings);
			ArrayList<Integer> range = new ArrayList<Integer>();
			for(int reading: currentReadings) {
				int differenceValue = valueToCompare - reading;
				range = rangeCalculation(listOfRanges, range, differenceValue); 
				range.add(reading);	
		
			}
		}
		return listOfRanges;
	}

	public static ArrayList<Integer> rangeCalculation(ArrayList<ArrayList<Integer>> listOfRanges,
			ArrayList<Integer> range, int differenceValue) {

		if(differenceValue > 1) {
			listOfRanges.add(range);
			range = new ArrayList<Integer>();
		}
		return range;
	}

	private static int sortReadingsAndGetTheFirstValue(List<Integer> currentReadings) {
		Collections.sort(currentReadings);
		int valueToCompare = currentReadings.get(0);
		return valueToCompare;
	}

	public static Boolean checkIfCurrentReadingsIsEmpty(List<Integer> currentReadings) {
		if(currentReadings.isEmpty()) {
			return false;
		}
		return true;
	}

}
