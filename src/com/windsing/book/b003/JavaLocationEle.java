package com.windsing.book.b003;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;

/**
 * Created by fch96 on 2017/4/20.
 * 使用Java定位windows窗口元素
 * 原理：
 * windows的通信是通过“消息”使用C语言实现的，（Java的通信是使用事件机制）
 * 所以使用Java的JNI调用C库可以实现对windows窗口元素的定位。
 * 通过FindWindow()和FindWindowEX()实现对象查找
 * 通过SendMessage()方法实现对象之间的消息传送
 * 通过SendMessage()方法的WM_GETTEXT消息实现对象值的获取
 */
public class JavaLocationEle {

    // 定位windows消息的值
    private static int BM_CLICK = 0x00F5;
    private static int WM_GETTXT = 0x000D;
    private static int WM_CLOSE = 0x0010;
    private static int WM_COMMAND = 0x0111;
    private static int WM_SYSCOMMAND = 0x0112;

    static String program_name = "D:\\Programs\\Fiddler2\\Fiddler.exe";


    static void test01() throws Exception{

        Runtime runtime = Runtime.getRuntime();
        runtime.exec(program_name);

    }

    public static void main(String[] args) throws Exception{
        test01();
    }

    // 使用JNI映射Windows库
    public int findWindow(String windowClass,String windowTitle) throws Exception{
        JNative jNative = new JNative("user32.dll","FindWindowA");
        jNative.setRetVal(Type.INT);

        int i = 0;
        jNative.setParameter(i++,Type.STRING,windowClass);
        jNative.setParameter(i++,Type.STRING,windowTitle);
        jNative.invoke();
        return Integer.parseInt(jNative.getRetVal());

    }

    public int findWindowEX(int parentHandle,String controlClass,String controlCaption) throws Exception{
        JNative jNative = new JNative("user32.dll","FindWindowEXA");
        jNative.setRetVal(Type.INT);

        int i = 0;
        jNative.setParameter(i++,Type.INT,String.valueOf(parentHandle));  // 父窗口的句柄
        jNative.setParameter(i++,Type.INT,"0");
        jNative.setParameter(i++,Type.STRING,controlClass);  // 类对象控制
        jNative.setParameter(i++,Type.STRING,controlCaption); // 标题控制
        jNative.invoke();
        return Integer.parseInt(jNative.getRetVal());

    }

    public void sendMessage(int parentHandle,int message,int wparm,int lparm) throws Exception{
        JNative jNative = new JNative("user32.dll","SendMessageA");
        jNative.setRetVal(Type.INT);

        int i = 0;
        jNative.setParameter(i++,Type.INT,String.valueOf(parentHandle));  // 父窗口的句柄
        jNative.setParameter(i++,Type.INT,String.valueOf(message));
        jNative.setParameter(i++,Type.INT,String.valueOf(wparm));
        jNative.setParameter(i++,Type.INT,String.valueOf(lparm));
        jNative.invoke();
    }

    public int getMenu(int parentHandle) throws Exception{
        JNative jNative = new JNative("user32.dll","SendMessageA");
        jNative.setRetVal(Type.INT);

        return Integer.parseInt(jNative.getRetVal());

    }
}
