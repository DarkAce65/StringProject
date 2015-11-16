import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherForecast extends JFrame implements ActionListener
{
	private JTextArea location, today;
	private JButton go;
  private WeatherObject weather = new WeatherObject();

	public WeatherForecast()
	{
	    super("WeatherForecast");

	    setUpForecaster();

	    location.setText("City, State");

	    refresh();
	}

	public void refresh()
	{
	    String text = location.getText();
			try{
			  String city = text.substring(0, text.indexOf(','));
			  String state = text.substring(text.indexOf(',') +  2, text.length());
				weather.updateWeatherForecast(city, state);
				today.setText(weather.toString());
		 } catch (StringIndexOutOfBoundsException e){
				today.setText("Please enter the name of a city,\nfollowed by a comma, then a space,\n" +
											"then the name of the state in which the city is located.\n" +
											"E.G. Boston, Massachusetts or  Boston, MA");
			}

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
