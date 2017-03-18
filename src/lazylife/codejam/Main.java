package lazylife.codejam;

import lazylife.codejam.util.Problem;

import java.io.*;

public class Main {
	public static void main(String... args) {
		try {
			if (args.length < 3) {
				printUsage();
				System.exit(1);
			}

			final String problem = String.format("lazylife.codejam.cj%1$s.P_%1$s_%2$s_%3$s", args[0], args[1], args[2]);
			for (int i = 1; i < args.length; ++i) {
				switch (args[i]) {
					case "-i":
					case "--input":
						if (++i < args.length)
							System.setIn(new FileInputStream(args[i]));
						break;
					case "-o":
					case "--output":
						if (++i < args.length)
							System.setOut(new PrintStream(args[i]));
						break;
					default:
				}
			}

			((Problem) Class.forName(problem).newInstance()).solve();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

	private static void printUsage() {
		final String usage =
			String.join("\n",
				"Usage: YEAR ROUND PROBLEM [OPTIONS...]",
				"  OPTION: [-i INPUT_FILE | -o OUTPUT-FILE]",
				"",
				"  ex) 2016 Q A -i A-small.in -o A-small.out",
				"      2016 1B B -i B-small-practice.in"
			);
		System.out.println(usage);
	}
}
