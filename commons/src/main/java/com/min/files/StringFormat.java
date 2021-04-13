package com.min.files;

/**
 * @author jxm
 * 格式化输出文档
 */
public class StringFormat {

    private static int length = 15;

    public static String formatString(String str){
        if(str == null){
            str = "";
        }
        try {
            int strLen = 0;//计算原字符串所占长度,规定中文占两个,其他占一个
            for(int i = 0 ; i<str.length(); i++){
                if(isChinese(str.charAt(i))){
                    strLen = strLen + 2;
                }else{
                    strLen = strLen + 1;
                }
            }
            if(strLen>=length){
                return str;
            }
            int remain = length - strLen;//计算所需补充空格长度
            for(int i =0 ; i< remain ;i++){
                str = str + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    // 根据Unicode编码完美的判断中文汉字和符号
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }



}
