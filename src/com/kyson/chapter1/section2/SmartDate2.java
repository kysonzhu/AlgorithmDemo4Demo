package com.kyson.chapter1.section2;

/****
 * 
 * 1.2.12为SmartDate添加一个方法dayOfTheWeek()，为日期中每周的日返回Monday、Tuesday、Wednesday、
 * Thursday……假定是21世纪 
 * 1.2.12 Add a method dayOfTheWeek() to SmartDate that
 * returns a String value Monday, Tuesday, Wednesday, Thursday, Friday,
 * Saturday, or Sunday, giving the appropriate day of the week for the date.
 * You may assume that the date is in the 21st century.
 */
public class SmartDate2 {

	@SuppressWarnings("unused")
	private final int year;
	@SuppressWarnings("unused")
	private final int month;
	@SuppressWarnings("unused")
	private final int day;
	
	private static final int YEARFIRSTTWO = 20;
	private static final int DAYPERWEEK = 7;

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
	
	public String dayOfTheWeek(){
		String resultWeek = "";
		int tempMonth = this.month;
		int tempYear = this.year;
		int tempDay = this.day;
		if (this.month == 1 || this.month == 2) {
			tempMonth += 12;
			tempYear --;
		}
		
		int y = tempYear - YEARFIRSTTWO * 100;
		int floor1 = (int) Math.floor(y/4);
		int floor2 = (int) (YEARFIRSTTWO / 4);
		int floor3 = (int) Math.floor(26 * (tempMonth+1)/10);
		
		int w = y + floor1 + floor2 -2 * YEARFIRSTTWO + floor3 + tempDay - 1;
		int key = w % DAYPERWEEK;
		
		if (key <0) {
			key = key + 7;
		}
		
		
		switch (key) {
		case 0:
			resultWeek = "星期日";
			break;
		case 1:
			resultWeek = "星期一";
			break;
		case 2:
			resultWeek = "星期二";
			break;
		case 3:
			resultWeek = "星期三";
			break;
		case 4:
			resultWeek = "星期四";
			break;
		case 5:
			resultWeek = "星期五";
			break;
		case 6:
			resultWeek = "星期六";
			break;

		default:
			break;
		}
		
		return resultWeek;
	}
	
	public String toString(){
		
		return ""+ month + "/" + day + "/" + year;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SmartDate2 date = new SmartDate2(2017, 10, 5);
		String week = date.dayOfTheWeek();
		System.out.println( date + " is :" + week);
	}

}
