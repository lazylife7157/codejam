package lazylife.codejam.cj2016;

import lazylife.codejam.util.Problem;

public class P_2016_Q_B extends Problem {
	private final char HAPPY_SIDE = '+';

	@Override
	protected String eval(String input) {
		char prev = input.charAt(0);
		int x = 0;

		for (char side: input.toCharArray()) {
			if (side != prev)
				++x;
			prev = side;
		}

		if (prev != HAPPY_SIDE)
			++x;

		return String.valueOf(x);
	}
}
