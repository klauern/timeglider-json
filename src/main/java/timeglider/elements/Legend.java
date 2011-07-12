package timeglider.elements;

/**
 * Legend element is one element that can show a title for a key and the picture associated with it.
 * <br/><br/>
 * Use these instances to build up a "key" of various icons that your timeline will display for 
 * each element.
 * @author Nick Klauer <klauer@gmail.com>
 *
 */
public class Legend {
	
	private String title;
	private String url;
	
	public Legend(String title, String url) {
		this.title = title;
		this.url = url;
	}

}
