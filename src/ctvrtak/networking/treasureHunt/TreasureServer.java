package ctvrtak.networking.treasureHunt;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import static java.lang.Integer.parseInt;

public class TreasureServer {
    static Random r = new Random();
    static int treasureRow = r.nextInt(0, 7);
    static int treasureColumn = r.nextInt(0, 7);
    private static final int PORT = 5555;

    private final Set<PrintWriter> clientOutputs = Collections.synchronizedSet(new HashSet<>());

    static List<String> state = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println(treasureRow + ";" + treasureColumn);
        new TreasureServer().start();

    }

    private void start() throws IOException {
        System.out.println("GridServer listening on port " + PORT);
        try (ServerSocket ss = new ServerSocket(PORT)) {
            while (true) {
                Socket s = ss.accept();
                System.out.println("Client connected: " + s.getRemoteSocketAddress());
                new Thread(() -> handleClient(s), "client-" + s.getPort()).start();
            }
        }
    }

    private void sendState(PrintWriter out) {
        if (!state.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE,");

            for (int i = 0; i < state.size(); i++) {
                if (i == state.size()-1) {
                    sb.append(state.get(i));

                } else {
                    sb.append(state.get(i) + ",");
                }

            }

            System.out.println(sb.toString());
            out.println(sb.toString());
        }
    }

    private void handleClient(Socket socket) {
        PrintWriter out = null;

        try (socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            out = pw;
            clientOutputs.add(out);

            sendState(out);

            System.out.println(state);

             String line;
             while ((line = in.readLine()) != null) {
                 line = line.trim();
                 if (line.startsWith("DIG")) {
                     System.out.println(line);
                     String[] parts = line.split(";");
                     int r = parseInt(parts[1]);
                     int c = parseInt(parts[2]);

                     if (r == treasureRow && c == treasureColumn) {
                         broadcast("REVEAL;TREASURE;" + r + ";" + c);
                         setTreasure();
                         state.clear();
                     } else {
                         String stateMsg = "REVEAL;EMPTY;" + r + ";" + c;
                         state.add(stateMsg);
                         broadcast(stateMsg);
                     }
                 } else {
                     out.println("ERROR UnknownCommand");
                 }
             }
        }catch (IOException e) {
            System.out.println("Client IO error: " + e.getMessage());
        } finally {
            if (out != null) clientOutputs.remove(out);
            System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
        }
    }

    private void broadcast(String msg) {
        synchronized (clientOutputs) {
            for (PrintWriter out : clientOutputs) {
                out.println(msg);
            }
        }
    }

    private void setTreasure() {
        treasureRow = r.nextInt(1, 7);
        treasureColumn = r.nextInt(1, 7);
        System.out.println(treasureRow + ";" + treasureColumn);
    }
}
