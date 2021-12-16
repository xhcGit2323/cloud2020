package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //Lombok中的，注解在类，生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
@AllArgsConstructor //Lombok中的，注解在类，生成包含类中所有字段的构造方法。
@NoArgsConstructor  //Lombok中的，注解在类，生成无参的构造方法。
/**
 * 通用结果集类，返回给前端（vue）
 */
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
