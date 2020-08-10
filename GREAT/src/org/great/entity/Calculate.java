package org.great.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calculate {
	
	static int LeapYear[]= {0,31,29,31,30,31,30,31,31,30,31,30,31};
	static int UnLeapYear[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	
	//计算月龄
	public static String getMonth(String registration_time) throws ParseException {
		if (null==registration_time) {
			return "0+";
		}
		
		String str=registration_time.substring(0, registration_time.indexOf(" "));
		
		
		
		Calendar calInfo = GregorianCalendar.getInstance();
		calInfo.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str));
		int y1 = calInfo.get(Calendar.YEAR);
		int m1 = calInfo.get(Calendar.MONTH) + 1;
		int d1 = calInfo.get(Calendar.DATE);

		// 获取系统时间
		calInfo.setTime(new Date());
		int y2 = calInfo.get(Calendar.YEAR);
		int m2 = calInfo.get(Calendar.MONTH) + 1;
		int d2 = calInfo.get(Calendar.DATE);

		int age = m2 - m1;
		int yy = y2-y1;
		if (d2 < d1) {
		   age--;
		}

		if(age < 0){
		   age+=12;
		   yy --;
		}
		String agestr = "";
		if(yy*12+age>=0)
			agestr += (yy*12 + age) + "+";
		else
			agestr += "异常";
		return agestr;
	}
	
	//计算距离上次时间
	public static String getTime(String login_time) throws ParseException {
		

		
		Calendar calInfo = GregorianCalendar.getInstance();
		calInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(login_time));
		int y1 = calInfo.get(Calendar.YEAR);
		int m1 = calInfo.get(Calendar.MONTH) + 1;
		int d1 = calInfo.get(Calendar.DATE);
		int h1 = calInfo.get(Calendar.HOUR);
		int min1 = calInfo.get(Calendar.MINUTE);

		// 获取系统时间
		calInfo.setTime(new Date());
		int y2 = calInfo.get(Calendar.YEAR);
		int m2 = calInfo.get(Calendar.MONTH) + 1;
		int d2 = calInfo.get(Calendar.DATE);
		int h2 = calInfo.get(Calendar.HOUR);
		int min2 = calInfo.get(Calendar.MINUTE);
		
		String temp = "";
		
		//同一年
		if(y1==y2) {
			//同一月份
			if(m1==m2) {
				//同一天
				if (d1==d2) {
					//距离已经超过一个钟，直接显示小时
					if(h2-h1>0)
						temp+=(h2-h1)+"小时前";
					//同一个钟
					else
						temp+=(min2-min1)+"分钟前";
				}
				else //同月不同天
					temp+=(d2-d1)+"天前";
			}
			else//同年不同月
				temp += (getDays(y2, m2, d2)-getDays(y1, m1, d1))+"天前";
			
		}
		else {	//不同年	
			int t = 0;
			
			//从第一个的上一年算到 第二个的前一年
			for (int i = y1+1; i <=y2-1; i++) {
				if (isLeapYear(i)) {
					t += 366;
				}else {
					t+=365;
				}
			}
			
			t += 1+(getDays(y1, 12, 31)-getDays(y1, m1, d1));
			t += (getDays(y2, m2, d2)-getDays(y2, 1, 1));
			temp += t+"天前";
		}

		return temp;
	}
	
	//判断闰年
	public static boolean isLeapYear(int year) {
		if(year%400==0||(year%4==0&&year%100!=0))
			return true;
		else
			return false;
	}
	
	//今天是今年的第几天
	public static int getDays(int year,int month,int day) {
		int temp = 0;
		if(isLeapYear(year)) {
			
			for(int i=1;i<=month-1;i++) {
				temp+=LeapYear[i];
			}
				
		}else {
			for(int i=1;i<=month-1;i++) {
				temp+=UnLeapYear[i];
			}
		}
		
		return temp+day;
	}
}
