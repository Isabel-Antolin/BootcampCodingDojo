import java.util.HashMap;
import java.util.Map;

public class Hashmatique {
  public static void main(String[] args) {
    HashMap<String, String> trackList = new HashMap<String, String>();

    trackList.put("Thunder",
        "Thunder, feel the thunder (thun-, thun-) Lightning then the thunder (th-th-thunder, thunder) Thunder, feel the thunder (thun-, thun-)Lightning then the thunder, thunder (th-th-thunder, thunder)");
    trackList.put("Counting Stars",
        "Lately, I've been, I've been losing sleep Dreaming about the things that we could be But baby, I've been, I've been praying hard Said, No more counting dollars, we'll be counting stars Yeah, we'll be counting stars");
    trackList.put("Ride",
        "Oh, oh, oh, oh, Oh, oh, oh, oh, I'm fallin' so I'm taking my time on my ride, Oh, oh, oh, oh,I'm fallin' so I'm taking my time on my ride");
    trackList.put("Treat You Better",
        "Tell me, why are we wasting time,On all your wasted crying,When you should be with me instead?,I know I can treat you better,Better than he can");

    String lyrics = trackList.get("Thunder");
    System.out.println(lyrics);

    for(Map.Entry<String, String> entry : trackList.entrySet()) {
      String track = entry.getKey();
      String lyricsLine = entry.getValue();
      System.out.println(track + ": " + lyricsLine);
    }
  }

}
