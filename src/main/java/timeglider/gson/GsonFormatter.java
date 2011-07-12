package timeglider.gson;

import java.util.List;

import timeglider.json.Timeline;

import com.google.gson.Gson;

public class GsonFormatter {

	private List<Timeline> timelines;
	private transient Gson gson = new Gson();
	
	public String toJson() {
		return gson.toJson(this);
	}

}
