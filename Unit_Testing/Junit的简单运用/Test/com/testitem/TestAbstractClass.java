package com.testitem;

import com.item.abstract_.Armor;
import com.item.abstract_.Item;
import com.item.abstract_.Weapon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试物品抽象类")
public class TestAbstractClass {
    @BeforeEach
    void start() {
        System.out.println("=========测试开始========");
    }
    @AfterEach
    void end() {
        System.out.println("=========测试结束========\n");
    }

    @Test @DisplayName("测试武器")
    void testWeapon() {
        Item weapon = new Weapon("无尽之刃");
        weapon.attack();
        weapon.defense();
    }

    @Test @DisplayName("测试护甲")
    void testArmor() {
        Item armor =new Armor("父亲背心");
        armor.defense();
        armor.attack();
    }

}
