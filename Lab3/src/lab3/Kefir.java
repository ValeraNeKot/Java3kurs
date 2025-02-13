package lab3;

import java.util.Objects;

public class Kefir implements DairyProduct, Print {
	private String shelfLife;
	private double protein;
	private double fat;
	private int containerVolume;
	private int numberBifidobacteria;

	@Override
	public double calories() {
		return (fat*9+protein*4)/100*containerVolume;
	}
	
	@Override
	public void print() {
		System.out.println(this);
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public int getContainerVolume() {
		return containerVolume;
	}

	public void setContainerVolume(int containerVolume) {
		this.containerVolume = containerVolume;
	}

	public int getNumberBifidobacteria() {
		return numberBifidobacteria;
	}

	public void setNumberBifidobacteria(int numberBifidobacteria) {
		this.numberBifidobacteria = numberBifidobacteria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(containerVolume, fat, numberBifidobacteria, protein, shelfLife);
	}

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kefir other = (Kefir) obj;
		return containerVolume == other.containerVolume
				&& Double.doubleToLongBits(fat) == Double.doubleToLongBits(other.fat)
				&& numberBifidobacteria == other.numberBifidobacteria
				&& Double.doubleToLongBits(protein) == Double.doubleToLongBits(other.protein)
				&& Objects.equals(shelfLife, other.shelfLife);
	}

	@Override
	public String toString() {
		return "Kefir [shelfLife=" + shelfLife + ", protein=" + protein + ", fat=" + fat + ", containerVolume="
				+ containerVolume + ", numberBifidobacteria=" + numberBifidobacteria + ", calories()=" + calories()
				+ "]";
	}

	public Kefir(String shelfLife, double protein, double fat, int containerVolume, int numberBifidobacteria) {
		super();
		this.shelfLife = shelfLife;
		this.protein = protein;
		this.fat = fat;
		this.containerVolume = containerVolume;
		this.numberBifidobacteria = numberBifidobacteria;
	}

	public Kefir() {

	}

}
