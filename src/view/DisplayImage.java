package view;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DisplayImage extends JFrame
{

	private static final long serialVersionUID = -4070771383628075170L;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public DisplayImage(Image img)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 30, img.getWidth(this)+50, img.getHeight(this)+50);
		contentPane = new JPanel();
		//contentPane.setSize(img.getWidth(this), img.getHeight(this));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setIcon(new ImageIcon(img));
	}

}
