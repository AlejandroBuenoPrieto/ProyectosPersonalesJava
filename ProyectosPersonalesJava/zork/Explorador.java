package aed.zork;

import es.upm.aedlib.positionlist.*;


public class Explorador {

	public static Pair<Object, PositionList<Lugar>> explora(Lugar inicialLugar) {
		PositionList<Lugar> camino = new NodePositionList<Lugar>();
		Pair<Object, PositionList<Lugar>> solucion = new Pair<Object, PositionList<Lugar>>(null, camino);
		camino.addLast(inicialLugar);
		solucion = exploraRec(inicialLugar, camino, solucion);
		if (solucion.getLeft() == null)
			return null;
		return solucion;
	}

	public static Pair<Object, PositionList<Lugar>> exploraRec(Lugar inicialLugar, PositionList<Lugar> camino,
			Pair<Object, PositionList<Lugar>> solucion) {
		Iterable<Lugar> caminos;
		if (!inicialLugar.sueloMarcadoConTiza()) {
			if (inicialLugar.tieneTesoro()) {
				solucion.setLeft(inicialLugar.getTesoro());
				solucion.setRight(camino);
			} else {
				inicialLugar.marcaSueloConTiza();
				caminos = inicialLugar.caminos();
				for (Lugar a : caminos) {
					if (solucion.getLeft() == null && !a.sueloMarcadoConTiza()) {
						camino.addLast(a);
						exploraRec(a, camino, solucion);
					}
				}
			}
			if (solucion.getLeft() == null)
				camino.remove(camino.last());
		}
		return solucion;
	}
}
