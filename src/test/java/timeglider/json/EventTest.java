package timeglider.json;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import timeglider.DateDisplay;
import timeglider.elements.Event;
import timeglider.elements.Event.EventBuilder;

import com.google.gson.Gson;

public class EventTest {

	public Gson gson = new Gson();
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	public Date d;
	public Event e;
	public EventBuilder b;
	public String base_json = "{\"id\":\"1038\",\"title\":\"Cool event\""
			+ ",\"startdate\":\"2011-07-192T14:23:00-0500\"}";
		
	@Before
	public void setUp() throws ParseException {
		d = sdf.parse("2011-07-11T14:23:00-0500");
		b = new Event.EventBuilder("1038", "Cool event", d);
	}
	
	@Test
	public void shouldGenerateMinimumNecessaryEvent() {
		Event e = b.build();
		
		assertEquals(base_json, gson.toJson(e));
	}
	
	@Test
	public void shouldNotGenerateImportanceIfDefaultIsSet() {
		Event e = b.importance(Event.DEFAULT_IMPORTANCE).build();
		assertEquals(base_json, gson.toJson(e));
	}
	
	/**
	 * According to the documentation, the start and end dates are set to the same by default unless
	 * enddate is something different.
	 * @throws ParseException 
	 */
	@Test
	public void shouldNotGenerateEndDateifSameAsStartDate() throws ParseException {
		Event e = b.enddate(d).build();
		assertEquals(base_json, gson.toJson(e));
	}
	
	@Test
	public void shouldNotGenerateDateDisplayIfSameAsDefault() {
		Event e = b.date_display(DateDisplay.DAY).build();
		assertEquals(base_json, gson.toJson(e));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotGenerateErroneousDateDisplay() {
		Event e = b.date_display(DateDisplay.valueOf("BAD_FORMAT")).build();
		assertEquals(base_json, gson.toJson(e));
	}
	
	@Test
	public void shouldGenerateImportance() {
		Event e = b.importance(50).build();
		Assert.assertThat(gson.toJson(e), JUnitMatchers.containsString("\"importance\":50"));
	}
	
}
