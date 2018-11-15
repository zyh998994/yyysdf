package cn.wzzm.seller.service.util;

public class JSONUtil {

    /**
     * 使用封装的Result
     *
     * @param state   状态码 0：成功 1：参数错误 2：失败
     * @param jsonobj JSON对象(可为null)
     * @return 格式化的JSON
     */
    public static String setResult(Integer state, String jsonobj) {
        String code = null;
        String message = null;
        if (state == 1) {
            message = "参数错误";
            code = "0000";
        } else if (state == 0) {
            message = "成功";
            code = "4421";
        } else if (state == 2) {
            message = "失败";
            code = "4444";
        }

        String json = "{" + "\"code\"" + ":" + "\"" + code + "\"" + "," + "\"message\"" + ":" + "\"" + message + "\"" + "," + "\"data\"" + ":" + jsonobj + "}";
        return json;
    }

    /**
     * 自定义code&message
     *
     * @param code    状态码
     * @param message 信息
     * @param jsonobj JSON对象(可为Null)
     * @return 格式化的JSON
     */
    public static String setResult(String code, String message, String jsonobj) {
        String json = "{" + "\"code\"" + ":" + "\"" + code + "\"" + "," + "\"message\"" + ":" + "\"" + message + "\"" + "," + "\"data\"" + ":" + jsonobj + "}";
        return json;
    }
}
