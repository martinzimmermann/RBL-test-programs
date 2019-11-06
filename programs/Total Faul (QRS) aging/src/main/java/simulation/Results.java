package simulation;


import at.tugraz.ist.compiler.interpreter.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results {
    private static Results ourInstance;

    static {
        try {
            ourInstance = new Results();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File file;

    public static Results getInstance() {
        return ourInstance;
    }

    private Results() throws IOException {
        file = new File("result.csv");
        file.delete();
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append("First;Second;Third;Success;Weight 1; Weight 2; weight 3\n");
        fileWriter.flush();
    }

    public void WriteRaw(String raw) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(raw);
        fileWriter.flush();
    }

    public void writeAll(Segment.Rule rule, boolean success, Model model) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);

        String suc = success ? "1" : "0";
        switch (rule) {
            case First:
                fileWriter.append("1;0;0;" + suc + ";" + model.getRules().get(0).getWeight().toPlainString() + ";" + model.getRules().get(1).getWeight().toPlainString() + ";" +model.getRules().get(2).getWeight().toPlainString() + "\n");
                break;
            case Second:
                fileWriter.append("0;1;0;" + suc + ";" + model.getRules().get(0).getWeight().toPlainString() + ";" + model.getRules().get(1).getWeight().toPlainString() + ";" +model.getRules().get(2).getWeight().toPlainString() + "\n");
                break;
            case Third:
                fileWriter.append("0;0;1;" + suc + ";" + model.getRules().get(0).getWeight().toPlainString() + ";" + model.getRules().get(1).getWeight().toPlainString() + ";" +model.getRules().get(2).getWeight().toPlainString() + "\n");
                break;
        }
        fileWriter.flush();
    }

//    public void WriteWeight(Model model) throws IOException {
//        FileWriter fileWriter = new FileWriter(file, true);
//
//        fileWriter.append(model.getRules().get(0).getWeight().toString() + ";" + model.getRules().get(1).getWeight().toString() + ";" +model.getRules().get(2).getWeight().toString() + ";\n");
//        fileWriter.flush();
//    }

//    public void WriteSensoreUsed(Segment.Rule rule, boolean success) throws IOException {
//        FileWriter fileWriter = new FileWriter(file, true);
//
//        String suc = success ? "1" : "0";
//        switch (rule) {
//            case First:
//                fileWriter.append("1;0;0;" + suc + "\n");
//                break;
//            case Second:
//                fileWriter.append("0;1;0;" + suc + "\n");
//                break;
//            case Third:
//                fileWriter.append("0;0;1;" + suc + "\n");
//                break;
//        }
//        fileWriter.flush();
//    }
}
