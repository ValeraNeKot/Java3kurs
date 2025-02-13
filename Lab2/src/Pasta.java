import java.util.Objects;

public class Pasta extends Dish{
     private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pasta(){}
    public Pasta(String title, int prace, String type){
        this.type=type;
        setPrace(prace);
        setTitle(title);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Pasta pasta = (Pasta) o;
        return super.equals(o) && Objects.equals(type, pasta.type);
    }

    @Override
    public int hashCode() {
        int result =  getTitle().hashCode();
        result = 31 * result + getPrace();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getTitle() +" "+ type + " " +getPrace()+"р.";
    }
}
