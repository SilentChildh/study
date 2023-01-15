package com.hero;
/*
* 主要用protected 修饰符来搭配 继承 的思想，
* 舍弃了set，减少向外暴露
* 利用构造器完成子类对属性的统一赋值
*
* 对于技能，主要用 抽象类和多态 的思想
* 其中利用抽象类使功能可以向外拓展，由子类具体实现。
* 多态可以接收子类的对象。
*
* */
public abstract class Hero {//抽象类，具体技能由子类继承。

    //三个属性，姓名、血量和蓝量，还需要一个技能，
    protected String name;
    protected int HP;
    protected int MP;

    //使用受保护的构造器,允许子类对属性赋值。
    protected Hero(String name, int HP, int MP) {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
    }
    //不提供set方法


    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    //技能会耗费自身蓝量，扣除敌方血量，具体子类实现
    //技能少，可以在类中声明，但也可以用接口来实现技能的释放。
    protected abstract boolean qSkill(Hero hero);
}
