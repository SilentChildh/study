package com.hero;
/*
* 为了具体子类中尽量减少向外暴露的机会，
* 令构造器私有化，然后提供一个向外获取对象的静态方法。
* 对于技能只能向外暴露（不然放不了技能...）
* 由于父类中属性都被protected修饰，因此子类可以自由访问。
*
* 重写toString()显示英雄信息
* */
public final class Timo extends Hero{ //Timo已是具体的英雄，不能再被继承，（末日人机大魔王提莫就让他重新写个英雄把QWQ）

    private Timo(String name, int HP, int MP) {
        super(name, HP, MP);
    }

    public static Timo getTimo() {
        return new Timo("Timo", 600, 500);
    }
    //重写技能，具体实现
    @Override
    public boolean qSkill(Hero hero) {
        if(MP < 100) {
            return false;
        }
        else {
            MP -= 100;
            hero.HP -= 200;
            return true;
        }
    }

    @Override
    public String toString() {
        return  "name = " + name +
                "\tHP = " + HP +
                "\tMP = " + MP;
    }
}
