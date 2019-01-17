package Timeandday.Timeandday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Converter {

	public static LocalDate datetolocaldate(Date d) throws ParseException {

		Instant instant = d.toInstant();
		ZonedDateTime date1 = instant.atZone(ZoneId.systemDefault());
		System.out.println("localTime"+date1);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-LLLL-dd");
		String formattedString1 = date1.format(formatter1);
		String x = formattedString1.substring(0, 5) + "0" + formattedString1.substring(5, formattedString1.length());
		LocalDate localDate = LocalDate.parse(x);
		return localDate;

	}

	public static LocalTime dateToLocalTime(Date d) {
		

	    Instant instant = Instant.ofEpochMilli(d.getTime());
	    LocalTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
	    System.out.println(res);
		return res;
	}
	


public static Date localDatetodate(LocalDate dateToConvert) {
		
	return java.util.Date.from(dateToConvert.atStartOfDay()
		      .atZone(ZoneId.systemDefault())
		      .toInstant());

	 
	}

public static Calendar LocalDatetocalender(LocalDate date) {
	
    GregorianCalendar gc = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
	
	return gc;
}

public static LocalDate calenderTolocalDate(Object set) {
	// TODO Auto-generated method stub
	return null;
}


public static ZonedDateTime convertCalendarToZonedTime(Calendar cal,ZoneId zoneid)
{
	
	ZonedDateTime zonedDateTime = ZonedDateTime.of(CalendarToLocalDateTime(cal), zoneid);
	
	return zonedDateTime;
	
}


private static LocalDateTime CalendarToLocalDateTime(Calendar cal) {
	Date date = cal.getTime();
	return date.toInstant()
		      .atZone(ZoneId.systemDefault())
		      .toLocalDateTime();
	
}



public static OffsetDateTime DateToOffsetDateTime(Calendar cal,ZoneOffset offset)
{

    OffsetDateTime offsetDateTime = OffsetDateTime.of(CalendarToLocalDateTime(cal), offset);
    
    return offsetDateTime;
}


public static Calendar DateToCalender(Date date) {
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	
	return calendar;
}


}