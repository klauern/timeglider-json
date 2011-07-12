package timeglider.json;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

	private String id;
	private String title;
	private String description;
	private String startdate;
	private String enddate;
	private String date_display;
	private String url;
	private String icon;
	private int importance;
	
	public static class EventBuilder {
		private String id;
		private String title;
		private String description;
		private String startdate;
		private String enddate;
		private String date_display;
		private String url;
		private String icon;
		private int importance;
		public final String FORMAT = "yyyy-MM-DD'T'HH:mm:ssZ";
		
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
		public EventBuilder enddate(Date enddate) {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
			this.enddate = sdf.format(enddate);
			return this;
		}
		public EventBuilder date_display(String date_display) {
			this.date_display = date_display;
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
			this.importance = importance;
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
