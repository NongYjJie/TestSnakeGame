package com.example.game;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nyj
 * @date 2022/7/4
 * @ApiNote
 */
public class A {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         *  9 * 9口訣

        for(int i=1;i<10;i++)//定义一个外循环  外循环对每行下一个元素的值进行控制
        {
            for(int j=1;j<10;j++)//定义一个内循环  内循环对没列下一个元素的值进行控制
            {
                System.out.print(i*j+"  ");//打印输出乘运算的值，但是不换行
            }
            System.out.println();//每次一行的运算结束的换行控制
        }*/


        /**
         * 冒泡排序
         */
        //装载临时变量
        int temp;

        //记录是否发生了置换， 0 表示没有发生置换、  1 表示发生了置换
        int isChange;
        int num = 0;

        int[] arrys =  {12,11,10,9,8,7,6,5,4,3,2,1,0};
        //外层循环是排序的趟数
        for (int i = 0; i < arrys.length-1; i++) {
            //每比较一趟就重新初始化为0
            isChange = 0;
            //内层循环是当前趟数需要比较的次数
            for (int j = 0; j < arrys.length-i-1 ; j++) {

                //前一位与后一位与前一位比较，如果前一位比后一位要大，那么交换
                if (arrys[j] > arrys[j + 1]) {
                    temp = arrys[j];
                    arrys[j] = arrys[j + 1];
                    arrys[j + 1] = temp;
                    //如果进到这里面了，说明发生置换了
                    isChange = 1;
                }

            }
            //如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了
            if (isChange == 0) {
                break;
            }
            num++;
        }
        for (int arry : arrys) {
            System.out.println(arry);
        }

      //  System.out.println(num);



/*        String s = new String("abc");
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s,"avcd".toCharArray());

        System.out.println(s);*/

    }


}
