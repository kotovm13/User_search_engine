package solution.inputOutput;

import solution.controller.InputOutputController;
import solution.controller.PhoneInfoController;
import solution.model.PhoneInfo;
import solution.services.InputOutputServices;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class InputAndOutput {

    private File inputBaseFile;
    private File inputFile;
    private File outputFile;

    private final InputOutputServices inputOutputServices = new InputOutputServices();
    private final PhoneInfoController phoneInfoController = new PhoneInfoController();
    private final InputOutputController inputOutputController = new InputOutputController();

    private String line;

    public File getInputBaseFile() {
        return inputBaseFile;
    }

    public void setInputBaseFile(File inputBaseFile) {
        this.inputBaseFile = inputBaseFile;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public InputOutputServices getInputOutputServices() {
        return inputOutputServices;
    }

    public PhoneInfoController getPhoneInfoController() {
        return phoneInfoController;
    }

    public InputOutputController getInputOutputController() {
        return inputOutputController;
    }

    public void formBaseList(List<PhoneInfo> list) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(getInputBaseFile()), "utf-8"))) {
            while ((line = fileReader.readLine()) != null) {
                if (line.startsWith("\uFEFF"))
                    line = line.substring(1);

                String[] lines = line.split("\\|");
                list.add(getInputOutputServices().getPhoneInfoServices().formObject(lines));
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void formCoreList(List<Long> core) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(getInputFile()))) {
            while ((line = fileReader.readLine()) != null) {
                if (getPhoneInfoController().isNumberCorrect(line)) {
                    long number = Long.parseLong(line);
                    core.add(number);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void getOutput(StringBuilder result) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(getOutputFile(), StandardCharsets.UTF_8))) {
            fileWriter.write(result.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
