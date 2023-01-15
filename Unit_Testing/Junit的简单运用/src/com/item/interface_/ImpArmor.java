package com.item.interface_;

public class ImpArmor implements Defense {
    private String name;

    public ImpArmor(String name) {//向外提供创建接口
        this.name = name;
    }

    @Override
    public void defense() {
        System.out.println("防御拉满");
    }
}
