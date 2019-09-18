package yuanhao.test.one;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	/**
	 * 如果日期不合法 则抛异常, 并返回 false
	 * 
	 * @param date_str
	 * @return
	 */
	public static boolean islegal(String date_str) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			format.setLenient(false);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("日期不合法");
			return false;
		}
		return true;
	}

	/**
	 * 设置时间
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static Calendar setCalendar(int year, int month, int date) {
		Calendar cl = Calendar.getInstance();
		cl.set(year, month - 1, date);
		return cl;
	}

	/**
	 * 获取当前时间的前一天时间
	 * 
	 * @param cl
	 * @return
	 */
	public static Calendar PreDate(Calendar cl) {
		Calendar calendar;
		int day = cl.get(Calendar.DATE);
		int month = cl.get(Calendar.MONTH) + 1;
		int year = cl.get(Calendar.YEAR);
		if (day != 1) {
			day--;
			calendar = DateUtil.setCalendar(year, month, day);
		} else if (month != 1) {
			month--;
			day = getLocalMonth(year, month);
			calendar = DateUtil.setCalendar(year, month, day);
		} else {
			calendar = DateUtil.setCalendar(year - 1, 12, 31);
		}
		return calendar;
	}

	private static int getLocalMonth(int year, int month) {
		int Feb = 28;
		// 判断闰年
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			Feb = 29;
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 2) {
			return Feb;
		} else {
			return 30;
		}
	}

	/**
	 * 打印时间
	 * 
	 * @param cl
	 */
	public static void printCalendar(Calendar cl) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(cl.getTime()));
	}

	/**
	 * 判断年份合法
	 */
	public static boolean isYearPresenced(int year) {
		if (year >= 1000 && year <= 2019) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断年份合法
	 */
	public static boolean isMonthPresenced(int month) {
		if (month > 0 && month < 13) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断年份合法
	 */
	public static boolean isDayPresenced(int year, int month, int day) {
		int maxdays;
		int Feb = 28;
		// 判断闰年
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			Feb = 29;
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			maxdays = 31;
		} else if (month == 2) {
			maxdays = Feb;
		} else {
			maxdays = 30;
		}
		if (day > 0 && day < (maxdays + 1)) {
			return true;
		} else {
			return false;
		}
	}

}