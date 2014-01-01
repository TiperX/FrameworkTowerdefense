package states;

import java.util.ArrayList;

import data.Constants;
import data.Listener;
import data.Settings;
import data.exceptions.NoSuchStateException;

public class StateManager {
	
	
	private static ArrayList<State> stateList;

	public static void launch(Settings.STATES s) {
		Listener l = new Listener();
		
		Settings.setStateMap();
		stateList = new ArrayList<State>();
		addState(s);
		
		if (Settings.useMouse){
			Constants.window.addMouseListener(l);
			Constants.window.addMouseMotionListener(l);
		}else{
			Constants.window.addKeyListener(l);
		}
		loop();
	}
	
	@SuppressWarnings("rawtypes")
	public static void addState(Settings.STATES s){
		try {
			if (s == null){
				throw new NoSuchStateException("null");
			}
			
			Class state = Settings.states.get(s);
	
			stateList.add((State) state.newInstance());
		} catch (NoSuchStateException | InstantiationException | IllegalAccessException e) {
			exception(e);
		}
	}
	
	public static void exception(Exception e){
		stateList = new ArrayList<State>();
		stateList.add(new ErrorReport(e));
	}
	
	public static void removeState(){
		stateList.remove(stateList.size()-1);
	}
	
	public static void changeState(Settings.STATES s){
		removeState();
		addState(s);
	}
	
	public static State getState(){
		return stateList.get(stateList.size()-1);
	}
	
	@SuppressWarnings("static-access")
	private static void loop(){
		long deltaTime = 0;
		long last = System.currentTimeMillis();
		while (Constants.running){
			deltaTime = System.currentTimeMillis() - last;
			last = System.currentTimeMillis();
			
			stateList.get(stateList.size()-1).update(deltaTime);
			
			Constants.image = Constants.window.createImage(Constants.stageWidth, Constants.stageHeight);
			Constants.graphics = Constants.image.getGraphics();
			
			stateList.get(stateList.size()-1).draw(Constants.graphics);
			
			for (int i = 0; i < StateManager.getState().buttons.size(); i++){
				stateList.get(stateList.size()-1).buttons.get(i).draw(Constants.graphics);
			}
			Constants.window.repaint();
		}
	}
}
