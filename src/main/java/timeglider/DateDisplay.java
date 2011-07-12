package timeglider;

public enum DateDisplay {
	YEAR, MONTH, DAY, HOUR, NONE;
	
	public String toString() {
		return this.toString().toLowerCase();
	}
}
