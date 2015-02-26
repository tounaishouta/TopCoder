import java.util.*;

public class Family {

  public String isFamily(int[] parent1, int[] parent2) {

    int N = parent1.length;

    int undefined = 0,
        male = 1,
        female = 2;
    int[] sex = new int[N];
    while (true) {
      int i = 0;
      while (i < N && sex[i] != undefined)
        i++;
      if (i == N)
        return "Possible";
      sex[i] = male;
      while (true) {
        boolean changed = false;
        for (i = 0; i < N; i++) {
          if (parent1[i] != -1) {
            if (sex[parent1[i]] == male && sex[parent2[i]] == male)
              return "Impossible";
            if (sex[parent1[i]] == female && sex[parent2[i]] == female)
              return "Impossible";
            if (sex[parent1[i]] == undefined && sex[parent2[i]] == male) {
              sex[parent1[i]] = female;
              changed = true;
            }
            if (sex[parent1[i]] == undefined && sex[parent2[i]] == female) {
              sex[parent1[i]] = male;
              changed = true;
            }
            if (sex[parent1[i]] == male && sex[parent2[i]] == undefined) {
              sex[parent2[i]] = female;
              changed = true;
            }
            if (sex[parent1[i]] == female && sex[parent2[i]] == undefined) {
              sex[parent2[i]] = male;
              changed = true;
            }
          }
        }
        if (!changed)
          break;
      }
    }
  }

  // BEGIN CUT HERE
  public static void main(String[] args) {
    if (args.length == 0) {
      FamilyHarness.run_test(-1);
    } else {
      for (int i=0; i<args.length; ++i)
          FamilyHarness.run_test(Integer.valueOf(args[i]));
    }
  }
  // END CUT HERE
}

// BEGIN CUT HERE
class FamilyHarness {
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

  static boolean compareOutput(String expected, String result) { return expected.equals(result); }
  static String formatResult(String res) {
    return String.format("\"%s\"", res);
  }

  static int verifyCase(int casenum, String expected, String received) { 
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
                int[] parent1             = {-1,-1,0};
                int[] parent2             = {-1,-1,1};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new Family().isFamily(parent1, parent2));
      }
      case 1: {
                int[] parent1             = {-1,-1,-1,-1,-1};
                int[] parent2             = {-1,-1,-1,-1,-1};
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new Family().isFamily(parent1, parent2));
      }
      case 2: {
                int[] parent1             = {-1,-1,0,0,1};
                int[] parent2             = {-1,-1,1,2,2};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new Family().isFamily(parent1, parent2));
      }
      case 3: {
                int[] parent1             = {-1,-1,-1,-1,1,-1,0,5,6,-1,0,3,8,6} ;
                int[] parent2             = {-1,-1,-1,-1,3,-1,4,6,5,-1,5,4,6,1} ;
                String expected__         = "Possible";

                return verifyCase(casenum__, expected__, new Family().isFamily(parent1, parent2));
      }
      case 4: {
                int[] parent1             = {-1,-1,-1,2,2,-1,5,6,4,6,2,1,8,0,2,4,6,9,-1,16,-1,11};
                int[] parent2             = {-1,-1,-1,1,0,-1,1,4,2,0,4,8,2,3,0,5,14,14,-1,7,-1,13};
                String expected__         = "Impossible";

                return verifyCase(casenum__, expected__, new Family().isFamily(parent1, parent2));
      }

      // custom cases

      /*      case 5: {
              int[] parent1             = ;
              int[] parent2             = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new Family().isFamily(parent1, parent2));
              }*/
      /*      case 6: {
              int[] parent1             = ;
              int[] parent2             = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new Family().isFamily(parent1, parent2));
              }*/
      /*      case 7: {
              int[] parent1             = ;
              int[] parent2             = ;
              String expected__         = ;

              return verifyCase(casenum__, expected__, new Family().isFamily(parent1, parent2));
              }*/
      default:
              return -1;
    }
  }
}
// END CUT HERE
