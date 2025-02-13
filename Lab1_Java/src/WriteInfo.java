import java.util.ArrayList;

public class WriteInfo {
    void AveM(ArrayList<Persone> A){
        int n=0; double avage=0;
        ArrayList<Persone> B= new ArrayList<Persone>();
        for(int i=0; i< A.size(); i++){
            if(!A.get(i).getSex()){
                B.add(A.get(i));
                n++;
                avage+=A.get(i).getAge();
            }
        }
        avage=avage/n;
        System.out.printf("Средний возраст "+ n +" мужчин: "+ avage);
    }
}
