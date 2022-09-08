package com.example.game;

import javax.swing.*;
import java.net.URL;

/**
 * @author nyj
 * @date 2022/6/24
 * @ApiNote
 */
public class Images {

   public static URL headerurl = Images.class.getResource("/static/images/header.jpg");
   public static ImageIcon headerIcon = new ImageIcon(headerurl);

   public static URL bodyurl = Images.class.getResource("/static/images/body.jpg");
   public static ImageIcon bodyIcon = new ImageIcon(bodyurl);

   public static URL righturl = Images.class.getResource("/static/images/right.jpg");
   public static ImageIcon rightIcon = new ImageIcon(righturl);

   public static URL leftturl = Images.class.getResource("/static/images/left.jpg");
   public static ImageIcon leftIcon = new ImageIcon(leftturl);

   public static URL downurl = Images.class.getResource("/static/images/down.jpg");
   public static ImageIcon downIcon = new ImageIcon(downurl);

   public static URL upturl = Images.class.getResource("/static/images/up.jpg");
   public static ImageIcon upIcon = new ImageIcon(upturl);

   public static URL foodurl = Images.class.getResource("/static/images/food.jpg");
   public static ImageIcon foodIcon = new ImageIcon(foodurl);
}
