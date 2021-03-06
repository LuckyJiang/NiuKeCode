package com.min.writeFileAndReadChange;

import java.awt.*;
import java.io.*;
import java.util.Arrays;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/3/1 17:33
 */
public class RunExe {

    /**
     * 不会阻塞进程的实行
     *     https://blog.csdn.net/zdavb/article/details/50791163
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /*for (int i = 0; i< 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //执行exe方案1：
//                        runExe(args);
                        //执行exe方案2：桌面打开exe的形式执行
                        Desktop.getDesktop().open(new File("E:\\Projects\\GIT\\Python\\dist\\sleep.exe"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }*/

        /**
         * 调用exe的时候，后面是否会阻塞
         */
        //调用exe的时候，后面被阻塞了
        runExe(args);
        for (int i = 0; i < 10; i++) {
            System.out.println("被exe的执行阻塞" +i);
        }


    }

    private static void runExe(String[] args)  {

        try{
            System.out.printf("Output of running %s is:", Arrays.toString(args));
            // Process process = new ProcessBuilder("E:\\Projects\\GIT\\Python\\dist\\sleep.exe").start();
            Process process = new ProcessBuilder("D:\\工作\\项目\\SimPSO\\3.案例demo\\demo\\demo1\\过程矩阵转换工具V1\\start_pmp.bat").start();
            /*InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;

//        System.out.printf("Output of running %s is:", Arrays.toString(args));

            line = br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            process.destroyForcibly();*/

            /*process.waitFor();
            process.destroyForcibly();*/
            System.out.println("nihao ");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
