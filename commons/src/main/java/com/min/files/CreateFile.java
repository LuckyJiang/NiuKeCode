package com.min.files;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/4/13 17:55
 */
public class CreateFile {

    private static void createOneFile() {

        File streamFile = new File("C:\\Users\\pc-fl\\Desktop\\SimPSO\\mytest.txt");    //物流矩阵

        if (!streamFile.exists()) {
            try {
                streamFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        try (FileOutputStream streamWriterStream = new FileOutputStream(streamFile);
        ) {
            BufferedWriter streamBufferedWriter = new BufferedWriter(new OutputStreamWriter(streamWriterStream, "UTF-8"));

            for (int i = 0; i < 100; i++) {
                streamBufferedWriter.write(StringFormat.formatString(Integer.toString(i)) + "\t");
                if(i%10 == 0){
                    streamBufferedWriter.newLine();
                    streamBufferedWriter.flush();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        createOneFile();
    }
}
