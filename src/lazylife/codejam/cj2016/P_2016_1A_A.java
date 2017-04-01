package lazylife.codejam.cj2016;

import lazylife.codejam.util.Problem;

public class P_2016_1A_A extends Problem {
	@Override
	protected String eval(String input) {
		final char[] S = input.toCharArray();
		String result = "" + S[0];
		for (int i = 1; i < S.length; ++i) {
			final char c = S[i];
			if (c < result.charAt(0))
				result = result + c;
			else
				result = c + result;
		}
		return result;
	}
}
