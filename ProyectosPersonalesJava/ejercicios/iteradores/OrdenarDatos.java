package aed.ejercicios.iteradores;

public class OrdenarDatos implements Comparable<OrdenarDatos> {
	private int valor;

	public OrdenarDatos(int valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(OrdenarDatos o) {
		// TODO Auto-generated method stub
		if (valor > o.valor)
			return 1;
		if (valor < o.valor)
			return -1;
		else
			return 0;
	}

	public static boolean estaOrdenado(OrdenarDatos[] datos) {
		boolean enc = true;
		OrdenarDatos actual = datos[0];
		for (int i = 1; i < datos.length - 1; i++) {
			if (actual.compareTo(datos[i]) == -1)
				enc = false;
			actual = datos[i];
		}
		return enc;
	}

}
