package lazylife.codejam.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public abstract class Problem {
	public void solve(String inputFile, String outputFile) throws InterruptedException, FileNotFoundException {
		long start = System.currentTimeMillis();
		initialize();
		System.out.println("Initialized: " + (System.currentTimeMillis() - start) + "ms");

		if (inputFile != null) {
			while (!new File(inputFile).exists())
				Thread.sleep(1000L);

			System.setIn(new FileInputStream(inputFile));
		}

		if (outputFile != null)
			System.setOut(new PrintStream(outputFile));

		try (Scanner scanner = new Scanner(System.in)) {
			final int T = Integer.parseInt(scanner.nextLine());
			IntStream.rangeClosed(1, T).forEachOrdered(t -> {
				final String input = scanner.nextLine();
				System.out.println(String.format("Case #%d: %s", t, eval(input)));
			});
		}
	}

	protected void initialize() {}
	abstract protected String eval(final String input);
}
