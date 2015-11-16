import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherForecast extends JFrame implements ActionListener
{
	private JTextArea location, today, fiveDay;
	private JButton go;
  private WeatherObject weather = new WeatherObject();

	public WeatherForecast()
	{
	    super("WeatherForecast");

	    setUpForecaster();

	    location.setText("City, State");

	    refresh();
	}

	public String getText()
	{
		return location.getText();
	}

	public void refresh()
	{
	    String text = location.getText();
			String city = text.substring(0, text.indexOf(','));
			String state = text.substring(text.indexOf(',') +  2, text.length());

			weather.updateWeatherForecast(city, state);
			today.setText(weather.toString());

	}

	public void actionPerformed(ActionEvent e)
	{
		refresh();
	}

	private void setUpForecaster()
	{
		location = new JTextArea(3, 15);
	    location.setLineWrap(true);
	    location.setWrapStyleWord(true);
	    JPanel locationPanel = new JPanel();
	    locationPanel.add(location);

	    today = new JTextArea(10, 30);
	    today.setEditable(false);
	    today.setBackground(Color.LIGHT_GRAY);
	    today.setLineWrap(true);
	    today.setWrapStyleWord(true);
	    JPanel todayPanel = new JPanel();
	    todayPanel.add(today);

	    fiveDay = new JTextArea(10, 10);
	    fiveDay.setEditable(false);
	    fiveDay.setBackground(Color.LIGHT_GRAY);
	    JPanel fiveDayPanel = new JPanel();
	    fiveDayPanel.add(fiveDay);

	    go = new JButton("Refresh");
	    go.addActionListener(this);

	    Box box1 = Box.createHorizontalBox();
	    box1.add(Box.createHorizontalStrut(5));
	    box1.add(locationPanel);
	    box1.add(Box.createHorizontalStrut(5));
	    box1.add(go);
	    box1.add(Box.createHorizontalStrut(5));

	    Box box2 = Box.createHorizontalBox();
	    box2.add(Box.createHorizontalStrut(5));
	    box2.add(todayPanel);
	    box2.add(Box.createHorizontalStrut(5));

	    Box box3 = Box.createVerticalBox();
			box3.add(Box.createVerticalStrut(10));
	    box3.add(box1);
	    box3.add(Box.createVerticalStrut(20));
			box3.add(Box.createVerticalGlue());
	    box3.add(box2);

	    Container c = getContentPane();
	    c.setLayout (new FlowLayout());
	    c.add(box3);
	}

	public static void main(String[]args)
	{
		WeatherForecast forecast = new WeatherForecast();
		forecast.setBounds(400, 400, 400, 300);
	    forecast.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    forecast.setVisible(true);
	}

}
