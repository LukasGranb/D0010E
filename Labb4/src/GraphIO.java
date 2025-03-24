import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO {

    public static void readFile(Graph g, String filename) throws IOException {
        try (Scanner scanner = new Scanner(new FileReader(filename))){
            int nodes = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < nodes; i++) {
                String[] parts = scanner.nextLine().split(" ");
                int id = Integer.parseInt(parts[0]);
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);

                g.addNode(id, x, y);
            }

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                int id1 = Integer.parseInt(parts[0]);
                int id2 = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);

                g.addEdge(id1, id2, weight);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found " + filename);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect file format");
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
