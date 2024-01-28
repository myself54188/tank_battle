package util;

import java.awt.*;

/**
 * 常量类
 */
public class Constant {
    // 游戏窗口名字
    public static final String GAME_TITLE = "坦克大战";

    // 游戏窗口大小
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;

    // 游戏菜单状态
    public static final int STATE_MENU = 0;
    public static final int STATE_HELP = 1;
    public static final int STATE_ABOUT = 2;
    public static final int STATE_RUN = 3;
    public static final int STATE_OVER = 4;

    // 游戏菜单界面文字
    public static final String[] MENUS = {
            "开始游戏",
            "继续游戏",
            "游戏帮助",
            "关于游戏",
            "退出游戏"
    };

    // 游戏菜单字体
    public static final Font GAME_FONT = new Font("宋体", Font.BOLD, 24);

    // 游戏刷新间隔
    public static final int REPAINT_INTERVAL = 3000;
}

