/*
 * Programare orientata pe obiecte
 * Seria CC
 * Laboratorul 9
 * Nan Mihai
 */

/**
 *
 * @author Nan Mihai
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AMatrix<T extends Number> extends ArrayList<ArrayList<T>> {
	public abstract AMatrix<T> addition(AMatrix<T> m1);
	
	//Aduna doua elemente de tip T si intoarce rezultatul
	public abstract T sum(T obj1, T obj2);
}

class IntegerMatrix extends AMatrix<Integer>{
	public IntegerMatrix() {
		super();
	}

	public Integer sum(Integer obj1, Integer obj2) {
		return obj1 + obj2;
	}

	public AMatrix<Integer> addition(AMatrix<Integer> m1) {
		IntegerMatrix rezultat = new IntegerMatrix();
		int suma;
		for(ArrayList i:this) {
			for(Object j:i) {
				int index = this.indexOf(i);
				List<Integer> list = rezultat.get(index);
				int sum1 = (int) ((List)this.get(index)).get((int)j);
				int sum2 = (int)(((List)m1.get(index)).get((int)j));
				suma = rezultat.sum(sum1, sum2);
				list.add((int)j, suma);
			}
		}

		return rezultat;
	}

	public String toString() {
		String s = "";

		for (List i:
			 this) {
			s += i;
		}

		return s;
	}
}
