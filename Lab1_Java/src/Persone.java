public class Persone {
    private String surname;
    private boolean sex;// 1 - ж, 0 - м
    private int age;
    public void setSurname(String name){this.surname = surname;}
    public void setSex(boolean sex) {this.sex = sex;}
    public void setAge(int age){this.age = age;}
    public Persone() {}
    public Persone(String surname, boolean sex, int age) {
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }
    public String getSurname(){return surname;}
    public boolean getSex() {return sex;}
    public int getAge() {return age;}
    public void PrintSurname() {System.out.println("Фамилия: " + surname);}
    public void PrintAge() {System.out.println("Возраст: " + age);}
    public void PrintSex() {
        if(sex){System.out.println("Пол: женский.");}
        else{System.out.println("Пол: мужской.");}
    }
}
