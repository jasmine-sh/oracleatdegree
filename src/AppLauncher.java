import javax.swing.*;

public class AppLauncher
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            // displays gui
            {
                //Object WeatherGUI = new WeatherGUI().setVisible(true);
                //System.out.println(OracleApp.getLocationData("Tokyo"));
                System.out.println(OracleApp.getWeatherData("Long Beach"));
                System.out.println(OracleApp.getCurrentDay());
            }
        });
    }
}
