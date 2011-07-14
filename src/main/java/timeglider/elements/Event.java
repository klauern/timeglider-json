package timeglider.elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import timeglider.DateDisplay;

/**
 * An Event is the base element in a TimeGlider timeline.  Each event can show various details about itself,
 * such as a description, name, start and end dates, as well as providing ancillary data such as level
 * of importance relative to other elements, an icon (PNG), and a link to follow the event somewhere else.
 * @author Nick Klauer <klauer@gmail.com>
 *
 */
public class Event {

	private String id;
	private String title;
	private String description;
	private String startdate;
	private String enddate;
	private String date_display;
	private String url;
	private String icon;
	private Integer importance;
	public transient final static int DEFAULT_IMPORTANCE = 20; // So says TimeGlider
															   // docs.

	public static class EventBuilder {
		private String id;
		private String title;
		private String description;
		private String startdate;
		private String enddate;
		private String date_display;
		private String url;
		private String icon;
		private Integer importance = null;
		public final String FORMAT = "yyyy-MM-DD'T'HH:mm:ssZ";

		public EventBuilder(String id, String title, Date startdate) {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
			this.startdate = sdf.format(startdate);
			this.id = id;
			this.title = title;
		}

		public EventBuilder id(String id) {
			this.id = id;
			return this;
		}

		public EventBuilder title(String title) {
			this.title = title;
			return this;
		}

		public EventBuilder description(String description) {
			this.description = description;
			return this;
		}

		public EventBuilder startdate(Date startdate) {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
			this.startdate = sdf.format(startdate);
			return this;
		}

		public EventBuilder enddate(Date enddate) throws ParseException {

			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
			if (!enddate.equals(sdf.parse(startdate))) {
				this.enddate = sdf.format(enddate);
			}
			return this;
		}

		public EventBuilder date_display(DateDisplay display) {
			if (!display.equals(DateDisplay.DAY)) {
				this.date_display = date_display.toString();
			}
			return this;
		}

		public EventBuilder url(String url) {
			this.url = url;
			return this;
		}

		public EventBuilder icon(String icon) {
			this.icon = icon;
			return this;
		}

		public EventBuilder importance(int importance) {
			if (importance != DEFAULT_IMPORTANCE) {
				this.importance = importance;
			}
			return this;
		}

		public Event build() {
			Event e = new Event();
			e.id = id;
			e.title = title;
			e.description = description;
			e.startdate = startdate;
			e.enddate = enddate;
			e.date_display = date_display;
			e.url = url;
			e.icon = icon;
			e.importance = importance;
			return e;
		}

	}
}
