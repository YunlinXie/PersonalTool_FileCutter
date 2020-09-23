import java.io.*;
import java.util.Scanner;

// Put the file in the same folder
public class FileCutter
{
    public static void main(String[] args) throws IOException
    {
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("Please enter an VALID integer for size: ");
    	int size = keyboard.nextInt();
    	System.out.println("Please enter an VALID file name: ");
    	String name = keyboard.next();

    	
        filecutter(name, size);
    }

    public static void filecutter(String name, int size) throws IOException
    {
        FileInputStream fis = new FileInputStream(name);
        FileOutputStream fos = null;

        byte[] buf = new byte[size * size];

        int len = 0;
        int count = 1;
        while ((len = fis.read(buf)) != -1)
        {
            fos = new FileOutputStream("/Users/yunlin/javaProgs/FileCutter/" + name + ".part" + (count++));
            fos.write(buf, 0, len);
            fos.close();
        }

        fis.close();
    }
}
