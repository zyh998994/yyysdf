package cn.wzzm.seller.service.util;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ServiceUtil {

    /**
     * 获取字符数
     *
     * @param text
     * @return
     */
    public int getTextLength(String text) {
        int textlength = text.length();
        return textlength;
    }

    /**
     * 字数区间判断
     *
     * @param start
     * @param end
     * @param text
     * @return
     */
    public int judgeByRange(int start, int end, String text) {
        int res = 0;
        int textsize = getTextLength(text);
        if (textsize >= start && textsize <= end) {
            res = 1;
        } else {
            res = 0;
        }
        return res;
    }

    /**
     * 判断参数字符是否在给定区间之内
     */
    public int judgeTextlengthByNumber(String text, int operator, int textlength) {
        int res = 0;
        switch (operator) {
            case 1:
                if (text.length() < textlength) {
                    res = 1;
                } else {
                    res = 0;
                }
                break;
            case 2:
                if (text.length() == textlength) {
                    res = 1;
                } else {
                    res = 0;
                }
                break;
            case 3:
                if (text.length() > textlength) {
                    res = 1;
                } else {
                    res = 0;
                }
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }

    /**
     * 中文判断
     *
     * @param str
     * @return
     */
    public int judgeChinese(String str) {
        String regEx = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        int res = 0;
        if (matcher.find())
            res = 1;

        return res;
    }

    /**
     * 特殊符号判断
     *
     * @param str
     * @return
     */
    public static int judgeSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        int res = 0;
        if (m.find()) {
            res = 0;
        } else {
            res = 1;
        }
        return res;
    }


    /**
     * 加密
     *
     * @param text
     * @return
     */
    public String getEncode(String text) {
        String encode = "";
        byte[] src;
        try {
            src = text.getBytes("UTF-8");
            encode = java.util.Base64.getEncoder().encodeToString(src);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encode;
    }

    /**
     * 解密
     *
     * @param text
     * @return
     */
    public String getDiscode(String text) {
        byte[] src;
        byte[] result = null;
        try {
            src = text.getBytes("UTF-8");
            result = java.util.Base64.getDecoder().decode(src);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String s = new String(result);
        String decode = s;
        return decode;
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    public String getDateTime() {
        String datetime = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = sdf.format(new Date());
        return datetime;
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public int getTimeStamp() {
        long timestamp = System.currentTimeMillis();
        int res = (int) timestamp;
        return res;
    }

    /**
     * 生成4位随机数
     *
     * @return
     */
    public int getRandomNumber() {
        int random = (int) ((Math.random() * 9 + 1) * 1000);
        return random;
    }

    /**
     * 生成图片名称
     *
     * @return
     */
    public static String getImageName() {
        // 取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        // long millis = System.nanoTime();
        // 加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        // 如果不足三位前面补0
        String str = millis + String.format("%03d", end3);

        return str;
    }



}
