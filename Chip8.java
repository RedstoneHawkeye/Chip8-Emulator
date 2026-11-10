public class Chip8 {

    private int[] memory = new int[4096];
    private int[] registers = new int[16];
    private int finger = 0x200;



    public int getMemoryValue(int position){
        demandPositionInsideBounds(position);
        return memory[position];
    }

    public void setMemoryValue(int position, int value){
        demandPositionInsideBounds(position);
        demandValueInsideBounds(value);
        memory[position] = value;
    }

    public int getFinger(){
        return finger;
    }

    public void setFinger(int nF){
        demandPositionInsideBounds(nF);
        finger = nF;
    }

    private void demandPositionInsideBounds(int position){

        if(position > 4095 || position < 0){
            throw new ArrayIndexOutOfBoundsException("position " + 
            Integer.toString(position) + " does not exist. Womp womp.");
        }
    }

    private void demandValueInsideBounds(int value){

        if(value > 255 || value < 0){
            throw new IllegalArgumentException("value " + 
            Integer.toString(value) + " does not exist within the byte. Womp womp.");
        }
    }

    public int fetch(){
        demandFingerInsideBounds();
        int total = (getMemoryValue(finger) * 256) + getMemoryValue(finger + 1);
        advanceFinger();
        return total;
    }

    private void demandFingerInsideBounds(){
        if(finger >= 4095){
            throw new ArrayIndexOutOfBoundsException("Hey dum dum the finger value of " 
            + Integer.toString(finger) + " doesn't go this far :)");
        }
    }

    private void demandFingerInsideBounds(int fingerVal){
        if(fingerVal >= 4095){
            throw new ArrayIndexOutOfBoundsException("Hey dum dum the finger value of " 
            + Integer.toString(finger) + " doesn't go this far :)");
        }
    }

    private void advanceFinger(){
        finger += 2;
    }

    public int decode(int value){
        demandHexCorrectAmount(value);
        return (value / 4096);
    }

    private void demandHexCorrectAmount(int hexValue){
        String hexValueString = Integer.toString(hexValue); // Converts hexValue to decimal
        int backToInt = Integer.parseInt(hexValueString);

        if(backToInt > 65535 || backToInt < 0){ // 65535 is max value of hex (0xFFFF)
            throw new IllegalArgumentException("Hey stupid your hex value " + 
                hexValueString + " isn't the right amount (" + backToInt + 
                " isn't beween 0 and 65535). It has a hex value of 0x" + 
                Integer.toHexString(backToInt)
            );
        }
    }

    private void demandRegisterInsideBounds(int position){
        if(position > 15 || position < 0){
            throw new ArrayIndexOutOfBoundsException("Hey bro. " 
            + Integer.toString(position) + " isn't in the bounds [0, 15] " 
            + "so it can't go into a register of that amount. Too bad so sad.");
        }
    }

    public void setRegisterValue(int position, int value){
        demandValueInsideBounds(value);
        demandRegisterInsideBounds(position);
        registers[position] = value;
    }

    public int getRegisterValue(int position){
        demandRegisterInsideBounds(position);
        return registers[position];
    }

    public int getSecondHexDigit(int hexValue){ // Second hex digit can represent Register number in commands
        demandHexCorrectAmount(hexValue); // Used to confirm hexValue is within 0xFFFF
        return ((hexValue % 4096) / 256); // Finds second digit of hexValue
    }

    public int getLastTwoHexDigits(int hexValue){
        demandHexCorrectAmount(hexValue);
        return (hexValue %256);
    }
}