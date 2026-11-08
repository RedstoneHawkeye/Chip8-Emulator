public class Chip8 {

    private int[] memory = new int[4096];
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
    private void advanceFinger(){
        finger += 2;
    }
}