package principles.SOLID;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Single Responsability
 * Open for extension closed for modification
 * Liskov Substitution
 */
public class SOLID {

    @Test
    public void test(){
        List<MediaPlayer> allPlayers = new ArrayList<>();
        allPlayers.add(new VLCMediaPlayer());
        allPlayers.add(new WinampMediaPlayer());
    }


}


