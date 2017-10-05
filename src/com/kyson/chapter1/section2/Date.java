package com.kyson.chapter1.section2;

public class Date {

	@SuppressWarnings("unused")
	private final int year;
	@SuppressWarnings("unused")
	private final int month;
	@SuppressWarnings("unused")
	private final int day;
	
	private final int yearFirstTwo;
	private static final int DAYPERWEEK = 7;

	public Date(int year, int month, int day) throws Exception {
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
				Exception exception = new Exception(month + "月小于29号");
				throw exception;
			}

			boolean leapYear = this.isLeapYear(year);
			if (leapYear) {
				if (day > 28) {
					Exception exception = new Exception(month + "月小于28号");
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
		
		yearFirstTwo = year / 100;
	}
	
	/**
	 * 判断是否为闰年
	 * @param year
	 * @return
	 */
	private boolean isLeapYear(int year)  
    {
        if(year%100!=0&&year%4==0)
            return true;
        else if(year%100==0&&year%400==0)
            return true;
        else
            return false;
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
		
		int y = tempYear - yearFirstTwo * 100;
		int floor1 = (int) Math.floor(y/4);
		int floor2 = (int) (yearFirstTwo / 4);
		int floor3 = (int) Math.floor(26 * (tempMonth+1)/10);
		
		int w = y + floor1 + floor2 -2 * yearFirstTwo + floor3 + tempDay - 1;
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
	
	public boolean equals(Object that){
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		
		Date xDate = (Date)that;

		if (this.year != xDate.year) return false;
		if (this.month != xDate.month) return false;
		if (this.day != xDate.day) return false;
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date(1996, 12, 5);
		String week = date.dayOfTheWeek();
		System.out.println( date + " is :" + week);
	}
	

}
