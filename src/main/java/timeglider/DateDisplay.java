package timeglider;

/**
 * DateDisplay provides an enumeration of the ways in which a date can be displayed
 * in TimeGlider.  If you would like only to show the year for a date, you can set
 * this Enum to {@code DateDisplay.YEAR}, which will let TimeGlider ignore the rest 
 * of the time element.
 * @author Nick Klauer <klauer@gmail.com>
 *
 */
public enum DateDisplay {
	YEAR, MONTH, DAY, HOUR, NONE;
	
	public String toString() {
		return this.toString().toLowerCase();
	}
}
