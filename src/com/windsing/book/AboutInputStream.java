package com.windsing.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 输入流，inputStream，读
 * 输出流，outputStream,写
 * 操作的对象为--字节序列--
 * 
 */
public class AboutInputStream {

    public static void main(String[] args) {
        String pathname = "";
        File file = new File(pathname);
        try {
            FileInputStream fis = new FileInputStream(file);
            /**
             * 传入的参数如果是一个文件:
             * 1、获取文件名如果文件名为空，则赋值文件名为  null
             * 2、获取安全管理器
             * 3、如果安全管理器不为空，则对文件执行读的权限检察
             *    checkRead(name)  调用  checkPermission(new FilePermission(file,SecurityConstants.FILE_READ_ACTION));
             * 4、将动作字符串转换为动作掩码  getMask(String actions)
             * 5、之后對文件进行空检察和无效的检察
             * 6、创建文件描述符　fd =　FileDescriptor()
             * 7、对创建的文件描述符（fd）用当前的流对象（this）执行附加操作  attch(this)
             * 8、attch(this)是线程安全的，如果有多个流指向当前的fd，则执行close()
             * 9、最后打开文件
             *
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis2 = new FileInputStream(pathname);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
