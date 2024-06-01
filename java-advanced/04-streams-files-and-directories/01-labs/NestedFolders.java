import java.io.*;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) throws FileNotFoundException {
        // Keep this file in the same directory as the project
        String path = "Files-and-Streams";

        File file = new File(path);

        printAllNestedFilesWithBFS(file);
        printAllNestedFilesWithDFS(file);

        //This method produces the actual solution required by the tests in judge
        printAllNestedDirectoriesWithBFS(file);
    }

    private static void printAllNestedDirectoriesWithBFS(File root) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream("nested-directories-with-bfs.txt"))
        );

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(root);

        int counter = 0;

        while (!queue.isEmpty()) {
            counter++;
            File file = queue.poll();
            writer.println(file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                }
            }
        }
        writer.println(counter + " folders");
        writer.close();
    }

    private static void printAllNestedFilesWithDFS(File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream("nested-folders-with-dfs.txt"))
        );

        dfs(file, writer);
        writer.close();
    }

    private static void dfs(File file, PrintWriter writer) {
        writer.println(file.getName());
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            dfs(f, writer);
        }
    }

    private static void printAllNestedFilesWithBFS(File root) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream("nested-folders-with-bfs.txt"))
        );

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            File file = queue.poll();
            writer.println(file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    } else {
                        writer.println(f.getName());
                    }
                }
            }
        }
        writer.close();
    }
}
