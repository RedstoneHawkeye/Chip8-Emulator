import java.util.*;

public class Main{
    public static void main(String[] args) {
        Chip8 emulator = new Chip8();

        emulator.setMemoryValue(0x200, 0xA2);
        emulator.setMemoryValue(0x201, 0xF0);
        
        
        

        
        /*GET SECOND HEX DIGIT TEST CASES
        
        try{
            emulator.getSecondHexDigit(0x62AF);
            System.out.println("PASS: 0x62AF is within bounds");
        } catch (IllegalArgumentException e){
            System.out.println("FAIL: 0x62AF is inside bounds, error message should not have been called: \n" + e.getMessage());
        }
        try{
            emulator.getSecondHexDigit(0x12345);
            System.out.println("FAIL: 0x62AF is outside of bounds");
        } catch (IllegalArgumentException e){
            System.out.println("PASS: 0x12345 threw error message " + e.getMessage());
        }
        try{
            emulator.getSecondHexDigit(-5);
            System.out.println("FAIL: 0x62AF is outside of bounds");
        } catch (IllegalArgumentException e){
            System.out.println("PASS: 0x12345 threw error message " + e.getMessage());
        }*/
        /*ALL TEST CASES FROM BEFORE
        // ---------- Memory ----------
try {
    emulator.getMemoryValue(4096);
    System.out.println("FAIL: memory read 4096 didn't throw");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("PASS: memory read 4096 -> " + e.getMessage());
}

try {
    emulator.getMemoryValue(-1);
    System.out.println("FAIL: memory read -1 didn't throw");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("PASS: memory read -1 -> " + e.getMessage());
}

try {
    emulator.setMemoryValue(4096, 5);
    System.out.println("FAIL: memory write to 4096 didn't throw");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("PASS: memory write to 4096 -> " + e.getMessage());
}

try {
    emulator.setMemoryValue(0x300, 256);
    System.out.println("FAIL: memory value 256 didn't throw");
} catch (IllegalArgumentException e) {
    System.out.println("PASS: memory value 256 -> " + e.getMessage());
}

try {
    emulator.setMemoryValue(0x300, -1);
    System.out.println("FAIL: memory value -1 didn't throw");
} catch (IllegalArgumentException e) {
    System.out.println("PASS: memory value -1 -> " + e.getMessage());
}

// ---------- Finger and fetch ----------
try {
    emulator.setFinger(4096);
    System.out.println("FAIL: finger 4096 didn't throw");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("PASS: finger 4096 -> " + e.getMessage());
}

try {
    emulator.setFinger(4095);   // legal for the finger to sit here...
    emulator.fetch();           // ...but an instruction can't start here
    System.out.println("FAIL: fetch at 4095 didn't throw");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("PASS: fetch at 4095 -> " + e.getMessage());
}
emulator.setFinger(0x200);      // put the finger back for later tests

// ---------- Decode ----------
try {
    emulator.decode(0x12345);
    System.out.println("FAIL: decode 0x12345 didn't throw");
} catch (IllegalArgumentException e) {
    System.out.println("PASS: decode 0x12345 -> " + e.getMessage());
}

try {
    emulator.decode(-5);
    System.out.println("FAIL: decode -5 didn't throw");
} catch (IllegalArgumentException e) {
    System.out.println("PASS: decode -5 -> " + e.getMessage());
}

// ---------- Registers ----------
try {
    emulator.getRegisterValue(16);
    System.out.println("FAIL: register read 16 didn't throw");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("PASS: register read 16 -> " + e.getMessage());
}

try {
    emulator.getRegisterValue(-1);
    System.out.println("FAIL: register read -1 didn't throw");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("PASS: register read -1 -> " + e.getMessage());
}

try {
    emulator.setRegisterValue(16, 5);
    System.out.println("FAIL: register write to 16 didn't throw");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("PASS: register write to 16 -> " + e.getMessage());
}

try {
    emulator.setRegisterValue(0, 300);
    System.out.println("FAIL: register value 300 didn't throw");
} catch (IllegalArgumentException e) {
    System.out.println("PASS: register value 300 -> " + e.getMessage());
}

try {
    emulator.setRegisterValue(0, -1);
    System.out.println("FAIL: register value -1 didn't throw");
} catch (IllegalArgumentException e) {
    System.out.println("PASS: register value -1 -> " + e.getMessage());
}

// ---------- A failed write must not damage the old value ----------
emulator.setRegisterValue(0, 25);
try {
    emulator.setRegisterValue(0, 256);
} catch (IllegalArgumentException e) {
    // ignored on purpose; we only care what's in the register afterwards
}
System.out.println(emulator.getRegisterValue(0) == 25
    ? "PASS: failed write left 25 intact"
    : "FAIL: register changed to " + emulator.getRegisterValue(0));*/
    }
}