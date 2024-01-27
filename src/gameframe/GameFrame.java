package gameframe;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import static util.Constant.*;

/**
 * 窗口类
 */
public class GameFrame extends Frame {
    // 游戏状态，取值范围为0, 1, 2, 3, 4
    private static int gameState;

    /**
     * 窗口初始化
     */
    public GameFrame() {
        initFrame(); // 窗口属性初始化
        initEventListener(); // 窗口监听器初始化
        initGame(); // 游戏初始化
    }

    /**
     * 窗口属性初始化
     */
    private void initFrame() {
        // 设置窗口左上角标题
        setTitle(GAME_TITLE);
        // 设置窗口大小
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        // 设置窗口居中
        setLocationRelativeTo(null);
        // 设置窗口可见
        setVisible(true);
        // 设置窗口大小不可变
        setResizable(false);
    }

    /**
     * 窗口事件监听初始化
     */
    private void initEventListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 游戏初始化
     */
    private void initGame() {
        gameState = 0; // 初始时游戏为菜单状态
        repaint(); // 绘制图片
    }

    /**
     * updata 是 Frame 类的方法，继承下来的方法
     * 该方法负责所有的绘制的内容，所有需要在屏幕上显示的的内容都要在该方法中调用
     * 该方法不能主动调用，必须通过调用 repaint() 来回调该方法。
     *
     * @param g 系统提供的画笔
     */
    public void update(Graphics g) {
        g.setFont(GAME_FONT);
        switch (gameState) {
            case STATE_MENU:
                drawMenu(g);
                break;
            case STATE_HELP:
                drawHelp(g);
                break;
            case STATE_ABOUT:
                drawAbout(g);
                break;
            case STATE_RUN:
                drawRun(g);
                break;
            case STATE_OVER:
                drawOver(g);
                break;
        }
    }

    /**
     * 绘制菜单界面
     *
     * @param g 系统提供的画笔
     */
    private void drawMenu(Graphics g) {
        // 绘制黑色背景
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        final int STR_WIDTH = 120; // 文字长度
        int x = (FRAME_WIDTH - STR_WIDTH) / 2; // x坐标
        int y = FRAME_HEIGHT / 3; // y 坐标
        final int DIS = 40; // 行间距

        g.setColor(Color.WHITE);
        for (int i = 0; i < MENUS.length; i++) {
            g.drawString(MENUS[i], x, y + DIS * i);
        }
    }

    /**
     * 绘制 帮助 界面
     *
     * @param g 系统提供的画笔
     */
    private void drawHelp(Graphics g) {

    }

    /**
     * 绘制 "关于游戏" 界面
     *
     * @param g 系统提供的画笔
     */
    private void drawAbout(Graphics g) {

    }

    /**
     * 绘制 游戏正在运行的 界面
     *
     * @param g 系统提供的画笔
     */
    private void drawRun(Graphics g) {

    }

    /**
     * 绘制 游戏结束 界面
     *
     * @param g 系统提供的画笔
     */
    private void drawOver(Graphics g) {

    }
}
