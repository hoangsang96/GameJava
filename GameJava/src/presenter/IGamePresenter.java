package presenter;

public interface IGamePresenter {
	void setNewGame(int level);
	
	void startGame();
	
	void pauseGame();
	
	void cheat(boolean isUser);
	
	void autoPlay();
	
}
