package com.examples;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class Eg10NewDateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate d = LocalDate.now();
		System.out.println(d.toString()+" , "+d.getDayOfMonth()+" , "+d.getMonth()+" , "+d.getYear());
		
		d = LocalDate.of(2015,6, 2);
		System.out.println(d.toString());
		
		d = LocalDate.parse("2018-06-02").minus(1,ChronoUnit.MONTHS);
		System.out.println(d.toString());
		
		System.out.println(d.isAfter(LocalDate.parse("2018-05-01")));
		
		LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
		System.out.println(beginningOfDay);
		LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
		  .with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDayOfMonth);
		
		//working with zone
		
		Set<String> allZoneId = ZoneId.getAvailableZoneIds();
		allZoneId.forEach(e->{
			ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(e));
			System.out.println(zdt.toString());
		});
		
		ZoneOffset offset = ZoneOffset.of("+02:00");
		 
		OffsetDateTime offSetByTwo = OffsetDateTime
		  .of(LocalDateTime.now(), offset);
		
		System.out.println(offSetByTwo);
		
		//working with period and duration
		LocalDate initialDate = LocalDate.parse("2007-05-10");
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));
		
		int five = Period.between(initialDate, finalDate).getDays();
		System.out.println(finalDate);
		System.out.println(five);
		
		LocalTime initialTime = LocalTime.of(6, 30, 0);
		 
		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
		
		long thirty = Duration.between(initialTime, finalTime).getSeconds();
		System.out.println(thirty);
		
		//working with formatters
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse("03/10/1993",dtf);
		System.out.println(ld);
	} 

}

/*   
Order of the basic components:
B – big-endian (year, month, day), e.g. 1996-04-22 or 1996.04.22 or 1996/04/22
L – little-endian (day, month, year), e.g. 22.04.1996 or 22/04/1996 or 22-04-1996 or 22 April 1996
M – middle-endian (month, day, year), e.g. 04/22/1996 or April 22, 1996
Specific formats for the basic components:

yy – two-digit year, e.g. 96
yyyy – four-digit year, e.g. 1996
M – one-digit month for months below 10, e.g. 4
MM – two-digit month, e.g. 04
MMM – three-letter abbreviation for month, e.g. Apr
MMMM – month spelled out in full, e.g. April
d – one-digit day of the month for days below 10, e.g. 2
dd – two-digit day of the month, e.g. 02
"ddd" - three-letter abbreviation for day of the week, e.g. Tue
"dddd" - day of the week spelled out in full, e.g. Tuesday
Separators of the components:

"/" – stroke (slash)
"." – dots or full stops/points (periods)
"-" – hyphens or dashes
" " – spaces

References - https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
http://www.baeldung.com/java-8-date-time-intro
*/