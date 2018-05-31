package aed.laberinto;

import es.upm.aedlib.lifo.*;

public class Exploradora {
/**
 * Busca un tesoro en el laberinto, empezando en el lugar
 * inicial: inicialLugar. 
 * @return un Objeto tesoro encontrado, o null, si ningun
 * tesoro existe en la parte del laberinto que es alcanzable
 * desde la posicion inicial.
 */ 
	public static Object explora(Lugar inicialLugar) {
		LIFO<Lugar> faltaPorExplorar = new LIFOList<Lugar>();
		Lugar actualLugar = inicialLugar;
		Iterable<Lugar> caminos;
		boolean encontrado = false;
		Object tesoro = null;
		faltaPorExplorar.push(inicialLugar);
		if (faltaPorExplorar.isEmpty()) {
			return null;
		} else {

			while (!encontrado && !faltaPorExplorar.isEmpty()) {

				if (!actualLugar.sueloMarcadoConTiza()) {
					if (actualLugar.tieneTesoro()) {
						tesoro = actualLugar.getTesoro();
						encontrado = true;
					} else {
						actualLugar.marcaSueloConTiza();
						caminos = actualLugar.caminos();
						for (Lugar a : caminos) {
							faltaPorExplorar.push(a);
						}
					}
				}
				actualLugar = faltaPorExplorar.pop();
			}
		}
		return tesoro;
	}
}
