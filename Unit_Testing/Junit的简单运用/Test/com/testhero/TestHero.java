package com.testhero;

import com.hero.Garen;
import com.hero.Hero;
import com.hero.Timo;
import org.junit.jupiter.api.*;
/*
* void testReleaseSkill()方法中,仅是测试技能释放，关于血量为负不属于该方法的测试范围，但这也暴露一个潜在问题
*
*
*
*
*
* */
@DisplayName("英雄测试")
public class TestHero {
    @BeforeEach
    void startMethon() {
        System.out.println("==========测试开始=========");
    }
    @AfterEach
    void endMethon() {
        System.out.println("==========测试结束=========\n");
    }

    @Nested @DisplayName("测试提莫类")
    class TestTimo {
        @Test @DisplayName("创建提莫对象")
        void testCreateTimo() {
            Assertions.assertNotNull(Timo.getTimo());//无输出,可创建对象
        }

        @Test @DisplayName("显示提莫属性信息")
        void showInfo() {
            System.out.println(Timo.getTimo().toString());
        }
    }

    @Nested @DisplayName("测试盖伦类")
    class TestGaren {
        @Test @DisplayName("创建盖伦对象")
        void testCreateGaren() {
            Assertions.assertNotNull(Garen.getGaren());
        }

        @Test @DisplayName("显示盖伦信息")
        void showInfo() {
            System.out.println(Garen.getGaren().toString());
        }
    }


    @Test @DisplayName("释放技能")
    void testReleaseSkill() {
        Hero timo = Timo.getTimo();
        Hero garen = Garen.getGaren();

        int beforeTimoHP = timo.getHP(), afterTimoMP = timo.getMP();
        int beforeGarenHP = garen.getHP(), afterGarenMP = garen.getMP();

        System.out.println("开始时血量：" + "timo," + beforeTimoHP + ";garen," + beforeGarenHP);
        System.out.println("开始时蓝量：" + "timo," + afterTimoMP + ";garen," + afterGarenMP);

        int i = 1;
        while(((Timo)timo).qSkill(garen)) {
            System.out.println("提莫对盖伦释放" + i + "次技能后血量：" + "timo," + timo.getHP() + ";garen," + garen.getHP());
            System.out.println("提莫对盖伦释放" + i + "次技能后蓝量：" + "timo," + timo.getMP() + ";garen," + garen.getMP());
            i++;
            System.out.println();
        }

        System.out.println("提莫蓝量不足，无法释放技能\n-----------------");


        int j = 1;
        while(((Garen)garen).qSkill(timo)) {
            System.out.println("盖伦对提莫释放" + j + "次技能后血量：" + "timo," + timo.getHP() + ";garen," + garen.getHP());
            System.out.println("盖伦对提莫释放" + j + "次技能后蓝量：" + "timo," + timo.getMP() + ";garen," + garen.getMP());
            i++;
            System.out.println();
        }

        System.out.println("盖伦蓝量不足，无法释放技能");
    }
}
