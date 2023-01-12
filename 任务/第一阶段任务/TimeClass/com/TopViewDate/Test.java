package TopViewDate;

import java.util.Random;
/*
* 测试校对相差天数利用了https://www.beijing-time.org/riqi.htm
*
* */
public class Test {

    public static void main(String[] args) {
        /*
            任务一：设计一个日期类
                子任务1：测试时间类属性
                子任务2：测试闰年的静态方法
        */
        //子任务1：测试时间类属性
        //testField();

        //子任务2：测试闰年的静态方法
        //testLeapYear();

        /*
            任务二：拓展任务一的日期类的功能
                子任务1：查看两个TopViewDate的间隔天数
                子任务2：查看两个TopViewDate的间隔年数、间隔月数
        */
        //子任务1：查看两个TopViewDate的间隔天数
        testIntervalDay();

        //子任务2：查看两个TopViewDate的间隔年数、间隔月数
        testIntervalY_M();

    }
    public static void testField() {
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
    }
    public static void testLeapYear() {
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
            if(Date.leapYear(testLeapYear[i].getYear())) {
                System.out.println("该年是闰年");
            }
            else {
                System.out.println("该年是平年");
            }
        }
    }

    public static void testIntervalDay() {
        //创建两个不同日期的TopViewDate对象，进行调用方法查看间隔天数进行展示

        //创建两个不同日期的TopViewDate对象
        Date test1 = new Date(2000, 9, 10);
        Date test2 = new Date(2023, 10, 10);

        //进行调用方法查看间隔天数进行展示
        System.out.println("test1 与 test2 相差 " + Date.intervalDay(test1, test2) + " 天");
    }

    public static void testIntervalY_M() {
        //创建两个不同日期的TopViewDate对象，进行调用方法查看间隔年数、间隔月数进行展示

        /*
            测试间隔年份：
                测试1：年份相同；√
                测试2：前者<后者；√
                测试3：前者>后者。√

            测试间隔月份：
                测试1：年份相同：
                    1）：前者==后者；√
                    2）：前者<后者；√
                    3）：前者>后者。√
                测试2：年份：前者<后者相同：
                    1）：前者==后者；√
                    2）：前者<后者；√
                    3）：前者>后者。√
                测试3：年份：前者>后者：
                    1）：前者==后者；√
                    2）：前者<后者；√
                    3）：前者>后者。√

        */
        //创建两个不同日期的TopViewDate对象
        Date test1 = new Date(2022, 3, 10);
        Date test2 = new Date(2022, 3, 12);

        //进行调用方法查看间隔年数、间隔月数进行展示
        System.out.println("test1 与 test2 相差 " + Date.intervalMonth(test1, test2) + " 月");
        System.out.println("test1 与 test2 相差 " + Date.intervalYear(test1, test2) + " 年");
    }
}
