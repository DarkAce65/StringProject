import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherForecast extends JFrame implements ActionListener
{
	private JTextArea location, today, fiveDay;
	private JButton go;


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


	}

	public void actionPerformed(ActionEvent e)
	{
		refresh();
	}

	private void setUpForecaster()
	{
		location = new JTextArea(5, 10);
	    location.setLineWrap(true);
	    location.setWrapStyleWord(true);
	    JPanel locationPanel = new JPanel();
	    locationPanel.add(location);

	    today = new JTextArea(10, 10);
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
	    box1.add(Box.createHorizontalStrut(10));
	    box1.add(locationPanel);
	    box1.add(Box.createHorizontalStrut(10));
	    box1.add(go);
	    box1.add(Box.createHorizontalStrut(10));

	    Box box2 = Box.createHorizontalBox();
	    box2.add(Box.createHorizontalStrut(10));
	    box2.add(todayPanel);
	    box2.add(Box.createHorizontalStrut(100));
	    Box box3 = Box.createVerticalBox();
	    box3.add(box1);
	    box3.add(Box.createVerticalStrut(20));
	    box3.add(box2);

	    Container c = getContentPane();
	    c.setLayout (new FlowLayout());
	    c.add(box3);
	}

	public static void main(String[]args)
	{
		WeatherForecast forecast = new WeatherForecast();
		forecast.setBounds(100, 100, 480, 480);
	    forecast.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    forecast.setVisible(true);
	}

}
