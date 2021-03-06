package com.src.android_chess;

import java.util.ArrayList;

import android.content.Context;
import android.widget.Toast;

import com.src.game.Playback;

/**
 * Singleton class that represents a global variable that controls the 
 * save status of games. This is a hack because I don't know how to do
 * actual global variables in Android. But yay for design patterns!
 * 
 * @author Indraneel Purohit
 */

public class Globals {
	private static ArrayList<Playback> savedGames;
	public static ArrayList<Playback> getSavedGames() {
    	return savedGames;
    }

	public static void setSavedGames(ArrayList<Playback> savedGames) {
    	Globals.savedGames = savedGames;
    }

	private static Globals instance;
	private static GameList gameList;
	private static Square selectedSquare = null;
	private static Playback playback;
	private static boolean selected = false;
	private static boolean saveGames = false;
	private static boolean whiteWinner;
	private static boolean draw;
	
	static {
        instance = new Globals();
        savedGames = new ArrayList<Playback>();
    }
	
	private Globals() {
    	super();
    }
	
	/**
	 * @return The GameList manager responsible for storing saved chess games.
	 */
	public static GameList getGameList() {
		return gameList;
	}

	public void setWhiteWinner(){
		this.whiteWinner = true;
	}
	
	public void setBlackWinner(){
		this.whiteWinner = false;
	}
	
	public void setDraw(){
		this.draw = true;
	}
	
	public void endDraw(){
		this.draw = false;
	}
	
    public boolean isSavingGames() {
        return this.saveGames;
    }

    public boolean isSelectedPiece(){
    	return selected;
    }

    public void setSavingGames(boolean saveGames) {
        this.saveGames = saveGames;
    }

    public void toaster(Context context, CharSequence text){
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

    public void toggleSavingGames() {
        saveGames = !saveGames;
    }
    
    public void toggleSelected(){
    	setSelectedSquare(null);
    	selected = !selected;
    }
    
	public void toggleSelected(Square s){
    	setSelectedSquare(s);
    	selected = !selected;
    }

	public static Globals getInstance() {
    	if(instance == null)
    		instance = new Globals();
    	
        return Globals.instance;
    }
    
    public static Playback getPlayback() {
    	return playback;
    }
    
    public static Square getSelectedSquare() {
		return selectedSquare;
	}

	public static void setPlayback(Playback playback) {
    	Globals.playback = playback;
    }

	public static void setSelectedSquare(Square selectedSquare) {
		Globals.selectedSquare = selectedSquare;
	}

}
