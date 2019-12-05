public class Instruction {
    private Computer cpu;
    private int code;

    public Instruction(int code, Computer cpu) {
        this.cpu = cpu;
        this.code = code;
    }

    private boolean getMode(int offset) {
        return (code / offset) % 10 == 1;
    }

    private int getOpcode() {
        return code % 100;
    }

    public void execute() throws Exception {
        switch (getOpcode()) {
            case 1:
                sum();
                break;
            case 2:
                multiply();
                break;
            case 3:
                input();
                break;
            case 4:
                output();
                break;
            case 5:
                jump(true);
                break;
            case 6:
                jump(false);
                break;
            case 7:
                compare(false);
                break;
            case 8:
                compare(true);
                break;
            default:
                throw new Exception("errOptCode: " + getOpcode() + ", ");
        }
    }

    private void sum() {
        int value = cpu.getValue(1, getMode(100));
        value += cpu.getValue(2, getMode(1000));
        cpu.setValue(3, value, getMode(10000));
        cpu.movePointer(4, false);
    }

    private void multiply() {
        int value = cpu.getValue(1, getMode(100));
        value *= cpu.getValue(2, getMode(1000));
        cpu.setValue(3, value, getMode(10000));
        cpu.movePointer(4, false);
    }

    private void input() {
        cpu.setInput(1, getMode(100));
        cpu.movePointer(2, false);
    }

    private void output() {
        System.out.println(cpu.getValue(1, getMode(100)));
        cpu.movePointer(2, false);
    }

    private void jump(boolean doJump) {
        int[] args = {
                cpu.getValue(1, getMode(100)),
                cpu.getValue(2, getMode(1000))};

        if (args[0] == 0 ^ doJump) {
            cpu.movePointer(args[1], true);
        } else {
            cpu.movePointer(3, false);
        }
    }

    private void compare(boolean equals) {
        int[] args = {
                cpu.getValue(1, getMode(100)),
                cpu.getValue(2, getMode(1000)),
                cpu.getValue(3, getMode(10000))};
        if (equals) {
            cpu.setValue(3, args[0] == args[1] ? 1 : 0, getMode(10000));
        } else {
            cpu.setValue(3, args[0] <  args[1] ? 1 : 0, getMode(10000));
        }
        cpu.movePointer(4, false);
    }
}
