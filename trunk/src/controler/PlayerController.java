package controler;

import javazoom.jl.decoder.Equalizer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.LillePlayer;
import model.InformationModel;
import model.JTableModel;
import model.Mp3Model;
import model.PlayerModel;
import view.Player;

public class PlayerController {

	private LillePlayer player;
	private Player view;
	private String currentPath;
	public PlayerModel playermodel;
	public JTableModel tablemodel;
	public InformationController informationcontroller;
	private int state; // 0:stop, 1:load, 2:play
	private float volume = 1;
	private int position = 0;

	public PlayerController(PlayerModel playermodel, JTableModel tablemodel) {
		this.playermodel = playermodel;
		this.tablemodel = tablemodel;
		
		player = null;
		currentPath = "musique/tetris.mp3";
		state = 0;
	}
	
	public Player getView(){
		return view;
	}
	
	public void setView(Player view){
		this.view = view;
	}

	public void Load(String path) {
		if (state != 0)
			Stop();

		try {
			currentPath = path;
			System.out.println(currentPath);
			player = new LillePlayer(currentPath);
			player.setVolume(volume);
			Equalizer eq = new Equalizer();
			eq.getBand(0);
			state = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void PlayPause() {
		if (state == 0) {
			Load(currentPath);
			PlayPause();
		} else if (state == 1) {
			LaunchListenThread llt = new LaunchListenThread(player);
			informationcontroller.getView().getInfo().setText(miseEnPageInfo(tablemodel.getSelectedMp3()));
			llt.start();
			state = 2;
		} else if (state == 2) {
			player.pause();
		}
	}

	private String miseEnPageInfo(Mp3Model selectedMp3) {
		String resultat = selectedMp3.getTitre();
		//resultat += " " + selectedMp3.getArtiste();
		//resultat += " " + selectedMp3.getAlbum();
		return resultat;
 	}

	public void Stop() {
		//System.out.println("Enterring Stop in PlayerController");
		if (state == 1 || state == 2) {
			//System.out.println("Enterring if in Stop with state = " + state);
			player.close();
			state = 0;
		}
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float level) {
		volume = level;
		player.setVolume(level);
	}

	public int getDuration() {
		if (player == null)
			return 0;
		return player.getDuration();
	}

	public LillePlayer getMediaPlayer() {
		return player;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int pos) {
		player.setPosition(pos);
		position = pos;
	}

	class LaunchListenThread extends Thread {
		private LillePlayer playerInterne;

		public LaunchListenThread(LillePlayer p) {
			playerInterne = p;
		}

		public void run() {
			try {
				System.out.println("LaunchEvent");
				PlayThread pt = new PlayThread();
				pt.start();

				while (!playerInterne.isComplete()) {
					position = playerInterne.getPosition();
					if (player == playerInterne)
						System.out.println("PositionEvent");
					try {
						Thread.sleep(200);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (player == playerInterne)
					System.out.println("EndEvent");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		class PlayThread extends Thread {
			public void run() {
				try {
					playerInterne.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void switchMusique() {
		//System.out.println("Enterring switchMusique in PlayerController");
		
		currentPath = (currentPath.equalsIgnoreCase("musique/tetris.mp3")) ? "musique/mario.mp3" : "musique/tetris.mp3";
		Load(currentPath);
		PlayPause();
	}

	public void setInformationController(InformationController informationcontroller) {
		this.informationcontroller = informationcontroller;
	}
}
