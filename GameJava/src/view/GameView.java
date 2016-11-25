package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import presenter.GamePresenter;
import presenter.IGamePresenter;

public class GameView extends JFrame implements IGameView, ActionListener{

	IGamePresenter mController;
	
	// view
	JMenuBar mMenuBar;
	JMenu mMenu1, mMenu2, mMenu3;
	JMenuItem mItemNewGame, mItemPause;
	JMenuItem mItemEasy, mItemMedium, mItemHard;
	JMenuItem mItemCheat, mItemAutoPlay, mItemExit, mItemAbout;
	JPanel mPanelBoardGame;
	JLabel mLabelStatus;
	
	// button
	List<JButton> mListButton;
	
	
	// action command;
	private final String NEW_GAME = "NEW_GAME";
	private final String LEVEL_EASY = "LEVEL_EASY";
	private final String LEVEL_MEDIUM = "LEVEL_MEDIUM";
	private final String LEVEL_HARD = "LEVEL_HARD";
	private final String ABOUT = "ABOUT";
	private final String PAUSE = "PAUSE";
	private final String EXIT = "EXIT";
	private final String CHEAT = "CHEAT";
	private final String AUTO_PLAY = "AUTO_PLAY";

	public GameView(GamePresenter controller) {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.mController = controller;
		
		initView();
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		mMenuBar = new JMenuBar();
		mMenu1 = new JMenu();
		mMenu2 = new JMenu();
		mMenu3 = new JMenu();
		mItemNewGame = new JMenuItem();
		mItemPause = new JMenuItem();
		mItemEasy = new JMenuItem();
		mItemMedium = new JMenuItem();
		mItemHard = new JMenuItem();
		mItemCheat = new JMenuItem();
		mItemAutoPlay = new JMenuItem();
		mItemExit = new JMenuItem();
		mItemAbout = new JMenuItem();
		
		mPanelBoardGame = new JPanel();
		mLabelStatus = new JLabel();
		
		//button
		mListButton = new ArrayList<>();
		
		Container mContaint = getContentPane();
		mContaint.setLayout(new BorderLayout());
		
		setTitle("Nhanh tay l\u1eb9 m\u1eaft");
		
		// menu bar
		{
			//menu 1 : game
			{
				mMenu1.setText("Game");
				// item in new game
				{
					mItemNewGame.setText("New Game");
					mItemNewGame.setActionCommand(NEW_GAME);
					mItemNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
					mItemNewGame.addActionListener(this);
				}
				mMenu1.add(mItemNewGame);
				
				// menu LEVEL
				mMenu3.setText("Level");
				//add ỉtem
				{
					// item easy
					mItemEasy.setText("Easy");
					mItemEasy.setActionCommand(LEVEL_EASY);
					mItemEasy.addActionListener(this);
					
					mItemMedium.setText("Medium");
					mItemMedium.setActionCommand(LEVEL_MEDIUM);
					mItemMedium.addActionListener(this);
					
					mItemHard.setText("Hard");
					mItemHard.setActionCommand(LEVEL_HARD);
					mItemHard.addActionListener(this);
					
					mMenu3.add(mItemEasy);
					mMenu3.add(mItemMedium);
					mMenu3.add(mItemHard);
				}
				mMenu1.add(mMenu3);
				
				
			}
			mMenuBar.add(mMenu1);
			
			// menu 2: help
			{
				mMenu2.setText("Help");
				// item ABOUT
				{
					mItemAbout.setText("About");
					mItemAbout.setActionCommand(ABOUT);
					mItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
					mItemAbout.addActionListener(this);
				}
				mMenu2.add(mItemAbout);
			}
			mMenuBar.add(mMenu2);
			
			//=== menu item pause========
			mItemPause.setText("Pause");
			mItemPause.setActionCommand(PAUSE);
			mItemPause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
			mItemPause.addActionListener(this);
			mMenu1.add(mItemPause);
			
			//==== menu item cheat========
			mItemCheat.setText("Cheat");
			mItemCheat.setActionCommand(CHEAT);
			mItemCheat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, 0));
			mItemCheat.addActionListener(this);
			mMenu1.add(mItemCheat);
			
			//==== menu item auto play========
			mItemAutoPlay.setText("Auto play");
			mItemAutoPlay.setActionCommand(AUTO_PLAY);
			mItemAutoPlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0));
			mItemAutoPlay.addActionListener(this);
			mMenu1.add(mItemAutoPlay);
			
			mMenu1.addSeparator();
			mMenu1.addSeparator();
			
			//---- menuItemExit ----
			mItemExit.setText("Exit");
			mItemExit.setActionCommand(EXIT);
			mItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
			mItemExit.addActionListener(this);
			mMenu1.add(mItemExit);
			
		}
		
		setJMenuBar(mMenuBar);
		

		//======== panelBoardGame ========
		{
			mPanelBoardGame.setBackground(Color.white);
			
			// JFormDesigner evaluation mark
			mPanelBoardGame.setBorder(new CompoundBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "JavaIz.com tutorial game",
					TitledBorder.CENTER, TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
					Color.red), mPanelBoardGame.getBorder()));
			mPanelBoardGame.addPropertyChangeListener(new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					// TODO Auto-generated method stub
					if ("border".equals(evt.getPropertyName())) throw new RuntimeException();
				}
			});
			
			mPanelBoardGame.setLayout(new GridLayout(10,  10));
		}
		mContaint.add(mPanelBoardGame, BorderLayout.CENTER);
		
		//==== status==========
		mLabelStatus.setText("Time: 00:00:00");
		mContaint.add(mLabelStatus, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(getOwner());
		
	}

	@Override
	public void setNewGame(List<Integer> solutionList) {
		// TODO Auto-generated method stub
		for (Integer solution : solutionList){
			JButton button = new JButton(String.valueOf(solution));
			button.setForeground(Color.BLUE);
			button.setBackground(Color.BLUE);
			mPanelBoardGame.add(button);
		}
		mPanelBoardGame.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case NEW_GAME:
			mPanelBoardGame.removeAll();
			mController.setNewGame(10);
			break;
			
		case LEVEL_EASY:
			break;
			
		default:
			break;
		}
	}
}
