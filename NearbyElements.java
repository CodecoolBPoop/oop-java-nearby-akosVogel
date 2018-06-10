import java.util.Arrays;

public class NearbyElements {
    private static int[][] multi = new int[][]{
            {2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
            {1, 3, 5, 7},
            {321, 320, 32, 3, 41241, -11, -12, -13, -66, -688}
    };


    private static int[] nearby(int x, int y, int range) {
        int beforeFrom, elementsCountBefore, elementsCountAfter;
        int[] base, before, after, result;
        base = Arrays.copyOf(multi[x], multi[x].length);

        beforeFrom = (y < range) ? 0 : y-range;
        elementsCountBefore = (y < range) ? y : range;
        elementsCountAfter = (base.length-1-y < range) ? base.length-1-y : range;

        before = Arrays.copyOfRange(base, beforeFrom, y);
        after = Arrays.copyOfRange(base, y+1, y+1+elementsCountAfter);

        if (y == base.length-1) {
            return before;
        }
        if (y == 0) {
            return after;
        }

        result = Arrays.copyOf(before, elementsCountBefore + elementsCountAfter);
        System.arraycopy(after, 0, result, before.length, after.length);
        return result;
    };


    public static void main(String[] args) {
        System.out.println("1. task");
        for (int i : nearby(0, 2, 2)) {
            System.out.println(i);
        }
        System.out.println("2. task");
        for (int i : nearby(1, 0, 1)) {
            System.out.println(i);
        }
        System.out.println("3. task");
        for (int i : nearby(1, 3, 5)) {
            System.out.println(i);
        }
        System.out.println("4. task");
        for (int i : nearby(0, 2, 1)) {
            System.out.println(i);
        }

    };
}