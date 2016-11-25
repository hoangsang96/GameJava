package base;

import java.util.List;

public interface MyCallBack {
	interface SetNewGame{
		void success(List<Integer> number);
		void failure();
	}
}
