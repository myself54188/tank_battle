package game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static util.Constant.*;

/**
 * 窗口类
 */
public class GameFrame extends Frame implements Runnable {
    // 游戏状态，取值范围为0, 1, 2, 3, 4
    private static int gameState;
    // 菜单选择状态，取值范围为0, 1, 2, 3, 4
    private static int menuIndex;

    /**
     * 窗口初始化
     */
    public GameFrame() {
        initFrame(); // 窗口属性初始化
        initGame(); // 游戏初始化
        initEventListener(); // 窗口监听器初始化
        new Thread(this).start();
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
     * 游戏初始化
     */
    private void initGame() {
        gameState = STATE_MENU; // 初始时游戏为菜单状态
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
            // 如果选择的是和 i 一样的，就把它变为红色
            if (i == menuIndex) {
                g.setColor(Color.RED);
            }
            // 否则变为白色
            else {
                g.setColor(Color.WHITE);
            }
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
        // 绘制黑色背景
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
    }

    /**
     * 绘制 游戏结束 界面
     *
     * @param g 系统提供的画笔
     */
    private void drawOver(Graphics g) {

    }


    /**
     * 窗口事件监听初始化
     */
    private void initEventListener() {
        // 注册监听事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 添加按键监听事件
        addKeyListener(new KeyAdapter() {
            // 按键被按下的时候被回调的方法
            @Override
            public void keyPressed(KeyEvent e) {
                /*
                因为在不同的游戏状态时按键的处理也不一样，所以分别写
                 */
                int keyCode = e.getKeyCode(); // 获取摁下的键的键值

                // 根据游戏状态来设置不同按键的效果
                switch (gameState) {
                    case STATE_MENU:
                        KeyEventMenu(keyCode);
                        break;
                    case STATE_HELP:
                        KeyEventHelp(keyCode);
                        break;
                    case STATE_ABOUT:
                        KeyEventAbout(keyCode);
                        break;
                    case STATE_RUN:
                        KeyEventRun(keyCode);
                        break;
                    case STATE_OVER:
                        KeyEventOver(keyCode);
                        break;
                }
            }

            // 按键松开的时候被回调的方法
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


    /**
     * 菜单状态下的按键处理
     *
     * @param keyCode 按下按键的键值
     */
    private void KeyEventMenu(int keyCode) {
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            menuIndex = (menuIndex + MENUS.length - 1) % MENUS.length;
        }
        if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            menuIndex = (menuIndex + 1) % MENUS.length;
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            newgame();
        }
    }

    private void newgame() {
        gameState = STATE_RUN;
    }

    /**
     * 游戏帮助下的按键处理
     *
     * @param keyCode 按下按键的键值
     */
    private void KeyEventHelp(int keyCode) {
    }

    /**
     * 关于游戏的按键处理
     *
     * @param keyCode 按下按键的键值
     */
    private void KeyEventAbout(int keyCode) {
    }

    /**
     * 正在游戏时的按键处理
     *
     * @param keyCode 按下按键的键值
     */
    private void KeyEventRun(int keyCode) {

    }

    /**
     * 游戏结束时的按键处理
     *
     * @param keyCode 按下按键的键值
     */
    private void KeyEventOver(int keyCode) {
    }


    /**
     * 线程，实现每隔33ms刷新一次
     */
    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(REPAINT_INTERVAL);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
