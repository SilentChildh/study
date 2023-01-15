package com.item.abstract_;

public class Weapon extends Item {
    public Weapon(String name) {//向外提供创建方式
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("攻击");
    }

    @Override
    public void defense() {
        System.out.println("无防御");
    }
}
