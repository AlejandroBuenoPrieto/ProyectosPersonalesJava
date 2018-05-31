package aed.find;

import es.upm.aedlib.tree.Tree;
import es.upm.aedlib.Position;


public class solucion {

  /**
   * Busca ficheros con nombre igual que fileName dentro el arbol directory,
   * y devuelve un PositionList con el nombre completo de los ficheros
   * (incluyendo el camino).
   */
  public static void find(String fileName, Tree<String> directory) {
    // Cambio el cuerpo de este metodo
	  Printer.enableOutput();
	  String caminos="";
	  findInPos(directory.root(),caminos,fileName,directory);
  }
  private static void findInPos(Position<String> cursor, String currentPath, 
		  String fileName, Tree<String> directory){
	  Iterable<Position<String>> caminos;
	  if(directory.size()!=0){
		  if(cursor.element().equals(fileName)){
			  currentPath=currentPath.concat("/");
			  currentPath= currentPath.concat(fileName);
			  Printer.println(currentPath);
		  }
		  else{
			  currentPath=currentPath.concat("/");
			  currentPath= currentPath.concat(cursor.element());
              caminos= directory.children(cursor);
              for(Position<String> a:caminos){
            	  findInPos(a,currentPath,fileName,directory);
              }
			  
		  }
		  if(!currentPath.contains(fileName)){
			  currentPath.replace(cursor.element(),"");
		  }
		  
	  }
	  }
}
