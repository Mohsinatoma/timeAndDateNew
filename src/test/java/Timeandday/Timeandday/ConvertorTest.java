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
		
		String sDate1 = "2019-01-16";


		assertEquals(LocalDate.parse(sDate1), Converter.datetolocaldate(formatter5.parse(sDate5)));
	}

	@Test
	public final void dateToLocalTime() throws ParseException {
	
		Converter c = new Converter();
		String sDate5 = "Wed, Jan 16 2019 15:55:41";
		SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		

		String Time="15:55:41";
		assertEquals(LocalTime.parse(Time), c.dateToLocalTime(formatter5.parse(sDate5)));
		
		

	}
	
	@Test
	public final void LocalDatetocalender() throws ParseException {
	           
		String sDate1 = "2019-01-16";
		LocalDate date = LocalDate.parse(sDate1);
		
      
		String sDate5 = "Wed Jan 16 00:00:00 BDT 2019";
		SimpleDateFormat formatter5 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		
	
	
		assertEquals(formatter5.parse(sDate5),Converter.LocalDatetocalender(date).getTime() );
		

		

	}	
	
	@Test
	public final void  localDatetodate() throws ParseException {
	

		String sDate1 = "2019-01-16";
	
	
		
		String sDate5 = "Wed, Jan 16 2019 00:00:00 BDT 2019";
		SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss Z yyyy");

		
		
		
		assertEquals(formatter5.parse(sDate5), Converter.localDatetodate(LocalDate.parse(sDate1)));
		

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
		cal.set(2019,Calendar.JANUARY, 1);
		assertEquals(LocalDate.of(2019, 1, 1), Converter.calendarToLocalDate(cal));
	}
	@Test
	public void DateToOffsetDateTime() {

		assertNotEquals(OffsetDateTime.of(LocalDateTime.of(2019, 01, 12, 05, 45), ZoneOffset.ofHoursMinutes(6, 30)),Converter.DateToOffsetDateTime( Calendar.getInstance(), ZoneOffset.ofHoursMinutes(1, 30)));
		
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
	
		
		assertEquals(formatter5.parse(dateInString1),calin.getTime());
	}
	

	@Test
	public void testConvertCalendarToLocalTime() {

		assertEquals(LocalTime.now().getHour(), Converter.calendarToLocalTime(Calendar.getInstance()).getHour());
		assertEquals(LocalTime.now().getMinute(), Converter.calendarToLocalTime(Calendar.getInstance()).getMinute());
	}


}
