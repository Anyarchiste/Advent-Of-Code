import java.util.ArrayList;

public class Report {

    private final ArrayList<Integer> report;

    private Boolean safe;

    private Boolean ascending;

    public Report(ArrayList<Integer> report) {
        this.report = report;
        ascending = true;
        this.safe = checkSafety();
    }

    private Boolean checkSafety() {
        Boolean safety = true;
        ArrayList<Boolean> safetyChecksPassed = new ArrayList<>();

        if (report.get(0) > report.get(1)) {
            ascending = false;
        }

        for (int i = 0; i < report.size(); i++) {

            int difference = report.get(i) - report.get(i + 1);

            if (difference < 0 && ascending) {
                if (Math.abs(difference) <= 3 && Math.abs(difference) >= 1) {
                    safetyChecksPassed.add(true);
                } else {
                    safetyChecksPassed.add(false);
                }
            } else if (difference > 0 && !ascending) {
                if (Math.abs(difference) <= 3 && Math.abs(difference) >= 1) {
                    safetyChecksPassed.add(true);
                } else {
                    safetyChecksPassed.add(false);
                }
            } else {
                safetyChecksPassed.add(false);
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

    public Boolean getSafe() {
        return safe;
    }

}
