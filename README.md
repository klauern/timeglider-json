TimeGlider JSON - Java Stubs for Serialization
==============================================
This is a simple project to give me a chance to serialize from Java to
[Timeglider][1]'s JSON format.  It does not deserialize the data, as
I currently have no use for it.

I've provided 3 base classes(Event, Legend, Timeline) and one serializer (GsonFormatter) 
that you can build to populate your timeline, then just throw it at Google's 
[Gson][3] object to generate your JSON format.  Gson is a pretty nifty library,
and makes much of this work a breeze.


How to Use
----------
According to the [documentation][1], Timeglider will take an array of timelines
in and use those for display.  Each Timeline is composed of a `Legend` class,
which will show you the equivalent of a key in a map, where each `Legend` class
is a title of what the icon displays, and a link to the `.png` file for it.

Each Timeline is mostly composed of `Event` instance, which you can create
borrowing from Josh Bloch's [revised builder pattern][4]:

    Event e = new Event.EventBuilder("unique event id", "Event Title", new
                                    Date())
                                      .title("title")       // all additional fields are optional
                                      .enddate(new Date())
                                      ....
                                      .build();             // But don't forget to do this


Rolling these into a timeline is pretty easy, too.  To create a single timeline,
create a new `Timeline` class:

    Timeline t = new Timeline.Builder("id_to_give", "Title of Timeline",
                                      List<Event> list_of_events)
                                      .focus_date(...)      // same as Event: all additional fields optional
                                      ...
                                      .build();             // make sure you do this, though

and finally, to create your TimeGlider JSON:

    GsonFormatter g = new GsonFormatter(new List<Timeline>(){ timelines });

    String timeglider_json = g.toJson();  // Ta Da!

Details about Timeglider can be found in the Information section.

Information
-----------

   * [Timeglider][1]
   * [JSON format][2]


[1]: http://www.timeglider.com/jquery
[2]: http://timeglider.com/jquery/?p=json
[3]: http://code.google.com/p/google-gson/
[4]: http://stackoverflow.com/questions/4859815/whats-the-revised-builder-pattern
