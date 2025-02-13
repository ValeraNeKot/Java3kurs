import java.util.Objects;

public class MashedPotatoes extends Dish{
     private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public MashedPotatoes(){}
    public MashedPotatoes(String title, int prace, double weight){
        this.weight=weight;
        setPrace(prace);
        setTitle(title);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        MashedPotatoes  mashedPotatoes = (MashedPotatoes) o;
        return super.equals(o) && Objects.equals(weight, mashedPotatoes.weight);
    }

    @Override
    public int hashCode() {
        int result =  getTitle().hashCode();
        result = 31 * result + getPrace();
        result = 31 * result + (int)weight;
        return result;
    }

    @Override
    public String toString() {
        return getTitle() +" "+ weight + " г. " +getPrace()+"р.";
    }
}
