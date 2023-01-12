package TopViewDate.task1;

public class Date {
    //相关属性，年，月，日
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        setYear(year);
        if(this.year == 0) return;//输入年份错误出构造失败

        setMonth(month);
        if(this.month == 0) return;//输入月份错误出构造失败

        setDay(day);
        if(this.day == 0) return;//输入天数错误出构造失败

    }


    /*
        一、利用get()方法使得单个属性可以进行单独获取
        二、利用set()方法设置月份month必须是1—12之间的数
        三、1、3、5、7、8、10、12月份为“大月”，有31天；
            4、6、9、11为“小月”，只有30天；
            如果year被4整除且不能被100整除、或者year被400整除，为闰年；
            闰年2月份为29天，其余年份2月份为28天。
    */
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year > 0) this.year = year;
        else System.out.println("输入年份错误");
    }

    public int getMonth() {
        return month;
    }


    public void setMonth(int month) {
        if(month <= 12 && month >= 1) this.month = month;
        else System.out.println("输入月份错误");
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {//小月
            if(day <= 30 && day >= 1) {
                this.day = day;
                //System.out.println("该月是小月");
            }
            else {
                System.out.println("输入日期错误");
            }
        }
        else if(this.month == 2) {
            if(this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0) {//闰年
                if(day <= 29 && day >= 1) {
                    this.day = day;
                    //System.out.println("该年是闰年");
                }
                else {
                    System.out.println("输入日期错误");
                }
            }
            else {
                if(day <= 28 && day >= 1) {
                    this.day = day;
                    //System.out.println("该年是平年");
                }
                else {
                    System.out.println("输入日期错误");
                }
            }
        }
        else {//大月
            if(day <= 31 && day >= 1) {
                this.day = day;
                //System.out.println("该月是大月");
            }
            else {
                System.out.println("输入日期错误");
            }
        }
    }

    //输出日期信息
    @Override
    public String toString() {
        return "Date{" + year + '-' + month + '-' + day + '}';
    }

    public static boolean leapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {//闰年
            return true;
        }
        else {
            return false;
        }
    }

    public static int dayNumber(int year, int month) {//判断当月的天数

        if(month == 4 || month == 6 || month == 9 || month == 11) {//小月
            return 30;
        }
        else if(month == 2){
            if(leapYear(year)) {
                return 29;
            }
            else return 28;
        }
        else {//大月
            return 31;
        }
    }
    public static int intervalDay(Date a, Date b) {

        //获取a，b是在对应年月的第几天
        int aDay = a.day, bDay = b.day;
        for(int i = 1; i < a.month; i++) {
            aDay += dayNumber(a.year, i);
        }
        for(int i = 1; i < b.month; i++) {
            bDay += dayNumber(b.year, i);
        }

        if(a.year == b.year) return Math.abs(aDay - bDay);
        else {
            int sum = 0;//计算相差年份之间的天数

            //判断先后顺序
            int preYear, lastYear, preDay, lastDay;
            if (a.year < b.year) {
                preYear = a.year;
                preDay = aDay;//对应年份的天数

                lastYear = b.year;
                lastDay = bDay;//对应年份的天数
            }
            else {
                preYear = b.year;
                preDay = bDay;//对应年份的天数

                lastYear = a.year;
                lastDay = aDay;//对应年份的天数
            }

            for (int i = preYear; i < lastYear; i++) {
                if (leapYear(i)) {
                    sum += 366;
                }
                else sum += 365;
            }

            return sum + lastDay - preDay;
        }
    }

    public static int intervalMonth(Date a, Date b) {

        //Math.abs(a.month - b.month)可替换为intervalYear(a, b)
        if(a.year == b.year) {
            return Math.abs(a.month - b.month);
        }
        else if(a.year < b.year) {//b + (12 - a)
            return (Math.abs(a.year - b.year) - 1) * 12 + (12 - a.month) + b.month;
        }
        else {//a + (12 - b)
            return (Math.abs(a.year - b.year) - 1) * 12 + (12 - b.month) + a.month;
        }
    }

    public static int intervalYear(Date a, Date b) {
        return Math.abs(a.year - b.year);
    }
}
