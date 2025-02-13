package lab3;

import java.util.Objects;

public class CottageCheese implements DairyProduct,Print {
	private String shelfLife;
	private double protein;
	private double fat;
	private int mass;
	private String grainSize;
	
	@Override
	public double calories() {
		return (fat*9+protein*4)/100*mass;
	}
	
	@Override
	public void print() {
		System.out.println(this);
	}
	
	public int getMass() {
		return mass;
	}
	public void setMass(int mass) {
		this.mass = mass;
	}
	public String getGrainSize() {
		return grainSize;
	}
	public void setGrainSize(String grainSize) {
		this.grainSize = grainSize;
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

	@Override
	public int hashCode() {
		return Objects.hash(fat, grainSize, mass, protein, shelfLife);
	}

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CottageCheese other = (CottageCheese) obj;
		return Double.doubleToLongBits(fat) == Double.doubleToLongBits(other.fat)
				&& Objects.equals(grainSize, other.grainSize) && mass == other.mass
				&& Double.doubleToLongBits(protein) == Double.doubleToLongBits(other.protein)
				&& Objects.equals(shelfLife, other.shelfLife);
	}

	@Override
	public String toString() {
		return "CottageCheese [shelfLife=" + shelfLife + ", protein=" + protein + ", fat=" + fat + ", mass=" + mass
				+ ", grainSize=" + grainSize + ", calories()=" + calories() + "]";
	}

	public CottageCheese(String shelfLife, double protein, double fat, int mass, String grainSize) {
		this.shelfLife = shelfLife;
		this.protein = protein;
		this.fat = fat;
		this.mass = mass;
		this.grainSize = grainSize;
	}

	public CottageCheese() {
	}
	

}
