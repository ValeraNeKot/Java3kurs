import java.util.Objects;

public class Cutlet extends Dish{
    private String meat;

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public Cutlet(){}

    public Cutlet(String title, int prace, String meat){
        setTitle(title);
        setPrace(prace);
        this.meat = meat;
    }

    @Override
    public String toString() {
        return getTitle()+ " состав: "+getMeat()+" "+getPrace() +"р.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Cutlet cutlet = (Cutlet) o;
        return super.equals(o) && Objects.equals(meat, cutlet.meat);
    }

    @Override
    public int hashCode() {
        int result =  getTitle().hashCode();
        result = 31 * result + getPrace();
        result = 31 * result + meat.hashCode();
        return result;
    }
}
