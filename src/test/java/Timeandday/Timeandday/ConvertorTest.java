package Timeandday.Timeandday;

import static org.junit.Assert.*;

import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

import org.junit.Test;





public class ConvertorTest {


	public final void datetolocaldate() throws ParseException {

		
		String sDate5 = "Wed, Jan 16 2019 23:37:50";
		SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date5 = formatter5.parse(sDate5);
		LocalDate d = Converter.datetolocaldate(date5);

		String sDate1 = "2019-01-16";
		LocalDate date = LocalDate.parse(sDate1);

		assertEquals(date, d);
	}

	@Test
	public final void dateToLocalTime() throws ParseException {
	
		Converter c = new Converter();
		String sDate5 = "Wed, Jan 16 2019 15:55:41";
		SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date5 = formatter5.parse(sDate5);
		LocalTime d = c.dateToLocalTime(date5);
		
		

		String Time="15:55:41";
		LocalTime localTime = LocalTime.parse(Time);
		//System.out.print("localTime"+localTime);
		
		assertEquals(localTime, d);
		
		

	}
	
	@Test
	public final void LocalDatetocalender() throws ParseException {
	           
		String sDate1 = "2019-01-16";
		LocalDate date = LocalDate.parse(sDate1);
		Calendar d=Converter.LocalDatetocalender(date);
		Date dd=d.getTime();
      TimeZone ddd= d.getTimeZone();
      System.out.print("localTime"+ddd);
		String sDate5 = "Wed Jan 16 00:00:00 BDT 2019";
		SimpleDateFormat formatter5 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date date5 = formatter5.parse(sDate5);
	
	
		assertEquals(dd, date5 );
		

		

	}	
	
	@Test
	public final void  localDatetodate() throws ParseException {
	

		String sDate1 = "2019-01-16";
		LocalDate date = LocalDate.parse(sDate1);
		Date d=Converter.localDatetodate(date);
	
	
		
		String sDate5 = "Wed, Jan 16 2019 00:00:00 BDT 2019";
		SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss Z yyyy");
		Date date5 = formatter5.parse(sDate5);
		
		
		
		assertEquals(date5, d);
		

	}
	

	@Test
	public final void calenderTolocalDate() throws ParseException {
	
		Calendar cal = Calendar.getInstance();
		
		//LocalDate d= Converter.calenderTolocalDate(cal.set(2019, 01, 16));
		//System.out.print("Calendar"+ cal);
		//LocalDateTime l= Converter.calenderTolocalDate(cal);
	//	System.out.print("localTime"+l);
		
		

	}
	
	@Test
	public void CalendarToZonedTime() {
		ZoneId zoneid = ZoneId.of("Asia/Dhaka");
		Calendar cal = Calendar.getInstance();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneid);
		assertEquals(zonedDateTime.getHour(), Converter.convertCalendarToZonedTime(cal, zoneid).getHour());
		assertEquals(zonedDateTime.getMinute(), Converter.convertCalendarToZonedTime(cal, zoneid).getMinute());
	}

	@Test
	public void CalendarToLocalDateTime() {
		Calendar cal = Calendar.getInstance();
		LocalDateTime d1 = LocalDateTime.now();
		
	}
	@Test
	public void DateToOffsetDateTime() {
		Calendar cal = Calendar.getInstance();
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(1, 30);
		OffsetDateTime dateTime1=OffsetDateTime.of(LocalDateTime.of(2019, 01, 12, 05, 45), ZoneOffset.ofHoursMinutes(6, 30));
		assertNotEquals(dateTime1,Converter.DateToOffsetDateTime(cal, offset));
		
	}
	
	
	@Test
	public void DateToCalender() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "01-01-2019 10:20:56";
		Date date = sdf.parse(dateInString);
		Calendar calin=Converter.DateToCalender(date);
		
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter5 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		String dateInString1 = "Tue Jan 01 10:20:56 BDT 2019";
		Date date1 = formatter5.parse(dateInString1);
		
		assertEquals(date1,calin.getTime());
	}
	

	


}
