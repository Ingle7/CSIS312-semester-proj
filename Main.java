import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main
{

    private static Clock clock;
        
    public static void main(String[] args) throws IOException
    {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date is: "+today);

        WeatherToday weather = new WeatherToday();
        System.out.println(weather.location(weather));

        BibleVerse example = new BibleVerse();
        String response = example.run("https://raw.github.com/square/okhttp/master/README.md");
        System.out.println("Verse of the day:\n" + response);

        Calendar time = Calendar.getInstance(
            TimeZone.getTimeZone("EST")
        );
        
        Clock clock = new Clock();
        clock.setValue(
                time.get(time.HOUR_OF_DAY),
                time.get(time.MINUTE),
                time.get(time.SECOND)
             )
             .setFormat("Current time: %h% %m%'%s%")
             .work();
    }
}