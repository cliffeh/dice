package net.thingly.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CartesianProduct<T> implements Iterable<List<T>>,
		Iterator<List<T>> {

	private List<List<T>> objects;
	private int[] j;
	private int permutations, current;

	protected CartesianProduct() {
	}

	public CartesianProduct(List<List<T>> objects) {
		setObjects(objects);
	}

	protected void setObjects(List<List<T>> objects) {
		this.objects = objects;
		permutations = objects.get(0).size();
		for (int i = 1; i < objects.size(); i++) {
			permutations *= objects.get(i).size();
		}
		j = new int[objects.size()];
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return (current < permutations);
	}

	@Override
	public List<T> next() {
		if (current >= permutations)
			throw new NoSuchElementException("iterator has no more elements");

		List<T> result = new ArrayList<T>();

		// add the current item in each list
		for (int i = 0; i < objects.size(); i++) {
			// System.err.println("returning object [" + i + "][" + j[i] + "]");
			result.add(objects.get(i).get(j[i]));
		}

		// update indices
		for (int i = 0; (i < objects.size()) && (j[i] = (j[i] + 1) % objects.get(i).size()) == 0; i++)
			;
		current++;

		return result;
	}

	@Override
	public Iterator<List<T>> iterator() {
		return this;
	}

}
