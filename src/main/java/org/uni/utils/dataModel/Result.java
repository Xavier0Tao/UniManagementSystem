package org.uni.utils.dataModel;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result(Object data) {
        this.code = 1;
        this.msg = "成功";
        this.data = data;
    }

    public Result(boolean flag) {
        this.code = flag? 1:0;
        this.msg = code == 1 ? "成功" : "失败";
    }

    public Result(boolean flag, String msg) {
        this.code = flag ? 1 : 0;
        this.msg = msg;
    }

    public Result(String msg) {
        this.code = 1;
        this.msg = msg;
    }

    public Result(Throwable e) {
        this.code = 0;
        this.msg = e.getMessage();
        System.out.println("*****************返回出错************************");
        e.printStackTrace();
    }

    public static Result ok(Object obj) {
        return new Result(obj);
    }

    public static Result ok() {
        return ok("操作成功");
    }

    public static Result ok(String msg) {
        return new Result(msg);
    }

    public static Result fail(String msg) {
        return new Result(false, msg);
    }

    public static Result fail() {
        return Result.fail("");
    }
}
