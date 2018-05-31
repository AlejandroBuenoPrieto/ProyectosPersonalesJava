package aed.ejercicios.arrays;

public class Ejercicio6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Integer [] v = {3,4,5};
           Integer [] a = {3,null,5};
          
                    
	}
	public static <E> boolean esInverso (E [] arr1, E [] arr2){
		boolean enc=true;
		if(arr1.length==arr2.length){
			for(int i=0;i<arr1.length;i++){
				if(!aux(arr1[i],arr2[arr1.length-i])) enc=false;
			}
			return enc;
		}
		else return false;
		
		
		
	}
	public static <E> boolean aux(E uno,E dos){
		return (uno==null && dos ==null) || ( dos!=null && dos.equals(uno));
	}
}
