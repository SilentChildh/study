package com.testitem;


import com.item.interface_.ImpArmor;
import com.item.interface_.ImpWeapon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试物品特性接口")
public class TestInterface {

    @BeforeEach
    void start() {
        System.out.println("=========测试开始========");
    }
    @AfterEach
    void end() {
        System.out.println("=========测试结束========\n");
    }

    @Test
    @DisplayName("测试武器")
    void testWeapon() {
        ImpWeapon weapon = new ImpWeapon("无尽之刃");
        weapon.attack();
    }

    @Test @DisplayName("测试护甲")
    void testArmor() {
        ImpArmor armor =new ImpArmor("父亲背心");
        armor.defense();
    }

}
