package presenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import base.MyCallBack;
import model.GameButton;
import model.Model;
import view.GameView;
import view.Status;

public class GamePresenter implements IGamePresenter{
	Model mModel;
	GameView mView;
	
	List<GameButton> listButons;
	
	public List<GameButton> getListButons() {
		return listButons;
	}

	public GamePresenter() {
		// TODO Auto-generated constructor stub
		String plaf = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		try {
			UIManager.setLookAndFeel(plaf);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		if (mView == null){
			mView = new GameView(this);
		}
		
		if (mModel == null){
			mModel = new Model();
		}
		
		listButons = new ArrayList<>();
		
		this.mView.setSize(1000, 700);
		this.mView.repaint();
		this.mView.setVisible(true);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.mView.setLocation(dimension.width/2 - this.mView.getSize().width/2, dimension.height/2 - this.mView.getHeight()/2);
		
	}

	public static void main(String[] args) {
		GamePresenter gameController = new GamePresenter();
	}

	@Override
	public void setNewGame(int level) {
		// TODO Auto-generated method stub
		
		mModel.setNewGame(level, new MyCallBack.SetNewGame() {
			
			@Override
			public void success(List<Integer> solutionList) {
				// TODO Auto-generated method stub
				if (listButons != null){
					listButons.clear();
				}else {
					listButons = new ArrayList<>();
				}
				
				for (Integer solution : solutionList){
					GameButton button = new GameButton(String.valueOf(solution));
					button.setBackground(Color.blue);
					button.setForeground(Color.blue);
					
					button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (mView.STATUS == Status.NEW_GAME) {
								startGame();	
							}else{
								handleClickButton(button);
							}
							
						}
					});
					listButons.add(button);
					
				}
				mView.setNewGame(listButons);
				
			
			}
			
			@Override
			public void failure() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	private void handleClickButton(GameButton button) {
		int inGame = Integer.parseInt(button.getText());
		System.out.println("Button click " + inGame);
	
		if (mView.InGame+1 == inGame){
			if (inGame == 100) {
				finishGame();
				
			}else{
				mView.InGame = inGame;
				button.setBackground(Color.GREEN);
				mView.notifySetChange();
		
			}
			
			mView.resetTimer(mView.LEVEL);
		}
	}
	
	private void finishGame() {
		// TODO Auto-generated method stub
		System.out.println("You won");
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		for (GameButton button : listButons){
			button.setBackground(Color.white);
		}
		mView.STATUS = Status.PLAYING;
		mView.resumeTimer();
		mView.notifySetChange();
	}

	@Override
	public void pauseGame() {
		// TODO Auto-generated method stub
		if (mView.STATUS == Status.PAUSE){
			for (GameButton button : listButons){
				button.setBackground(Color.BLUE);
			}
			
		}else{
			for (int i = 0; i < listButons.size(); i++){
				GameButton button = listButons.get(i);
				if (Integer.parseInt(button.getText()) <= mView.InGame)
					button.setBackground(Color.GREEN);
				else
					button.setBackground(Color.WHITE);
			}
		}
		
		mView.notifySetChange();
	}

	@Override
	public void cheat(boolean isUser) {
		// TODO Auto-generated method stub
		for (GameButton button : listButons){
			if (Integer.parseInt(button.getText()) == mView.InGame+1){
				if (isUser)
					button.setBackground(Color.green);
				else
					button.setBackground(Color.red);
				
				mView.InGame++;
				mView.notifySetChange();
				
				return;
			}
		}
	}

	@Override
	public void autoPlay() {
		// TODO Auto-generated method stub
		for (GameButton button : listButons){
			if (Integer.parseInt(button.getText()) > mView.InGame){
				button.setBackground(Color.RED);
			}
		}
		mView.InGame = 100;
		mView.notifySetChange();
		win();
	}

	@Override
	public void win() {
		// TODO Auto-generated method stub
		System.out.println("You win !");
	}
}
