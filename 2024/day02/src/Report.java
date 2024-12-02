import java.util.ArrayList;

public class Report {

    private final ArrayList<Integer> report;

    private Boolean safe;

    private Boolean ascending;

    public Report(ArrayList<Integer> report) {
        this.report = report;
        ascending = true;
        this.safe = checkSafety();
        System.out.println(safe);
    }

    private Boolean checkSafety() {
        Boolean safety = true;
        ArrayList<Boolean> safetyChecksPassed = new ArrayList<>();

        if (report.get(0) > report.get(1)) {
            ascending = false;
        }

        for (int i = 0; i < report.size(); i++) {

            if (!checkPairSafety(i, i + 1)) {
                if (checkPairSafety(i, i + 2)) {
                    safetyChecksPassed.add(true);
                    i++;
                } else {
                    safetyChecksPassed.add(false);
                    i++;
                }
            } else {
                safetyChecksPassed.add(true);
            }

            if (i + 2 >= report.size()) {
                break;
            }
        }

        for (Boolean checks : safetyChecksPassed) {
            if (!checks) {
                safety = false;
                break;
            }
        }

        return safety;
    }

    private boolean checkPairSafety(int i, int y) {
        boolean isSafe = false;

        if (y < report.size()) {
            int difference = report.get(i) - report.get(y);

            if (difference < 0 && ascending) {
                if (Math.abs(difference) <= 3 && Math.abs(difference) >= 1) {
                    isSafe = true;
                } else {
                    isSafe = false;
                }
            } else if (difference > 0 && !ascending) {
                if (Math.abs(difference) <= 3 && Math.abs(difference) >= 1) {
                    isSafe = true;
                } else {
                    isSafe = false;
                }
            } else {
                isSafe = false;
            }
        } else {
            isSafe = true;
        }

        return isSafe;
    }

    public Boolean getSafe() {
        return safe;
    }

}
