package priv.qcy.test.one;

import java.util.Scanner;

public class Date {

	public int year = 0;
	public int month = 0;
	public int day = 0;
	public boolean flag = false;// 闰年判断值
	public boolean legal = false;// 合法性值

	/*
	 * 判断是否为闰年
	 * 
	 * 参数 year为年
	 * 
	 * 返回值是闰年则为真
	 */
	public boolean isLeapYear(int year) {
		flag = false;
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			flag = true;
		}
		return flag;
	}

	/*
	 * 根据年，月得到这个月的天数
	 * 
	 * 返回值为int类型，天数
	 */
	public int getDayByMonth(int year, int month) {

		int day = 0;
		int[] dayInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month == 2) {
			if (isLeapYear(year)) {
				day = 29;
			} else {
				day = 28;
			}
		} else {
			day = dayInMonth[month];
		}
		return day;
	}
	/*
	 * 得到前一日
	 */

	public String getLastday(String date) {

		String dateString = null;
		String str1 = date.substring(0, 4);
		String str2 = date.substring(4, 6);
		String str3 = date.substring(6, 8);
		year = Integer.parseInt(str1);
		month = Integer.parseInt(str2);
		day = Integer.parseInt(str3);
		day = day - 1;
		if (day == 0) {
			month = month - 1;
			if (month == 0) {
				year = year - 1;
			}
		}
		if (month == 0) {
			month = 12;
		}
		if (day == 0) {
			day = getDayByMonth(year, month);
		}
		dateString = year + "年" + month + "月" + day + "日";
		return dateString;

	}

	/*
	 * 判断输入合法性
	 * 
	 */
	public boolean isLegal(String str) {
		legal = false;
		if (str.length() >= 8) {
			legal = true;
			int year = 0;
			int month = 0;
			int day = 0;
			for (int i = 0; i < str.length(); i++) {
				// 拿出来判断每个字符是不是数字
				int c = str.charAt(i);
				if (c < 48 || c > 57) {
					System.out.println("输入包含除数字外其他字符，请重新输入！！");
					return false;
				}

			}
			year = Integer.parseInt(str.substring(0, 4));
			month = Integer.parseInt(str.substring(4, 6));
			day = Integer.parseInt(str.substring(6, 8));

			if (year < 1000 || year > 2019) {
				legal = false;

				System.out.println("输入不合法，年份越界！！");
			}
			if (month < 1 || month > 12) {
				legal = false;
				System.out.println("输入不合法，月越界！！");

			}
			if (day < 1 || day > 31) {
				legal = false;
				System.out.println("输入不合法，日越界！！");

			}
			if (month == 2) {

				if (day == 29 && !isLeapYear(year)) {

					legal = false;
					System.out.println("平年2月没有29日");

				}
				if (day == 30 || day == 31) {

					legal = false;
					System.out.println("2月没有这个日期！");

				}

			}

		} else {
			System.out.println("请输入完整年月日");

		}
		return legal;

	}

	public static void main(String[] args) {

		Date date = new Date();
		Scanner scanner = new Scanner(System.in);
		String datestr;
		while (true) {
			System.out.println("请输入：");
			datestr = scanner.nextLine();
			if (date.isLegal(datestr)) {
				System.out.println("前一天" + date.getLastday(datestr));
			}
		}

	}

}
