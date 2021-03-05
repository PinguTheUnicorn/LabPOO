/*
 * Programare orientata pe obiecte
 * Seria CC
 * Laboratorul 9
 * Nan Mihai
 */

import java.util.ArrayList;

/**
 *
 * @author Nan Mihai
 */
public interface GenericInterface {
	//Sterge duplicatele dintr-o lista si returneaza lista rezultata
	public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list);
	//Determina elementul maxim dintr-o lista
	public <E extends Comparable<E>> E max(ArrayList<E> list);
	//Cauta o valoare in lista sortata, folosind algoritmul de cautare binara si returneaza pozitia
	public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end);
}

class GenericListMethods implements GenericInterface {
	public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		int i, j;
		ArrayList<E> newList = new ArrayList<E>();

		for(i = 0; i < list.size() - 1; i++) {
			for(j = i + 1; j < list.size(); j++) {
				if(list.get(j).compareTo(list.get(i)) == 0) {
					list.remove(j);
				}
			}
		}

		return list;
	}

	public <E extends Comparable<E>> E max(ArrayList<E> list) {
		E maxim = list.get(0);
		int i;

		for(i = 1; i < list.size(); i++) {
			if(list.get(i).compareTo(maxim) == 1) {
				maxim = list.get(i);
			}
		}

		return maxim;
	}

	public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end) {
		if(start > end) {
			return -1;
		}

		int mid = (start + end)/2;

		if(list.get(mid).compareTo(key) == 0) {
			return mid;
		}

		if(list.get(mid).compareTo(key) == 1) {
			return binarySearch(list, key, start, mid - 1);
		}

		return binarySearch(list, key, mid + 1, end);
	}
}
