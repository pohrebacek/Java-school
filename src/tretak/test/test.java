package tretak.test;

import fileworks.DataExport;
import fileworks.DataImport;

public class test {
    public static void main(String[] args) {
        DataImport di = new DataImport("inputs.txt");
        DataExport de = new DataExport("outputs.txt");
        System.out.println("kok");

        String line;
        String[] params;
        int a, b;
        while (di.hasNext()) {
            line = di.readLine();
            params = line.split(",");
            a = Integer.parseInt(params[0]);
            b = Integer.parseInt(params[1]);
            switch (params[2]) {
                case "A":
                    de.writeLine(String.valueOf(a+b)); break;

                case "S":
                    de.writeLine(String.valueOf(a-b)); break;

                case "M":
                    de.writeLine(String.valueOf(a*b)); break;

                case "D":
                    de.writeLine(String.valueOf(a/b)); break;
            }
        }
        //di.printFile();
        di.finishImport();
        de.finishExport();
    }
}
