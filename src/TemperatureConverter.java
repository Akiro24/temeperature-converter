import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TemperatureConverter extends JFrame {

    JTextField value;
    JComboBox temperatureOptions;

    TemperatureConverter() {

        JLabel celciusLabel = new JLabel("0", JLabel.CENTER);
        celciusLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        JScrollPane celciusLabelScroll = new JScrollPane(celciusLabel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        celciusLabelScroll.setBounds(10, 10, 300, 100);

        JLabel fahrenheitLabel = new JLabel("32", JLabel.CENTER);
        fahrenheitLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        JScrollPane fahrenheitLabelScroll = new JScrollPane(fahrenheitLabel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        fahrenheitLabelScroll.setBounds(10, 120, 300, 100);

        JLabel kelvinLabel = new JLabel("273.15", JLabel.CENTER);
        kelvinLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        JScrollPane kelvinLabelScroll = new JScrollPane(kelvinLabel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        kelvinLabelScroll.setBounds(10, 230, 300, 100);

        JLabel cSymbol = new JLabel("°C");
        cSymbol.setBounds(330, 10, 100, 100);
        cSymbol.setFont(new Font("Arial", Font.BOLD, 50));
        cSymbol.setForeground(Color.GRAY);

        JLabel fSymbol = new JLabel("°F");
        fSymbol.setBounds(330, 120, 100, 100);
        fSymbol.setFont(new Font("Arial", Font.BOLD, 50));
        fSymbol.setForeground(Color.GRAY);

        JLabel kSymbol = new JLabel("°K");
        kSymbol.setBounds(330, 230, 100, 100);
        kSymbol.setFont(new Font("Arial", Font.BOLD, 50));
        kSymbol.setForeground(Color.GRAY);

        String[] temperatureUnits = { "°C", "°F", "°K" };
        temperatureOptions = new JComboBox(temperatureUnits);
        temperatureOptions.setBounds(10, 350, 50, 25);
        temperatureOptions.setFont(new Font("Arial", Font.BOLD, 20));
        temperatureOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                value.setText(value.getText());

            }

        });

        value = new JTextField();
        value.setText("0");
        value.setBounds(70, 350, 325, 25);
        value.setFont(new Font("Arial", Font.BOLD, 20));
        value.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                try {

                    if (!value.getText().equals("")) {

                        switch (temperatureOptions.getSelectedIndex()) {

                            case 0:

                                celciusLabel.setText(value.getText());

                                fahrenheitLabel
                                        .setText(String.format("%.4f",
                                                celciusToFahrenheit(Double.parseDouble(value.getText()))));

                                kelvinLabel
                                        .setText(String.format("%.4f",
                                                celciusToKelvin(Double.parseDouble(value.getText()))));

                                break;

                            case 1:

                                celciusLabel
                                        .setText(String.format("%.4f",
                                                fahrenheitToCelsius(Double.parseDouble(value.getText()))));

                                fahrenheitLabel.setText(value.getText());
                                ;

                                kelvinLabel
                                        .setText(String.format("%.4f",
                                                fahrenheitToKelvin(Double.parseDouble(value.getText()))));

                                break;

                            case 2:

                                celciusLabel.setText(String.format("%.4f",
                                        kelvinToCelsius(Double.parseDouble(value.getText()))));

                                fahrenheitLabel.setText(String.format("%.4f",
                                        kelvinToFahrenheit(Double.parseDouble(value.getText()))));

                                kelvinLabel.setText(value.getText());

                                break;

                        }

                    }

                } catch (Exception e1) {

                    celciusLabel.setText("");
                    fahrenheitLabel.setText("");
                    kelvinLabel.setText("");

                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                try {

                    if (!value.getText().equals("")) {

                        switch (temperatureOptions.getSelectedIndex()) {

                            case 0:

                                celciusLabel.setText(value.getText());

                                fahrenheitLabel
                                        .setText(String.format("%.4f",
                                                celciusToFahrenheit(Double.parseDouble(value.getText()))));

                                kelvinLabel
                                        .setText(String.format("%.4f",
                                                celciusToKelvin(Double.parseDouble(value.getText()))));

                                break;

                            case 1:

                                celciusLabel
                                        .setText(String.format("%.4f",
                                                fahrenheitToCelsius(Double.parseDouble(value.getText()))));

                                fahrenheitLabel.setText(value.getText());
                                ;

                                kelvinLabel
                                        .setText(String.format("%.4f",
                                                fahrenheitToKelvin(Double.parseDouble(value.getText()))));

                                break;

                            case 2:

                                celciusLabel.setText(String.format("%.4f",
                                        kelvinToCelsius(Double.parseDouble(value.getText()))));

                                fahrenheitLabel.setText(String.format("%.4f",
                                        kelvinToFahrenheit(Double.parseDouble(value.getText()))));

                                kelvinLabel.setText(value.getText());

                                break;

                        }

                    }

                } catch (Exception e1) {

                    celciusLabel.setText("");
                    fahrenheitLabel.setText("");
                    kelvinLabel.setText("");

                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub

            }

        });

        this.add(celciusLabelScroll);
        this.add(fahrenheitLabelScroll);
        this.add(kelvinLabelScroll);
        this.add(cSymbol);
        this.add(fSymbol);
        this.add(kSymbol);
        this.add(temperatureOptions);
        this.add(value);

        this.setTitle("TEMPERATURE CONVERTER");
        this.setSize(425, 430);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        new TemperatureConverter();

    }

    double celciusToFahrenheit(Double value) {

        return (value * 1.8) + 32;

    }

    double celciusToKelvin(double value) {

        return value + 273.15;

    }

    double fahrenheitToCelsius(double value) {

        return (value - 32) * 5 / 9;

    }

    double fahrenheitToKelvin(double value) {

        return fahrenheitToCelsius(value) + 273.15;

    }

    double kelvinToCelsius(double value) {

        return value - 273.15;

    }

    double kelvinToFahrenheit(double value) {

        return (value - 273.15) * 9 / 5 + 32;

    }

}