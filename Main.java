package yuanhao.test.one;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String dateString = "20180301";
		int year, month, day;

		while (dateString != "\0") {
			if (dateString.length() != 8 || !StringUtil.isNumer(dateString)) {
				new Exception("日期格式不合法").printStackTrace();
			} else {
				year = Integer.parseInt(StringUtil.substring(dateString, 0, 4));
				month = Integer.parseInt(StringUtil.substring(dateString, 4, 6));
				day = Integer.parseInt(StringUtil.substring(dateString, 6, 8));

				if (DateUtil.isYearPresenced(year) && DateUtil.isMonthPresenced(month)
						&& DateUtil.isDayPresenced(year, month, day)) {

					System.out.println(year + " " + month + " " + day);
					Calendar calendar = DateUtil.setCalendar(year, month, day);
					today(calendar);
					PreDay(calendar);
				} else {
					new Exception("日期格式不合法").printStackTrace();
				}

			}
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			dateString = scanner.next();

		}
	}

	/**
	 * 当前时间
	 */
	private static void today(Calendar calendar) {
		System.out.print("当前时间:\t");
		DateUtil.printCalendar(calendar);
	}

	/**
	 * 前一天
	 */
	private static void PreDay(Calendar calendar) {
		calendar = DateUtil.PreDate(calendar);
		System.out.print("前一天:\t");
		DateUtil.printCalendar(calendar);
	}

}
