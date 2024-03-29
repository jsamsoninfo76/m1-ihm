package util;

import javazoom.jl.decoder.Equalizer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.LillePlayer;


public class MyPlayer {
	
	private LillePlayer player;
	private String currentPath;
	
	private int state;  //0:stop, 1:load, 2:play
	private float volume = 1;
	private int position = 0;

	public MyPlayer(){
		player = null;
		currentPath = "";
		state = 0;
	}
	
	public void Load(String path){
		if(state != 0)
			Stop();
		
		try{
			currentPath = path;
			player = new LillePlayer(currentPath);
			player.setVolume(volume);
			Equalizer eq = new Equalizer();
			eq.getBand(0);
			state = 1;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void PlayPause(){
		if(state == 0){
			Load(currentPath);
			PlayPause();
		}else if(state == 1){
			LaunchListenThread llt = new LaunchListenThread(player);
			llt.start();
			state = 2;
		}else if(state == 2){
			player.pause();
		}
	}
	
	public void Stop(){			
		if(state == 1 || state == 2){
			player.close();
			state = 0;
		}
	}
	
	public float getVolume(){
		return volume;
	}
	
	public void setVolume(float level){
		volume = level;
		player.setVolume(level);
	}
	
	public int getDuration(){
		if(player == null)
			return 0;
		return player.getDuration();
	}
	
	public LillePlayer getMediaPlayer(){
		return player;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosition(int pos){
		player.setPosition(pos);
		position = pos;
	}
	
	class LaunchListenThread extends Thread{
		private LillePlayer playerInterne;
		public LaunchListenThread(LillePlayer p){
			playerInterne = p;
		}
		public void run(){
			try{			
				System.out.println("LaunchEvent");
				PlayThread pt = new PlayThread();
				pt.start();
				
				while(!playerInterne.isComplete()){
					position = playerInterne.getPosition();
					if(player == playerInterne)
						System.out.println("PositionEvent");
					try{
						Thread.sleep(200);
					}catch(Exception e){ e.printStackTrace(); }
				}
				
				if(player == playerInterne)
					System.out.println("EndEvent");
			}catch(Exception e){ e.printStackTrace(); }
		}
		
		class PlayThread extends Thread{
			public void run(){
				try {
					playerInterne.play();
				}catch(JavaLayerException e){ e.printStackTrace(); }
			}
		}
	}
	
	public static void main( String[] args )
	{
		
		if( args.length == 0 )
		{
			System.out.println( "Usage: MyPlayer <filename>" );
			System.exit( 0 );
		}
		
		MyPlayer myPlayer = new MyPlayer();
		myPlayer.Load("musique/"+args[ 0 ]);
		myPlayer.PlayPause();
	}	
}
