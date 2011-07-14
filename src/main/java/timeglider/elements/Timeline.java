package timeglider.elements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Timeline Base class.  This class contains metadata about the timeline you want to display, 
 * such as the unique id of the timeline, name and description, focus date for it, and zoom.
 * <br/>
 * Also in the timeline are {@code List<>} elements of {@link Event} and {@link Legend} types,
 * which you will use to populate your timeline.
 *  
 * @author Nick Klauer <klauer@gmail.com>
 * @see {@link http://timeglider.com/jquery/?p=json}
 */
public class Timeline {
	
	private String id;
	private String title;
	private String description;
	private String focus_date;
	private int initial_zoom;
	private List<Event> events;
	private List<Legend> legend;
	
	public static class Builder {
		private String id;
		private String title;
		private String description;
		private String focus_date;
		private int initial_zoom;
		private List<Event> events;
		private List<Legend> legend;
		public final String FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
		
		public Builder(String id, String title, List<Event> events) {
			this.id = id;
			this.title = title;
			this.events = events;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		public Builder focus_date(Date focus) {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
			this.focus_date = sdf.format(focus);
			return this;
		}
		public Builder initial_zoom(int zoom) {
			this.initial_zoom = zoom;
			return this;
		}
		public Builder legend(List<Legend> l) {
			this.legend = l;
			return this;
		}
		public Timeline build() {
			Timeline t = new Timeline();
			t.id = id;
			t.title = title;
			t.description = description;
			t.focus_date = focus_date;
			t.initial_zoom = initial_zoom;
			t.events = events;
			t.legend = legend;
			return t;
		}
	}

}
