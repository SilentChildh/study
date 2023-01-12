package TopViewDate.task1;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        //创建3个日期对象，一个是你的出生日期，一个是随机定义的日期，一个是今年过年的日期

        //出生日期
        Date brithDay = new Date(2003, 12, 31);
        System.out.println(brithDay.toString() + "\n=======================");

        //随机定义的日期
        for(int i = 0; i< 4; i++) {
            Random rand = new Random();
            Date randDay = new Date(rand.nextInt(5000) - 1000, rand.nextInt(30) - 10, rand.nextInt(50) - 20);
            System.out.println(randDay.toString() + "\n=======================");
        }

        //今年过年的日期
        Date newYear = new Date(2023, 1, 22);
        System.out.println(newYear.toString() + "\n=======================");

        //提供三个闰年日期和三个平年日期进行测试闰年的静态方法
        //闰年0-2, 平年3-5
        Date[] testLeapYear = {
                new Date(2000, 12, 1),
                new Date(1964, 1, 30),
                new Date(4, 10, 15),
                new Date(2001, 2, 28),
                new Date(1965, 5, 19),
                new Date(1, 9, 10)
        };
        for(int i= 0; i < 6; i++) {
            testLeapYear(testLeapYear[i].getYear());
        }

    }

    public static void testLeapYear(int year) {
        if(Date.leapYear(year)) {
            System.out.println("该年是闰年");
        }
        else {
            System.out.println("该年是平年");
        }
    }

}
