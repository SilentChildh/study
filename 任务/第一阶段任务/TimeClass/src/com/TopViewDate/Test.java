package com.TopViewDate;

import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        //创建3个日期对象，一个是你的出生日期，一个是随机定义的日期，一个是今年过年的日期

        //出生日期
        Date brithDay = new Date(0, 12, 31);
        System.out.println(brithDay.toString() + "\n=======================");

        //随机定义的日期
        for(int i = 0; i< 4; i++) {
            Random rand = new Random();
            Date randDay = new Date(rand.nextInt(5000) - 1000, rand.nextInt(30) - 10, rand.nextInt(50) - 20);
            System.out.println(randDay.toString() + "\n=======================");
        }

        //今年过年的日期
    }

}
