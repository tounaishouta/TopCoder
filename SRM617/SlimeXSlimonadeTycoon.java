public class SlimeXSlimonadeTycoon {

  public int sell(int[] morning, int[] customers, int stale_limit) {

    int sell = 0;
    for (int i = 0, N = morning.length; i < N; i++) {

      for (int j = 0; j <= i - stale_limit; j++)
        morning[j] = 0;

      for (int j = 0, remains = customers[i]; remains > 0 && j <= i; j++) {
        if (morning[j] < remains) {
          sell += morning[j];
          remains -= morning[j];
          morning[j] = 0;
        }
        else {
          sell += remains;
          morning[j] -= remains;
          remains = 0;
        }
      }
    }

    return sell;
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      SlimeXSlimonadeTycoonHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
        SlimeXSlimonadeTycoonHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class SlimeXSlimonadeTycoonHarness {
  public static void run_test(int casenum) {
    if (casenum != -1) {
      if (runTestCase(casenum) == -1)
        System.err.println("Illegal input! Test case " + casenum + " does not exist.");
      return;
    }

    int correct = 0, total = 0;
    for (int i=0;; ++i) {
      int x = runTestCase(i);
      if (x == -1) {
        if (i >= 100) break;
        continue;
      }
      correct += x;
      ++total;
    }

    if (total == 0) {
      System.err.println("No test cases run.");
    } else if (correct < total) {
      System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
    } else {
      System.err.println("All " + total + " tests passed!");
    }
  }

  static boolean compareOutput(int expected, int result) { return expected == result; }
  static String formatResult(int res) {
    return String.format("%d", res);
  }

  static int verifyCase(int casenum, int expected, int received) { 
    System.err.print("Example " + casenum + "... ");
    if (compareOutput(expected, received)) {
      System.err.println("PASSED");
      return 1;
    } else {
      System.err.println("FAILED");
      System.err.println("    Expected: " + formatResult(expected)); 
      System.err.println("    Received: " + formatResult(received)); 
      return 0;
    }
  }

  static int runTestCase(int casenum__) {
    switch(casenum__) {
      case 0: {
                int[] morning             = {5, 1, 1};
                int[] customers           = {1, 2, 3};
                int stale_limit           = 2;
                int expected__            = 5;

                return verifyCase(casenum__, expected__, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
      }
      case 1: {
                int[] morning             = {10, 20, 30};
                int[] customers           = {30, 20, 10};
                int stale_limit           = 1;
                int expected__            = 40;

                return verifyCase(casenum__, expected__, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
      }
      case 2: {
                int[] morning             = {1, 2, 3, 4, 5};
                int[] customers           = {5, 5, 5, 5, 5};
                int stale_limit           = 5;
                int expected__            = 15;

                return verifyCase(casenum__, expected__, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
      }
      case 3: {
                int[] morning             = {10000, 0, 0, 0, 0, 0, 0};
                int[] customers           = {1, 2, 4, 8, 16, 32, 64};
                int stale_limit           = 4;
                int expected__            = 15;

                return verifyCase(casenum__, expected__, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
      }

      // custom cases

      /*      case 4: {
              int[] morning             = ;
              int[] customers           = ;
              int stale_limit           = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
              }*/
      /*      case 5: {
              int[] morning             = ;
              int[] customers           = ;
              int stale_limit           = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
              }*/
      /*      case 6: {
              int[] morning             = ;
              int[] customers           = ;
              int stale_limit           = ;
              int expected__            = ;

              return verifyCase(casenum__, expected__, new SlimeXSlimonadeTycoon().sell(morning, customers, stale_limit));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
