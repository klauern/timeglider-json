package timeglider.json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

public class TimelineTest {

	public Date d;
	public SimpleDateFormat sdf;
	public Gson gson = new Gson();
	
	@Before
	public void setUp() throws ParseException {
		sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		d = sdf.parse("2011-07-11T14:23:00-0500");
	}

	@Test
	public void shouldGenerateBaseTimeline() {
		Timeline t = new Timeline.Builder("103", "Timeline", Lists.newArrayList(new Event.EventBuilder("1", "event", d).build())).build();
		System.out.println(gson.toJson(t));
		gson.toJson(t);
	}

}
