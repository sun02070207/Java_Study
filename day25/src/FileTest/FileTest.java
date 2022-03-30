package FileTest;/*
@author Serenity
@create 2022-02-17-13:40
*/

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * File类的使用
 * 1. File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *    并未涉及到写入或读取文件内容的操作，如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4. 后续File类的对象常会作为参数传导流的构造器中，指明读取或写入的“终点”。
 */
public class FileTest {
    /*
    1.如何创建File类的实例
    public File(String pathname) 以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
    public File(String parent,String child) 以parent为父路径，child为子路径创建File对象。
    public File(File parent,String child) 根据一个父File对象和子文件路径创建File对象

    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径。

    3.路径分隔符
    windows和DOS系统默认使用“\”来表示
    UNIX和URL使用“/”来表示
    public static final String separator。根据操作系统，动态的提供分隔符。
    File.separator

     */
    @Test
    public void test(){
        //构造器1 public File(String pathname)
        File file1 = new File("hello.txt"); //相当于module
        File file2 = new File("F:\\javacode\\IDEAJava\\JavaSenior\\day25\\he.txt");
        File file3 = new File("f:" + File.separator +"javacode" + File.separator + "IDEAJava" + File.separator + "JavaSenior" + File.separator + "day25" + File.separator + "hei.txt");

        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);

        //构造器2 public File(String parent,String child)
        File file4 = new File("F:\\javacode\\IDEAJava\\JavaSenior\\day25", "File实例化");
        System.out.println(file4);


        //构造器3 public File(File parent,String child)
        File file5 = new File(file4, "helloworld.txt");
        System.out.println(file5);
    }

    @Test
    public void test1(){
        /*
         public String getAbsolutePath()：获取绝对路径
         public String getPath() ：获取路径
         public String getName() ：获取名称
         public String getParent()：获取上层文件目录路径。若无，返回null
         public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
         public long lastModified() ：获取最后一次的修改时间，毫秒值

         如下两个方法适用于文件目录
         public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
         public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
         */
        File file = new File("hello.txt"); //相对路径
        File file1 = new File("F:\\javacode\\IDEAJava\\JavaSenior\\day25\\he.txt"); //绝对路径

        System.out.println(file.getAbsoluteFile());  //F:\javacode\IDEAJava\JavaSenior\day25\hello.txt
        System.out.println(file.getPath());  //hello.txt
        System.out.println(file.getName());  //hello.txt
        System.out.println(file.getParent());  //null
        System.out.println(file.length());  //12
        System.out.println(new Date(file.lastModified()));  //Thu Feb 17 16:26:24 CST 2022
        System.out.println("*******************");
        System.out.println(file1.getAbsoluteFile()); //F:\javacode\IDEAJava\JavaSenior\day25\he.txt
        System.out.println(file1.getPath());  //F:\javacode\IDEAJava\JavaSenior\day25\he.txt
        System.out.println(file1.getName());  //he.txt
        System.out.println(file1.getParent());  //F:\javacode\IDEAJava\JavaSenior\day25
        System.out.println(file1.length()); //0
        System.out.println(file1.lastModified()); //0

        //public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
        File file2 = new File("F:\\javacode\\IDEAJava\\JavaSenior");
        String[] list = file2.list();
        for (String str:
             list) {
            System.out.println(str);
        }

//        public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
        File[] files = file2.listFiles();
        for (File f : files){
            System.out.println(f); //获取绝对路径
        }

    }

    /*
    File类的重命名功能
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如：file1.renameTo(file2)为例：
        要想保证返回true，需要file1在硬盘中是存在的，且file2不能在硬盘中存在
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\javacode\\IDEAJava\\JavaSenior\\io\\hi.txt");
        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);

    }

    /*
    File类的判断功能
    public boolean isDirectory()：判断是否是文件目录
    public boolean isFile() ：判断是否是文件
    public boolean exists() ：判断是否存在
    public boolean canRead() ：判断是否可读
    public boolean canWrite() ：判断是否可写
    public boolean isHidden() ：判断是否隐藏
     */
    @Test
    public void test3(){
        File file = new File("hello.txt");
        System.out.println(file.isDirectory()); //false
        System.out.println(file.isFile()); //true
        System.out.println(file.exists()); //true
        System.out.println(file.canRead()); //true
        System.out.println(file.canWrite()); //true
        System.out.println(file.isHidden()); //false


        System.out.println("****************");
        File file1 = new File("F:\\javacode\\IDEAJava\\JavaSenior\\io");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());


    }

    /*
    File类的创建功能
    public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
    public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
    public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建。
    注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
     */
    @Test
    public void test4(){
        File file = new File("hi.txt");
        try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建成功的案例
        File file1 = new File("F:\\javacode\\IDEAJava\\JavaSenior\\io\\io1");
        boolean mkdir = file1.mkdir();
        if (mkdir){
            System.out.println("利用mkdir()方法创建成功文件目录");
        }
        //创建失败，然后用mkdirs()方法创建成功的案例
        File file2 = new File("F:\\javacode\\IDEAJava\\JavaSenior\\io\\io2\\io流");
        boolean mkdir1 = file2.mkdir();
        if (mkdir1){
            System.out.println("利用mkdir()方法创建成功文件目录");
        }else {
            boolean mkdirs = file2.mkdirs();
            System.out.println(mkdirs);
            System.out.println("利用mkdirs()方法创建成功文件目录");
        }

    }
    /*
    File类的删除功能
    public boolean delete()：删除文件或者文件夹
    删除注意事项：Java中的删除不走回收站。 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
     */
    @Test
    public void test5(){
        File file = new File("heihei.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
                System.out.println("成功创建heihei.txt文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            boolean delete = file.delete();
            System.out.println(delete + "删除heihei.txt文件");
        }
    }

}
