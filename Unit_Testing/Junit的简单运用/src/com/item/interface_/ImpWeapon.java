package com.item.interface_;

public class ImpWeapon implements Attack {
    private String name;

    public ImpWeapon(String name) {//向外提供创建接口
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("攻击拉满");
    }
}
