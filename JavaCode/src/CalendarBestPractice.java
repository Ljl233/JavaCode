import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarBestPractice {
    public static void main(String[] args) throws InterruptedException {

        //Calendar static method
        System.out.println("Calendar.getAvailableCalendarTypes():" + Calendar.getAvailableCalendarTypes());

        System.out.println("Calendar.getAvailableLocales():" + Arrays.toString(Calendar.getAvailableLocales()));

        Calendar calendar = Calendar.getInstance();
        System.out.println("实例化时的时间戳：" + calendar.getTimeInMillis());
        System.out.println("calendar.toString()=" + calendar.toString());

        //0：公元前  1：公元后
        System.out.println("calendar.get(Calendar.ERA):" + calendar.get(Calendar.ERA));

        System.out.println("DAY_OF_MONTH:" + calendar.get(Calendar.DAY_OF_MONTH));

        //设置时间戳，利用时间戳得到所有field的值
        calendar.setTimeInMillis(System.currentTimeMillis());
        //设置时间，该时间为系统当前时间
        calendar.setTime(new Date());

        System.out.println("HOUR_OF_DAY:" + calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        System.out.println("HOUR_OF_DAY:" + calendar.get(Calendar.HOUR_OF_DAY));

        System.out.println("calendar.getTime():" + calendar.getTime().toString());

        System.out.println("calendar.getActualMaximum(Calendar.HOUR_OF_DAY):" + calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        System.out.println("calendar.getActualMaximum(Calendar.YEAR):" + calendar.getActualMaximum(Calendar.YEAR));
        System.out.println("calendar.getLeastMaximum(Calendar.YEAR):" + calendar.getLeastMaximum(Calendar.YEAR));
        System.out.println("calendar.getLeastMaximum(Calendar.HOUR_OF_DAY):" + calendar.getLeastMaximum(Calendar.HOUR_OF_DAY));

        System.out.println("calendar.after(Calendar.getInstance()):" + calendar.after(Calendar.getInstance()));
        System.out.println("calendar.before(Calendar.getInstance()):" + calendar.before(Calendar.getInstance()));
        System.out.println("calendar.compareTo(Calendar.getInstance()):" + calendar.compareTo(Calendar.getInstance()));
        System.out.println("calendar.equals(Calendar.getInstance()):" + calendar.equals(Calendar.getInstance()));

        System.out.println(calendar.toString());
        calendar.roll(Calendar.YEAR, 10);
        System.out.println(calendar.toString());

        System.out.println("calendar.getDisplayNames(Calendar.YEAR, Calendar.LONG, Locale.CHINA):" + calendar.getDisplayNames(Calendar.YEAR, Calendar.LONG, Locale.CHINA));

        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(format(currentTimeMillis));

    }

    private static String format(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return month + "月" + day + "日 " + hour + ":" + minute;
    }
}
