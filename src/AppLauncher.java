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
                new WeatherGUI().setVisible(true);
                System.out.println(OracleApp.getLocationData("Tokyo"));

            }
        });
    }
}
