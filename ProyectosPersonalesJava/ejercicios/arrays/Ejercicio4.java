package aed.ejercicios.arrays;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int [] v = {3,4,5};
           int [] a = reverse(v);
           for(int i=0;i<a.length;i++){
        	   System.out.println(a[i]);
           }
           
	}
	public static int [] reverse(int [] v){
		if(v!=null){
		int [] aux = new int [v.length];
		int j=0;
		for(int i=v.length-1;i>=0;i--){
			aux[j]=v[i];
			j++;
		}
		return aux;
	}
		else return null;

}
}
