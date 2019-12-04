public class Main {
    private static int[] memory;

    public static void main(String[] args) {
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                init();
                setArgs(i, j);
                run();
                if (memory[0] == 19690720) {
                    System.out.println(100 * i + j);
                }
            }
        }

    }

    private static void init() {
        memory = new int[]{
                1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 9, 1, 19, 1, 19, 5, 23, 1, 23, 6, 27, 2, 9, 27, 31, 1, 5, 31, 35, 1, 35, 10, 39, 1, 39, 10, 43,
                2, 43, 9, 47, 1, 6, 47, 51, 2, 51, 6, 55, 1, 5, 55, 59, 2, 59, 10, 63, 1, 9, 63, 67, 1, 9, 67, 71, 2, 71, 6, 75, 1, 5, 75, 79, 1, 5, 79, 83, 1,
                9, 83, 87, 2, 87, 10, 91, 2, 10, 91, 95, 1, 95, 9, 99, 2, 99, 9, 103, 2, 10, 103, 107, 2, 9, 107, 111, 1, 111, 5, 115, 1, 115, 2, 119, 1,
                119, 6, 0, 99, 2, 0, 14, 0
        };
    }

    private static void setArgs(int noun, int verb) {
        memory[1] = noun;
        memory[2] = verb;
    }

    private static void run() {
        int ptr = 0;
        do {
            if (memory[ptr] == 1) {
                memory[memory[ptr+3]] = memory[memory[ptr+1]] + memory[memory[ptr+2]];
            } else if (memory[ptr] == 2) {
                memory[memory[ptr+3]] = memory[memory[ptr+1]] * memory[memory[ptr+2]];
            }
            ptr += 4;
        } while (memory[ptr] != 99);
    }

    private static void printResult() {
        System.out.println(memory[0]);
    }

}
