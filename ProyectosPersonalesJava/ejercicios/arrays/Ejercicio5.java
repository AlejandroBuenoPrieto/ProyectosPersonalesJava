package aed.ejercicios.arrays;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Integer [] v = {3,4,5};
           Integer [] a = {3,null,5};
           System.out.println(iguales(a,v));
                    
	}
	
	
	public static boolean iguales (Integer [] arr1, Integer [] arr2){
		boolean iguales = false;
		if (arr1 == arr2 || arr1.length == 0 && arr2.length == 0) return true;
		if(arr1.length==arr2.length){
			int i=0;
		 while(!iguales && i<arr1.length){
			 Integer uno= arr1[i];
			 Integer dos= arr2[i];
			 if(uno==null && dos!=null) {
				 iguales=true;
			 }
			 if(uno!=null && dos==null) iguales =true;
			 if(dos!=null && uno==null){
				 
				 return true;
			 }
			 if(!uno.equals(dos)) iguales=true;
			 i++;
		 }
		 return iguales;
		}else return false;

	}
	public static boolean aux(Integer uno,Integer dos){
		return (uno==null && dos ==null) || ( dos!=null && dos.equals(uno));
	}
	

}
