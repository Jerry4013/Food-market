package soen487.foodmarket.error;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/04
 **/

public enum EmBusinessError implements CommonError {

    //Generic error, starts with 10001
    PARAMETER_VALIDATION_ERROR(10001, "Parameter error"),
    UNKNOWN_ERROR(10002, "Unknown error"),

    //20000, User information related error
    USER_NOT_EXIST(20001,"User does not exist."),
    USER_LOGIN_FAIL(20002,"Telephone number or password incorrect."),
    USER_NOT_LOGIN(20003,"User is not login"),

    //30000, transaction error
    BOOK_NOT_EXIST(30001, "This book does not exist."),
    MEMBER_NOT_EXIST(30002, "This member does not exist"),
    LOAN_NOT_EXIST(30003, "This loan does not exist"),
    MEMBER_CANNOT_SAVE(30004, "Member can not be saved."),

    ;


    private int errCode;
    private String errMsg;

    EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}