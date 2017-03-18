package lazylife.codejam.util;

import java.util.Scanner;
import java.util.stream.IntStream;

public abstract class Problem {
	public void solve() {
		try (Scanner scanner = new Scanner(System.in)) {
			final int T = Integer.parseInt(scanner.nextLine());
			IntStream.rangeClosed(1, T).forEachOrdered(t -> {
				final String input = scanner.nextLine();
				System.out.println(String.format("Case #%d: %s", t, eval(input)));
			});
		}
	}

	abstract protected String eval(String input);
}
