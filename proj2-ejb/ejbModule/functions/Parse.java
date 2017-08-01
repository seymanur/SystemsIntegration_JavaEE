package functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Parse {


    //parse to date

    public static Date parseDate(String ex)
    {
	int year, month, day, hour, minute;
	String[] split = ex.split("--");
	String first = split[0];
	String second = split[1];
	String[] date1 = first.split(" ");
	String monthSt = date1[0];
	String[] timeAux = second.split(" ");
	String time = timeAux[2];
	hour = Integer.parseInt(time.substring(0, 2));
	minute = Integer.parseInt(time.substring(2, 4));
	day = Integer.parseInt(date1[1].split(",")[0]);
	year = Integer.parseInt(date1[2]);

	Date datex = null;
	Date mydate=null;
	try {
	    datex = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(monthSt);

	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Calendar cal = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	cal.setTime(datex);
	month = cal.get(Calendar.MONTH);

	cal2.set(Calendar.MONTH, month);
	cal2.set(Calendar.DATE, day);
	cal2.set(Calendar.YEAR, year);
	cal2.set(Calendar.HOUR, hour);
	cal2.set(Calendar.MINUTE,minute);
	cal2.set(Calendar.SECOND,52);
	mydate = cal2.getTime();

	//System.err.println(month);
	System.out.println("entao : " + "month " + month + " day " + day + " year " + year);
	System.out.println("date time : " + mydate);
	System.out.println("eu quero " + new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(mydate));

	return mydate;
    }
    // parse author / journalist


    @SuppressWarnings("unused")
    private ArrayList<String> parseAuthor(String aut) {
	String author = aut.replaceFirst("By ", "");
	String[] split = author.split(", ");
	for (int i = 0; i < split.length; i++) {
	    if (split[i].contains(" and ")) {
		split[i].split(" and ");
	    }
	}
	ArrayList<String> arraylist = new ArrayList<String>(
		Arrays.asList(split));

	return arraylist;

    }


}
