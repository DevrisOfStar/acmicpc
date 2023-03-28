package Problem_10699;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {    
         LocalDateTime utcDateTime = LocalDateTime.now(ZoneId.of("UTC+00:00"));
         ZonedDateTime seoulDateTime = utcDateTime.atZone(ZoneId.of("Asia/Seoul")).plusHours(9);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         System.out.println(seoulDateTime.format(formatter));
    }
}
