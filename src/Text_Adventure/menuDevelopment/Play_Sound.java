package Text_Adventure.menuDevelopment;

import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;

public class Play_Sound {


    private AudioInputStream audio_stream;
    private SourceDataLine source_line;
    private AudioFormat audio_format;
    private int buffer = 128000;
    private File WavFile;

    /**
     * Nemanja: This plays a sound file .wav
     *
     * @param soundFile name of the sound file that will be played.
     */
    public void playSound(String soundFile) {

        String filename = soundFile;

        try {
            WavFile = new File(filename);
        } catch (Exception e) {
            System.out.println("Ooops! Something went wrong! Cannot locate " + filename);
        }

        try {
            audio_stream = AudioSystem.getAudioInputStream(WavFile);
        } catch (Exception e) {
            System.out.println("Ooops! Something went wrong!");
        }

        audio_format = audio_stream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audio_format);
        try {
            source_line = (SourceDataLine) AudioSystem.getLine(info);
            source_line.open(audio_format);
        } catch (LineUnavailableException e) {
            System.out.println("Ooops! Something went wrong!");
        } catch (Exception e) {
            System.out.println("Ooops! Something went wrong!");
        }

        source_line.start();

        int read_bytes_number = 0;
        byte[] byte_Array = new byte[buffer];
        while (read_bytes_number != -1) {
            try {
                read_bytes_number = audio_stream.read(byte_Array, 0, byte_Array.length);
            } catch (IOException e) {
                System.out.println("Ooops! Something went wrong!");
            }
            if (read_bytes_number >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = source_line.write(byte_Array, 0, read_bytes_number);
            }
        }

        source_line.drain();
        source_line.close();
    }
}
