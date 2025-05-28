import netscape.javascript.JSObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherGUI extends JFrame
{
    private JSObject weatherData;
    public WeatherGUI()
    {
        super("Oracle at Degree");


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TODO: make responsive?
        setSize(450, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        addGuiComponents();
    }

    private void addGuiComponents()
    {
        // search field
        JTextField searchTextField = new JTextField();
        searchTextField.setBounds(15, 15, 351, 45);
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(searchTextField);

        // search button
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // get location from user
                String locationInput = searchTextField.getText();
                // validate location input (ignore an all-whitespace search)
                if(locationInput.replaceAll("\\s", "").length() <= 0)
                    return;
            }

            //retrieve weather data
            // weatherData = OracleApp.getWeatherData(userInput);
        });
        add(searchButton);

        String[] months = {"01 - January", "02 - February", "03 - March", "04 - April", "05 - May", "06 - June",
                "07 - July", "08 - August", "09 - September", "10 - October", "11 - November", "12 - December"};
        JComboBox<String> monthSelect = new JComboBox<String>(months);
        monthSelect.setBounds(50, 100, 150, 54);
        monthSelect.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(monthSelect);
        monthSelect.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                 String monthInput = (String) monthSelect.getSelectedItem();
            }
        });

        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> daySelect = new JComboBox<String>(days);
        daySelect.setBounds(250, 100, 150, 54);
        daySelect.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(daySelect);
        daySelect.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String dayInput = (String) daySelect.getSelectedItem();
                System.out.println(dayInput);
            }
        });



        // weather conditions image
        JLabel conditionsImage = new JLabel(loadImage("src/assets/cloudy.png"));
        conditionsImage.setBounds(0, 125, 450, 217);
        add(conditionsImage);

        // temperature display
        JLabel temperatureText = new JLabel("10 F");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        // weather conditions description
        JLabel conditionsDescription = new JLabel("Cloudy");
        conditionsDescription.setBounds(0, 405, 450, 36);
        conditionsDescription.setFont(new Font("Dialog", Font.PLAIN, 32));
        conditionsDescription.setHorizontalAlignment(SwingConstants.CENTER);
        add(conditionsDescription);

        // humidity image
        JLabel humidityImage = new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        // humidity text
        // TODO: why is he doing it like this
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        //  winds peed image
        JLabel windspeedImage = new JLabel(loadImage("src/assets/windspeed.png"));
        windspeedImage.setBounds(220, 500, 74, 66);
        add(windspeedImage);

        // winds peed text
        JLabel windspeedText = new JLabel("<html><b>Wind Speed</b> 100%</html>");
        windspeedText.setBounds(310, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);

    }

    private ImageIcon loadImage(String resourcePath)
    {
        try
        {
            BufferedImage image = ImageIO.read(new File(resourcePath));
            return new ImageIcon(image);
        }catch(IOException exception)
        {
            exception.printStackTrace();
        }

        System.out.println("Couldn't find picture :(");
        return null;
    }
}
