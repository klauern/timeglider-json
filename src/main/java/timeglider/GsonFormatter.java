package timeglider;

import java.util.List;

import timeglider.elements.Timeline;

import com.google.gson.Gson;

/**
 * Base class to format a {@code List<>} of {@link Timeline} objects and serialize
 * into JSON-formatted data.
 * 
 * @author Nick Klauer <klauer@gmail.com>
 */
public class GsonFormatter {

	private List<Timeline> timelines;
	private transient Gson gson = new Gson();
	
	public String toJson() {
		return gson.toJson(this);
	}

}
