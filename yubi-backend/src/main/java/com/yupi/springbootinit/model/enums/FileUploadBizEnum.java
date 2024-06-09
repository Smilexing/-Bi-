package com.yupi.springbootinit.model.enums;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ObjectUtils;

/**
 * 文件上传业务类型枚举
 *
  */
public enum FileUploadBizEnum {
    USER_AVATAR("用户头像", "user_avatar");
    /**
     * 中文名称（含义）
     */
    private final String text;
    /**
     * 唯一表示（定义业务）
     */
    private final String value;

    /**
     * 传入值获取对应的枚举常量
     *
     * @param value
     * @return
     */
    public static FileUploadBizEnum getEnumByValue(String value) {
        //     空值判定
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        //      获取枚举常量
        for (FileUploadBizEnum anEnum : FileUploadBizEnum.values()){
            return anEnum;
    }
    return null;
}

    /**
     * 返回所有的枚举值value(List)
     *
     * @return
     */

    public static List<String> getValues() {
        // valuse是枚举类自动继承的静态方法，返回该枚举类的所有常量的数组
        // 依照这个数组做map映射，映射逻辑为映射value上，即最终返回values（列表接受）
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());

    }

    FileUploadBizEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }

}
