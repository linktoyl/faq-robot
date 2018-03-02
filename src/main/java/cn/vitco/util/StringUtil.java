package cn.vitco.util;

import java.util.UUID;

/**
 * Created by Sterling on 2018/2/5.
 */
public class StringUtil {

    /**
     * 检测字符串是否不为空(null,"","null")
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s){
        return s!=null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 检测字符串是否为空(null,"","null")
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s){
        return s==null || "".equals(s) || "null".equals(s);
    }


    /**
     * 生成UUID
     *
     * @return
     */
    public static String genUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取文件后缀格式
     *
     * @param fullName
     * @return
     */
    public static String getExtendedName(String fullName) {

        // String fileEnd =
        // fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();

        if (fullName != null) {
            String[] arr = fullName.split("\\.");
            return arr[arr.length - 1];
        }
        return null;
    }



}
