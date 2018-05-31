package aed.actasnotas;

import es.upm.aedlib.indexedlist.IndexedList;

import java.util.Comparator;

import es.upm.aedlib.indexedlist.ArrayIndexedList;

public class ActaNotasAED implements ActaNotas{
	private IndexedList <Calificacion> alumnos;

	
	public ActaNotasAED () {
		alumnos = new ArrayIndexedList <Calificacion> ();
	}
	
	public void addCalificacion(String nombre, String matricula, int nota)
			throws CalificacionAlreadyExistsException {
		boolean encontrado = false;
		for (int i = 0; i < alumnos.size() && !encontrado; i++) {
			if (matricula.equals(alumnos.get(i).getMatricula())) {
				encontrado = true;
				throw new CalificacionAlreadyExistsException();
			}
		}
			alumnos.add(alumnos.size(), new Calificacion(nombre, matricula, nota));
	}
	
	public void updateNota(String matricula, int nota)
			throws InvalidMatriculaException {
		
		int posMatricula = buscarMatricula(matricula);
		
		if (posMatricula == -1 ) {
			throw new InvalidMatriculaException();
		} else {
			alumnos.get(posMatricula).setNota(nota);
		}
	}
		
	
	public void deleteCalificacion(String matricula)
			throws InvalidMatriculaException {
		int posMatricula = buscarMatricula(matricula);
		if (posMatricula == -1) {
			throw new InvalidMatriculaException();
		}
		alumnos.remove(alumnos.get(posMatricula));
	}
	
	public Calificacion getCalificacion(String matricula)
			throws InvalidMatriculaException {
		int posMatricula = buscarMatricula(matricula);
		if (posMatricula == -1) {
			throw new InvalidMatriculaException();
		}
		return alumnos.get(posMatricula);
	}
	
	private int buscarMatricula (String matricula) {
		boolean encontrado = false;
		int pos = -1;
		int i = 0;
		while (i < alumnos.size() && encontrado==false) {
			if (matricula.equals(alumnos.get(i).getMatricula())) {
				pos = i;
				encontrado = true;
			} else {
				pos = -1;
				i++;
			}
		}
		return pos;
	}
	
	public IndexedList<Calificacion> getCalificaciones(Comparator<Calificacion> cmp) {
		IndexedList <Calificacion> listaOrdenada = new ArrayIndexedList <Calificacion>();
		for (int i = 0; i < alumnos.size(); i++) {
			int cont = 0;
			for (int j = 0; j < listaOrdenada.size(); j++) {
				int res = cmp.compare(alumnos.get(i), listaOrdenada.get(j));
				if (res > 0) {
					cont ++;
				}
			}
			listaOrdenada.add(cont, alumnos.get(i));
		}
		return listaOrdenada;
	}
	
	public IndexedList<Calificacion> getAprobados(int notaMinima) {
		IndexedList <Calificacion> aprobados = new ArrayIndexedList <Calificacion>();
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNota() >= notaMinima) {
				aprobados.add(aprobados.size(), alumnos.get(i));
			}
		}
		return aprobados;
	}
	public static void main (String []args){
	}

	}

