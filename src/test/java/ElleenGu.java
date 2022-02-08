import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ElleenGu {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void tttttttttttest1(){
        assertEquals(new Main().sayHi(), "hi");
    }

    @Test
    public void whatever2(){
        assertEquals(new Main().sayBonjour(), "bj");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    public void writeResultText(String text){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));
            bw.write(text);
            bw.close();
        }
        catch (Exception e){}
    }

    @After
    public void restoreStreams() {
        if(new Main().sayHi().equalsIgnoreCase("hi"))
            writeResultText("Say Hi Correctly");
        else
            writeResultText("Say Hi WRONG!");
        System.setOut(originalOut);
    }
}
