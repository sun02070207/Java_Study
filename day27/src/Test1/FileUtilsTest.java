package Test1;/*
    @description
    @author Serenity
    @create 2022-02-23-15:02
*/

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {
    @Test
    public void test(){
        File srcFile = new File("1024节.JPG");
        File destFile = new File("1024节1.JPG");

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
