package com.kyson.chapter1.section2;

/****
 * 
 * 1.2.12为SmartDate添加一个方法dayOfTheWeek()，为日期中每周的日返回Monday、Tuesday、Wednesday、
 * Thursday……假定是21世纪 
 * 1.2.12 Add a method dayOfTheWeek() to SmartDate that
 * returns a String value Monday, Tuesday, Wednesday, Thursday, Friday,
 * Saturday, or Sunday, giving the ap- propriate day of the week for the date.
 * You may assume that the date is in the 21st century.
 */
public class SmartDate2 {

	@SuppressWarnings("unused")
	private final int year;
	@SuppressWarnings("unused")
	private final int month;
	@SuppressWarnings("unused")
	private final int day;

	public SmartDate2(int year, int month, int day) throws Exception {
		if (year < 0 || month < 0 || day < 0) {
			Exception exception = new Exception("年月日要大于0");
			throw exception;
		}
		if (month > 12) {
			Exception exception = new Exception("年份要小于等于12");
			throw exception;
		}

		switch (month) {
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
		case 1: {
			if (day > 31) {
				Exception exception = new Exception(month + "月小于31号");
				throw exception;
			}
		}
			break;
		case 2: {
			if (day > 29) {
				Exception exception = new Exception(month + "月小于31号");
				throw exception;
			}

			int leapYear = year % 4;
			if (leapYear != 0) {
				if (day > 28) {
					Exception exception = new Exception(month + "月小于29号");
					throw exception;
				}
			}

		}
			break;
		case 4:
		case 6:
		case 9:
		case 11: {
			if (day > 30) {
				Exception exception = new Exception(month + "月小于30号");
				throw exception;
			}
		}
			break;

		default:
			break;
		}

		this.day = day;
		this.year = year;
		this.month = month;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SmartDate2 date = new SmartDate2(2007, 1, 50);
	}

}
