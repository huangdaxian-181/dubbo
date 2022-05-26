package entity;

import entity.service.CodeEnum;

public enum EntityResponse implements CodeEnum {
     SUCCESS_STATUS(200,"成功"),
     ERROR_STATUS(1001,"失败"),
     TOKEN_STATUS(1002,"token无效"),
     TOKEN_OVERDUE_STATUS(1003,"token过期"),
     TOKEN_ERROR_STATUS(1004,"token异常")
    ;

    //错误码
    public int code;

    //提示
    public String message;

    EntityResponse(int code, String message) {
        this.code = code;

        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
