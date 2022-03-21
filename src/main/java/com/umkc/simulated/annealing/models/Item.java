package com.umkc.simulated.annealing.models;

public class Item {

	private double utility;
	private double weight;
	private boolean selected;

	public double getUtility() {
		return utility;
	}

	public void setUtility(double utility) {
		this.utility = utility;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Override
    public String toString() {
        return "Item [utility=" + utility + ", weight=" + weight + ", selected=" + selected+"]";
    }


}
