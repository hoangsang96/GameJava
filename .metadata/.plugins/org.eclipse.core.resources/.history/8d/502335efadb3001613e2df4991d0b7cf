package presenter;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import base.MyCallBack;
import model.Model;
import view.GameView;

public class GamePresenter implements IGamePresenter{
	Model mModel;
	GameView mView;
	
	public GamePresenter() {
		// TODO Auto-generated constructor stub
		if (mView == null){
			mView = new GameView(this);
		}
		
		if (mModel == null){
			mModel = new Model();
		}
		
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
			public void success(List<Integer> number) {
				// TODO Auto-generated method stub
				mView.setNewGame(number);
			}
			
			@Override
			public void failure() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
