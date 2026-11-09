import java.util.*;

public class Main{
    public static void main(String[] args) {
        Chip8 emulator = new Chip8();

        emulator.setMemoryValue(0x200, 0xA2);
        emulator.setMemoryValue(0x201, 0xF0);

        System.out.println(emulator.fetch());
        System.out.println(emulator.fetch());

        System.out.println(Integer.toString(emulator.decode(0x12345)));
    }
}