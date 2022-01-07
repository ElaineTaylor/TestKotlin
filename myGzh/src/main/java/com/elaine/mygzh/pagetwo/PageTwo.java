package com.elaine.mygzh.pagetwo;

/**
 * 第二章相关内容
 */

/**
 * kotlin 调用 java 的代码
 */
public class PageTwo {

    //Java的匿名内部类和kotlin的简写匿名函数
    public interface WhoCallBack {
        void draw();
    }

    public static void showWhoIsDrawer(WhoCallBack whoCallBack) {
        whoCallBack.draw();
    }

    public void test() {
        showWhoIsDrawer(new WhoCallBack() {
            @Override
            public void draw() {
                System.out.print("画家是谁谁谁");
            }
        });
    }
}
