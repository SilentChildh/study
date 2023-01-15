package com.hero;
/*
* 具体注释已写在Timo类中
*
* */
public final class Garen extends Hero{

    private Garen (String name, int HP, int MP) {
        super(name, HP, MP);
    }

    public static Garen getGaren() {
         return new Garen("Garen", 650, 490);
    }
    //重写技能，具体实现
    @Override
    public boolean qSkill(Hero hero) {
        if(MP < 90) {
            return false;
        }
        else {
            MP -= 90;
            hero.HP -= 160;
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
