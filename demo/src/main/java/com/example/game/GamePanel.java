package com.example.game;

import org.apache.juli.logging.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;

/**
 * @author nyj
 * @date 2022/6/24
 * @ApiNote
 *
 * extends JPanel 具备页面版本功能
 */
public class GamePanel  extends JPanel {
    /**
     * 定义两个数组 存储蛇的x , y轴
     */
    int[] snakex = new int[200];
    int[] snakey = new int[200];

    /**
     * 蛇的长度
     * */
    int length;

    //游戏状态，开始，暂停
    boolean isStart = false; //默认暂停

    //加入一个定时器
    Timer timer;

    //定义蛇的行走方向
    String direction;

    //定义食物的x,y
    int foodx;
    int foody;

    /**定义一个积分*/
    int score;

    /**判断游戏是否死亡*/
    boolean isDie = false;

    /**
     * 初始化
     */
    public void init(){
        //蛇的长度
        length = 3;

        //初始化蛇头坐标
        snakex[0] = 175;
        snakey[0] = 275;
        //初始化第一节身
        snakex[1] = 150;
        snakey[1] = 275;
        //初始化第二节身
        snakex[2] = 125;
        snakey[2] = 275;

        //初始化蛇头行进的方向
        direction = "R"; // U D L R

        //初始化食物坐标
        foodx = 300;
        foody = 200;
    }

    /**
     * 构造方法
     */
    public GamePanel(){
        init();

        //将焦点定位在当前操作面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {

            /**
             * 键盘按下监听
             * @param keyEvent
             */
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                //调用键盘监听
                super.keyPressed(keyEvent);

                //获取具体按下的哪一个键盘的值
                int keyCode = keyEvent.getKeyCode();

                //判断是否等于空格
                if(keyCode == KeyEvent.VK_SPACE){
                    if(isDie){
                        //回复到初始状态
                        init();
                        isDie = false;
                    }else {

                        isStart = !isStart;
                        //面板重绘，调用paintComponent（）
                        repaint();
                    }
                }

                //判断是否等于向上箭头
                if(keyCode == KeyEvent.VK_UP){
                    direction = "U";
                }
                //判断是否等于向下箭头
                if(keyCode == KeyEvent.VK_DOWN){
                    direction = "D";
                }
                //判断是否等于向左箭头
                if(keyCode == KeyEvent.VK_LEFT){
                    direction = "L";
                }
                //判断是否等于向右箭头
                if(keyCode == KeyEvent.VK_RIGHT){
                    direction = "R";
                }

            }
        });

        //对定时器进行初始化
        timer = new Timer(100, new AbstractAction() {
            /**
             * AbstractAction 事件监听
             * 没100ms 监听一次是否发生动作
             * 具体动作放入 actionPerformed（）方法内
             * @param actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //开始状态才动
                if(isStart && isDie == false){
                    //后一节身子往前一截身子移动
                    for (int i = length-1;i>0;i--){
                        snakex[i] = snakex[i-1];
                        snakey[i] = snakey[i-1];
                    }
                    //蛇头
                    if("R".equals(direction)){
                        snakex[0] += 25;
                    }
                    if("L".equals(direction)){
                        snakex[0] -= 25;
                    }
                    if("D".equals(direction)){
                        snakey[0] += 25;
                    }
                    if("U".equals(direction)){
                        snakey[0] -= 25;
                    }

                    //防止右越界
                    if(snakex[0] > 750){
                        snakex[0] = 25;
                    }
                    //防止左越界
                    if(snakex[0] < 25){
                        snakex[0] = 750;
                    }
                    //防止上越界
                    if(snakey[0] < 100){
                        snakey[0] = 725;
                    }
                    //防止xia越界
                    if(snakey[0] > 725){
                        snakey[0] = 100;
                    }


                    /**
                     * 监测碰撞动作
                     * 食物坐标与蛇头坐标相同时发生碰撞
                     */
                    if(snakex[0] == foodx && snakey[0] == foody){
                        //蛇身加1
                        length++;

                        //食物坐标发生改变，随机生成
                        foodx = ((int)(Math.random()*30)+1)*25; //[25,750]
                        foody = (new Random().nextInt(26)+4)*25;//[100,725]

                        //积分
                        score += 10;

                    }
                    //游戏死亡判定
                    for (int i = 1;i<length;i++){
                        if(snakex[0] == snakex[i] && snakey[0] == snakey[i]){
                            //将死亡状态改为true
                            isDie = true;
                            score = 0;
                        }
                    }

                    //面板重绘，调用paintComponent（）
                    repaint();
                }
            }
        });
        //启动定时器
        timer.start();
    }


    /**
     * 图形版main方法
     * @param graphics
     *
     * 自动调用
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //背景色号
        this.setBackground(new Color(53, 114, 107));

        /**
         * 头部图
         * this 当前面板， g 画笔， x,y对应坐标
         */
        Images.headerIcon.paintIcon(this,graphics,10,10);
        //设置画笔颜色
        graphics.setColor(new Color(190, 206, 190, 255));

        //画一个矩形
        graphics.fillRect(10,70,780,685);

         //画小蛇

        //蛇头
        if("R".equals(direction)){
            Images.rightIcon.paintIcon(this,graphics, snakex[0],snakey[0]);
        }
        if("L".equals(direction)){
            Images.leftIcon.paintIcon(this,graphics, snakex[0],snakey[0]);
        }
        if("U".equals(direction)){
            Images.upIcon.paintIcon(this,graphics, snakex[0],snakey[0]);
        }
        if("D".equals(direction)){
            Images.downIcon.paintIcon(this,graphics, snakex[0],snakey[0]);
        }

 /**       //第一节身子
        Images.bodyIcon.paintIcon(this,graphics,snakex[1],snakey[1]);
        //第二节身子
        Images.bodyIcon.paintIcon(this,graphics,snakex[2],snakey[2]);
  */
        //动态添加蛇身
        for (int i = 1;i<length;i++){
            Images.bodyIcon.paintIcon(this,graphics,snakex[i],snakey[i]);
        }

        //如果游戏暂停，界面出现提示语：
        if(isStart == false){
            //画一个文字
            graphics.setColor(new Color(250, 7, 7));
            //字体，加粗，字号
            graphics.setFont(new Font("微软雅黑",Font.BOLD,40));
            //文字 x,y坐标
            graphics.drawString("点击空格开始游戏",250,330);
        }

        /**
         * 画食物
         */
        Images.foodIcon.paintIcon(this,graphics,foodx,foody);


        /**
         * 画积分
         */
        graphics.setColor(new Color(252, 251, 251, 255));
        graphics.setFont(new Font("微软雅黑",Font.BOLD,20));
        graphics.drawString("积分："+score,620,40);


        graphics.setColor(new Color(245, 245, 10, 255));
        graphics.setFont(new Font("微软雅黑",Font.BOLD,20));
        graphics.drawString("作者： 不喜欢写代码的nyj",110,40);


        /**
         * 画入死亡状态
         */
        if(isDie){
            graphics.setColor(new Color(245, 10, 10, 255));
            graphics.setFont(new Font("微软雅黑",Font.BOLD,20));
            graphics.drawString("游戏结束： 按空格重新开始",200,330);
        }


    }


}
