package lazylife.codejam.util;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
	private static PrimeNumber instance = null;

	synchronized public static PrimeNumber instance() {
		if (instance == null)
			instance = new PrimeNumber();

		return instance;
	}

	/**
	 * Sieve of Eratosthenes
	 */
	public List<Integer> sieve(final int n) {
		final int _n = n / 2;
		final byte[] sieve = new byte[n / 16 + 1];
		final List<Integer> primeNumbers = new ArrayList<>();
		primeNumbers.add(2);
		int prime;
		int o;
		for (int i = 1; i < _n; ++i) {
			if ((sieve[i / 8] & (1 << i % 8)) == 0) {
				prime = i + i + 1;
				primeNumbers.add(prime);
				o = prime + prime;
				for (int j = prime; prime <= j && j < n; j += o)
					sieve[j / 16] |= 1 << ((j / 2) % 8);
			}
		}

		return primeNumbers;
	}
}
