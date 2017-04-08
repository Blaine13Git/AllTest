package com.windsing.book;

import java.io.*;

/*
 * 输入流，inputStream，读
 * 输出流，outputStream,写
 * 操作的对象为--字节序列--
 * 
 */
public class AboutInputStream {

    public static void main(String[] args) {
        String pathname = "./source/my_img.jpg";
        File file = new File(pathname);
        file.getAbsolutePath();
        System.out.println(file.getAbsolutePath());
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            /**
             * 传入的参数如果是一个文件:
             * 1、获取文件名如果文件名为空，则赋值文件名为  null
             * 2、获取安全管理器
             * 3、如果安全管理器不为空，则对文件执行读的权限检察
             *    checkRead(name)  调用  checkPermission(new FilePermission(file,SecurityConstants.FILE_READ_ACTION));
             * 4、将动作字符串转换为动作掩码  getMask(String actions)，READ的16进制掩码是0x4
             * 5、之后對文件进行空检察和无效的检察
             * 6、创建文件描述符　fd =　FileDescriptor()
             * 7、对创建的文件描述符（fd）用当前的流对象（this）执行附加操作  attch(this)
             * 8、attch(this)是线程安全的，如果有多个流指向当前的fd，则执行close()
             * 9、最后打开文件
             **/
            int content = fis.read(); //读取第一个字节，如果返回-1.说明读到结尾了。
            System.out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        try {
//            FileInputStream fis2 = new FileInputStream(pathname);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }

}
