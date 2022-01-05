package solution.view;

import solution.inputOutput.InputAndOutput;
import solution.programmFlow.Flow;

import javax.swing.*;
import java.awt.*;

public class Window {

    private static final InputAndOutput IO = new InputAndOutput();
    private static final Flow FLOW = new Flow();
    private final int width;
    private final int height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static InputAndOutput getIo() {
        return IO;
    }

    public void createProgramWindow() {
        JFrame frame = new JFrame("Telephones");
        frame.setSize(width, height);
        frame.setResizable(false);

        createUI(frame);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void createUI(final JFrame frame) {
        JPanel basePanel = new JPanel();

        JTextField baseField = new JTextField();
        JTextField inputField = new JTextField();
        JTextField outputField = new JTextField();

        LayoutManager layout = new GridLayout(10, 2);
        basePanel.setLayout(layout);

        JButton baseButton = new JButton("Base file");
        final JLabel baseLabel = new JLabel("Select input base file:");
        baseLabel.setSize(400, 10);

        JButton inputButton = new JButton("Input file");
        final JLabel inputLabel = new JLabel("Select input file:");
        inputLabel.setSize(400, 10);

        JButton outputButton = new JButton("Output file");
        final JLabel outputLabel = new JLabel("Select output file:");
        outputLabel.setSize(400, 10);

        JButton startButton = new JButton("Start");

        baseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);

            if (option == JFileChooser.APPROVE_OPTION) {
                IO.setInputBaseFile(fileChooser.getSelectedFile());
                baseField.setText(IO.getInputBaseFile().getAbsolutePath());
            }
        });

        inputButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);

            if (option == JFileChooser.APPROVE_OPTION) {
                IO.setInputFile(fileChooser.getSelectedFile());
                inputField.setText(IO.getInputFile().getAbsolutePath());
            }
        });

        outputButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);

            if (option == JFileChooser.APPROVE_OPTION) {
                IO.setOutputFile(fileChooser.getSelectedFile());
                outputField.setText(IO.getOutputFile().getAbsolutePath());
            }
        });

        startButton.addActionListener(e ->{
            // checking paths
            String input = IO.getInputFile().getAbsolutePath();
            String base = IO.getInputBaseFile().getAbsolutePath();
            String output = IO.getOutputFile().getAbsolutePath();

            if (IO.getInputOutputController().isPathEquals(base, input) ||
                IO.getInputOutputController().isPathEquals(base, output))
                throw new IllegalArgumentException("Check paths!!!");

            FLOW.run();
        });

        basePanel.add(baseLabel);
        basePanel.add(baseField);
        basePanel.add(baseButton);

        basePanel.add(inputLabel);
        basePanel.add(inputField);
        basePanel.add(inputButton);

        basePanel.add(outputLabel);
        basePanel.add(outputField);
        basePanel.add(outputButton);

        basePanel.add(startButton);

        frame.getContentPane().add(basePanel, BorderLayout.CENTER);

    }
}
