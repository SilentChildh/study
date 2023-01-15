package com.item.abstract_;

/*
* 物品名字私有化，不提供set方法
* 构造器protected修饰，令该类只对子类放开
*
* 父类要求同时重写攻击和防御方法，但有些物品不同时具备两种功能，所以会造成麻烦。
* */
public abstract class Item {
    private String name;

    protected Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    //防御和攻击方法
    public abstract void attack();
    public abstract void defense();
}

