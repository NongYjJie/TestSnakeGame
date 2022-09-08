package com.example.game;

import com.example.game.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author nyj
 * @date 2022/6/24
 * @ApiNote
 */
public class StartGame {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //标题
        jFrame.setTitle("我就是我，nyj");
        //坐标，大小
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jFrame.setBounds((width-800)/2,(height-800)/2,800,800);
        //设置窗口大小不可调节
        jFrame.setResizable(false);
        //关闭窗口时关闭程序
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //创建面板
        GamePanel gamePanel = new GamePanel();
        jFrame.add(gamePanel);

        //默认隐藏窗口，设置打开
        jFrame.setVisible(true);
    }
}
