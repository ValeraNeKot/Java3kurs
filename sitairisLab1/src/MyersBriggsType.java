import java.util.ArrayList;
public class MyersBriggsType extends PersonalityType implements Assessable, Printable, Describable{
    private ArrayList<BigFiveTrait> parameters;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String assess() {
        return null;
    }

    @Override
    public String describe() {
        return null;
    }

    @Override
    public void printDetails() {
        
    }
}
