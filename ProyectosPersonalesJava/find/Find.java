package aed.find;

import es.upm.aedlib.tree.Tree;
import es.upm.aedlib.Position;

public class Find {
	public static void find(String fileName, Tree<String> directory) {
		// Cambio el cuerpo de este metodo
		Printer.enableOutput();
		findInPos(directory.root(), "", fileName, directory);

	}

	private static void findInPos(Position<String> cursor, String currentPath, String fileName,
			Tree<String> directory) {
		Iterable<Position<String>> caminos;
		if (directory.size() != 0) {
			if (cursor.element().equals(fileName)) {
				currentPath = currentPath.concat("/" + fileName);
				Printer.println(currentPath);
			} else {
				caminos = directory.children(cursor);
				currentPath = currentPath.concat("/" + cursor.element());
				for (Position<String> a : caminos) {
					findInPos(a, currentPath, fileName, directory);
				}

			}
			if (!currentPath.contains(fileName)) {
				currentPath.replace(cursor.element(), "");
			}
		}

	}

}
