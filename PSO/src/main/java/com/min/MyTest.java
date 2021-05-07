package com.min;

import org.apache.tomcat.util.buf.StringUtils;

import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class MyTest {

    public static void main(String[] args)  {
        Runtime rn=Runtime.getRuntime();

        try{
           /* Process process=rn.exec("C:/Users/JXM/Desktop/test/main_process_identification.exe");
            int i = process.waitFor();
            System.out.println(i);*/

//           String path = "C:/Users/JXM/Desktop/test/main_process_identification.exe";
           String path = "C:/Users/JXM/Desktop/test/start.bat";
//           String path = "C:/Users/JXM/Desktop/test/sleep.exe";
            processBuile(path);
//            startProgram(path);
//            executeCmd(path);
        }catch( Exception e ){
            System.out.println( " ERROR exec Editplus.exe " );
        }
    }

    public static void processBuile(String programPath) throws Exception {
        Process process = new ProcessBuilder(programPath).start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;


        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        int exitVal = process.waitFor();
        System.out.println("Exited with error code " + exitVal);
    }

    public static void startProgram(String programPath) throws IOException {
        System.out.println("启动应用程序：" + programPath);
        if (!programPath.equals("")) {
            try {
                Desktop.getDesktop().open(new File(programPath));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("应用程序：" + programPath + "不存在！");
            }
        }
    }

    public static String executeCmd(String command) throws IOException {
        System.out.println("Execute command : " + command);
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("cmd /c " + command);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
        String line = null;
        StringBuilder build = new StringBuilder();
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            build.append(line);
        }
        return build.toString();
    }
}
