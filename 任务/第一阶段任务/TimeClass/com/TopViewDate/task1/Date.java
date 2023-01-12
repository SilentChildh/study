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
            if(this.year % 4 == 0 || this.year % 400 == 0) {//闰年
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
        if(year % 4 == 0 || year % 400 == 0) {//闰年
            return true;
        }
        else {
            return false;
        }
    }

    public static int intervalDay(Date a, Date b) {


        return 0;
    }

    public static int intervalMonth(Date a, Date b) {

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
