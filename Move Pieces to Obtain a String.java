class Solution {
    public boolean canChange(String start, String target) {
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }

        int n = start.length();
        int startPointer = 0;
        int targetPointer = 0;

        while (startPointer < n && targetPointer < n) {
            while (startPointer < n && start.charAt(startPointer) == '_') {
                startPointer++;
            }
            while (targetPointer < n && target.charAt(targetPointer) == '_') {
                targetPointer++;
            }

            if (startPointer == n && targetPointer == n) {
                return true;
            }

            if (startPointer == n || targetPointer == n) {
                return false;
            }

            if (start.charAt(startPointer) != target.charAt(targetPointer)) {
                return false;
            }

            if (start.charAt(startPointer) == 'L' && startPointer < targetPointer) {
                return false;
            }
            if (start.charAt(startPointer) == 'R' && startPointer > targetPointer) {
                return false;
            }

            startPointer++;
            targetPointer++;
        }

        return true;
    }
}
