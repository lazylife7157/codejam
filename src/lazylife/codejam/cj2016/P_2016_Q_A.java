package lazylife.codejam.cj2016;

import lazylife.codejam.util.Problem;

public class P_2016_Q_A extends Problem {
	private final int FALL_ASLEEP = (1 << 10) - 1;

	@Override
	protected String eval(String input) {
		final int N = Integer.parseInt(input);
		if (N == 0)
			return "INSOMNIA";

		int flag = 0;
		int x = 0;
		while (flag != FALL_ASLEEP) {
			x += N;
			flag |=
				String.valueOf(x).chars()
					.map(c -> c - '0')
					.map(c -> 1 << c)
					.reduce((a, b) -> a | b)
					.orElse(0);
		}

		return String.valueOf(x);
	}
}
