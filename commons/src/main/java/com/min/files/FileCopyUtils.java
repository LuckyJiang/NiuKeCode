package com.min.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/4/2 10:59
 */
public class FileCopyUtils {

    public void runExe() {
        //1.获取指定文件地址
        String rootPath = System.getProperty("user.dir");
        System.out.println("----类所在的工程路径" + rootPath);

        //idea正确，但是jar包的时候，该路径访问不到，需要在打包的时候，将lib文件夹，拷贝到jar的根目录下
        //String targetPath = this.getClass().getResource("/lib").getPath();

        String targetPath = rootPath + "/demo1-test (2)";
        String destPath = rootPath + "/psofiles";

        //2.将某个文件拷贝到指定文件夹下
        copyFilesMethod1(targetPath, destPath);

        //3.将exe从resource/lib下拷贝到（1）中的指定位置

        //4.调用exe执行模拟运算

    }

    /**
     * 将目标文件/文件夹，拷贝到另一个新的文件夹
     * @param targetPath
     * @param destPath
     */
    private void copyFilesMethod1(String targetPath, String destPath){
        File file = new File(targetPath);
        if(file.isFile()){
            copyFileMethod1(destPath, file);
        }else{
            File[] files = file.listFiles();
            if(files.length < 1)
                return;
            for (File f:files){
                if(f.isFile()){
                    copyFileMethod1(destPath, f);
                }else{
                    String fileName = f.getName();
                    String path = destPath + "/" + fileName;
                    copyFilesMethod1(f.getPath(), path);
                }
            }
        }
    }

    /**
     * 将一个文件拷贝到指定目录下
     * @param destPath
     * @param file
     */
    private void copyFileMethod1(String destPath, File file) {
        String fileName = file.getName();
        String newPath = destPath +"/" +fileName;
        File newFile = new File(newPath);
        File newFileParent = newFile.getParentFile();
        if (!newFile.exists()) {
            // 先得到文件的上级目录，并创建上级目录，在创建文件
            newFile.getParentFile().mkdir();
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileInputStream inputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0, length);
                fileOutputStream.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
