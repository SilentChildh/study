package com.item.abstract_;

public class Armor extends Item {

    public Armor(String name) {//向外提供创建方式
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("无攻击");
    }

    @Override
    public void defense() {
        System.out.println("防御");
    }
}
