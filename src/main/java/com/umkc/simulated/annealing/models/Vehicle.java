package com.umkc.simulated.annealing.models;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	public Vehicle(double maxWeight) {
		
		this.maxWeight=maxWeight;
		this.totalWeight=maxWeight;
		
	}

	private List<Item> ItemsToTake=new ArrayList<Item>();

	private double maxWeight;

	private double totalWeight;
	
	private double totalUtility = 0;


	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public double getTotalUtility() {
		return totalUtility;
	}

	public void setTotalUtility(double totalUtility) {
		this.totalUtility = totalUtility;
	}


	public List<Item> getItemsToTake() {
		return ItemsToTake;
	}

	public void setItemsToTake(List<Item> itemsToTake) {
		ItemsToTake = itemsToTake;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	@Override
    public String toString() {
        return "Vehicle [totalWeight=" + totalWeight + ", totalUtility=" + totalUtility + ", NumItems=" + ItemsToTake.size() + ", ItemsToTake=" + ItemsToTake
          + ", maxWeight=" + maxWeight+"]";
    }

}
