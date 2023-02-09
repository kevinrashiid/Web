package utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Utildades {
	
	public static LocalDate convertirTextoFecha(String fecha) {
		DateTimeFormatter format=new DateTimeFormatterBuilder()
				//DateTimeFormatterBuilder es un objeto para crear otros objetos de tipo fecha 
				.appendPattern("YYYY-ww")
				.parseDefaulting(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue())
				//metodo final para crear el objeto
				.toFormatter();
		return LocalDate.parse(fecha, format);
	}
	
}