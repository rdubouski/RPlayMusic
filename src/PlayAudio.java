import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayAudio implements Runnable{

    @Override
    public void run() {
        try {
            do {
                Player player = new Player(new FileInputStream("sound/sound.mp3"));
                player.play();
            } while (true);

        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
