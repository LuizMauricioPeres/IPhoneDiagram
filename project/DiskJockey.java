package project;
public interface DiskJockey {
    void play();
    void pause();
    void stop();
    void next();
    void previous();
    void selectTrack(int trackNumber);
    void selectMusic();
}
