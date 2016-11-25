package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import base.MyCallBack;

public class Model implements IModel{
	@Override
	public void setNewGame(int level, MyCallBack.SetNewGame callback) {
		// TODO Auto-generated method stub
		List<Integer> solutionList = new ArrayList<Integer>();
		for (int i = 0; i < level * level; i++) {
			solutionList.add(i + 1);
		}

		Collections.shuffle(solutionList);
		callback.success(solutionList);
	}
}
