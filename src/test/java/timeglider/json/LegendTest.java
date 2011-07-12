package timeglider.json;

import static org.junit.Assert.*;

import org.junit.Test;

import timeglider.elements.Legend;

import com.google.gson.Gson;

public class LegendTest {

	public Gson gson = new Gson();
	
	@Test
	public void shouldGenerateNoJsonIfEmpty() {
		assertEquals("{}", gson.toJson(new Legend(null, null)));
	}
	
	@Test
	public void shouldGenerateBasicJson() {
		assertEquals("{\"title\":\"a title\",\"url\":\"http://thing\"}", gson.toJson(new Legend("a title", "http://thing")));
	}

}
