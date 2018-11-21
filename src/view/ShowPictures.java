package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShowPictures extends JFrame
{

	private JPanel contentPane;
	private JButton btnLast, btnNext;
	private JLabel lblForPicture;
//	private int frameWidth = 506, frameHeight = 536;

	/**
	 * Create the frame.
	 * 
	 * @param img.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH)
	 */
	public ShowPictures(BufferedImage img)
	{

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 814);
		setResizable(false);
//		frameWidth = getBounds().width;
//		frameHeight = getBounds().height;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		btnLast = new JButton("<");
		panel.add(btnLast);

		btnNext = new JButton(">");
		panel.add(btnNext);

		lblForPicture = new JLabel("");
		contentPane.add(lblForPicture, BorderLayout.CENTER);

//		addComponentListener(new ComponentAdapter()
//		{
//			@Override
//			public void componentResized(ComponentEvent arg0)
//			{
//
//				Rectangle b = arg0.getComponent().getBounds();
//				arg0.getComponent().setBounds(b.x, b.y, b.width, b.width * frameHeight / frameWidth );
//				frameWidth = arg0.getComponent().getWidth();
//				frameHeight = arg0.getComponent().getHeight();
//			}
//		});
	}

	public void setImage(BufferedImage img)
	{
		lblForPicture.setIcon(new ImageIcon(
				img.getScaledInstance(lblForPicture.getWidth(), lblForPicture.getHeight(), Image.SCALE_SMOOTH)));
	}

	public void addBtnNextPicListener(ActionListener listener)
	{
		btnNext.addActionListener(listener);
	}

	public void addBtnLastPicListener(ActionListener listener)
	{
		btnLast.addActionListener(listener);
	}

}
