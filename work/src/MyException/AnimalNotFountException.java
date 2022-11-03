package MyException;

public class AnimalNotFountException extends RuntimeException{

    String detailInformation;

    public AnimalNotFountException(String information) {
        detailInformation = information;
    }

    public String toString() {
        return "AnimalNotFountException异常:出售失败" +  "\n详细原因 : " + detailInformation;
    }

}
