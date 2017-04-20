package lazylife.codejam.cj2015;

import lazylife.codejam.util.Problem;

/**
 * @author hwshim0810
 */
public class P_2015_Q_A extends Problem {

    @Override
    protected String eval(final String input) {
        String[] temp = input.split(" ");
        int rpt = Integer.parseInt(temp[0]);
        int need = 0;
        int claped = 0;

        for (int i = 0; i <= rpt; i++) {
            if (claped < i) {
                int call = i - claped;
                need += call;
                claped += call;
            }
            claped += temp[1].charAt(i) - '0';
        }

        return String.valueOf(need);
    }
}
