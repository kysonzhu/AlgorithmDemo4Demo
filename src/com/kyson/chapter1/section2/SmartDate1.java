package com.kyson.chapter1.section2;

/***
 * 1.2.11 根据Date的API实现一个SmartDate类型，在日期非法时抛出一个异常。
 * 1.2.11 Develop an implementation SmartDate of our Date API that raises an
 * exception if the date is not legal.
 * 
 *
 */

public class SmartDate1 {
	
	@SuppressWarnings("unused")
	private final int year;
	@SuppressWarnings("unused")
	private final int month;
	@SuppressWarnings("unused")
	private final int day;
	
	public SmartDate1(int year,int month,int day) throws Exception {
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
		case 1:{
			if (day > 31) {
				Exception exception = new Exception(month + "月小于31号");
				throw exception;
			}
		}
			break;
		case 2:{
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
		case 11:{
			if (day > 30) {
				Exception exception = new Exception(month + "月小于30号");
				throw exception;
			}
		}
			break;
			

		default:
			break;
		}
		

		
		this.day 	= day;
		this.year 	= year;
		this.month 	= month;
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SmartDate1 date = new SmartDate1(2007, 1, 50);
	}

}
