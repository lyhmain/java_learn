import java.security.Signature;

public class Singlento1 {
    private Singlento1(){}

    public static Singlento1 getSingle() {
        return single;
    }

    private  static  final  Singlento1 single =new Singlento1();
    //

}
