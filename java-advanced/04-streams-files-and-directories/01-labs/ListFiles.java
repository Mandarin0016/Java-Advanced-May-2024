import java.io.*;

public class ListFiles {
    public static void main(String[] args) throws FileNotFoundException {
        // Keep this file in the same directory as the project
        String path = "Files-and-Streams";

        File file = new File(path);

        File[] files = file.listFiles();

        PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                        new FileOutputStream("output.txt"))
        );

        // Files may not be present so check for null first
        if (files != null) {
            for (File f : files) {
                if (!f.isDirectory()) {
                    writer.println(f.getName() + ": [" + f.length() + "]");
                }
            }
        }
        writer.close();
    }
}
