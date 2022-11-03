package MyException;

public class InsufficientBalanceException extends RuntimeException{

    String detailInformation;
    double need;
    double balance;

    public InsufficientBalanceException(String information,double need,double balance) {
        detailInformation = information;
        this.need = need;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "InsufficientBalanceException异常:购买失败"
                +  "\n详细原因 : "
                + detailInformation
                + " 所需:" + need
                + " 余额:" + balance;
    }
}
