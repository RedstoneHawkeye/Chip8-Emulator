import java.util.*;

public class Main{
    public static void main(String[] args) {
        Chip8 emulator = new Chip8();

        emulator.setMemoryValue(0x200, 0xA2);
        emulator.setMemoryValue(0x201, 0xF0);







        
        /* ALL LastTwoHexDigit Checks + MORE
// ---- decode (first digit) ----
check("decode 0xA2F0", 0xA, emulator.decode(0xA2F0));
check("decode 0x1234", 0x1, emulator.decode(0x1234));
check("decode 0x0FFF", 0x0, emulator.decode(0x0FFF));
check("decode 0xFFFF", 0xF, emulator.decode(0xFFFF));

// ---- getSecondHexDigit ----
check("second 0x62AF", 0x2, emulator.getSecondHexDigit(0x62AF));
check("second 0x6A2F", 0xA, emulator.getSecondHexDigit(0x6A2F));
check("second 0x60FF", 0x0, emulator.getSecondHexDigit(0x60FF));
check("second 0x6FFF", 0xF, emulator.getSecondHexDigit(0x6FFF));
check("second 0x0000", 0x0, emulator.getSecondHexDigit(0x0000));

// ---- getLastTwoHexDigits ----
check("last two 0x62AF", 0xAF, emulator.getLastTwoHexDigits(0x62AF));
check("last two 0x6A2F", 0x2F, emulator.getLastTwoHexDigits(0x6A2F));
check("last two 0x1200", 0x00, emulator.getLastTwoHexDigits(0x1200));
check("last two 0x12FF", 0xFF, emulator.getLastTwoHexDigits(0x12FF));
check("last two 0x0000", 0x00, emulator.getLastTwoHexDigits(0x0000));

// ---- all three together must rebuild the original ----
int op = 0x62AF;
int rebuilt = emulator.decode(op) * 4096
            + emulator.getSecondHexDigit(op) * 256
            + emulator.getLastTwoHexDigits(op);
check("rebuild 0x62AF", op, rebuilt);

try {
    emulator.getLastTwoHexDigits(0x10000);
    System.out.println("FAIL: last two 0x10000 didn't throw");
} catch (IllegalArgumentException e) {
    System.out.println("PASS: last two 0x10000 threw");
}

try {
    emulator.getLastTwoHexDigits(-1);
    System.out.println("FAIL: last two -1 didn't throw");
} catch (IllegalArgumentException e) {
    System.out.println("PASS: last two -1 threw");
}*/
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

    private static void check(String label, int expected, int actual) {
        System.out.println(actual == expected
            ? "PASS: " + label
            : "FAIL: " + label + " expected " + expected + " but got " + actual);
    }
}