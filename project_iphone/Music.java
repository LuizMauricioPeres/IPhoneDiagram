package project_iphone;

public class Music {
    private String name;
//    private String artist;
//    private String album;
    private int duration;
    private int size;

    public String getName(){
        return name;
    }

    public int getDuration(){
        return duration;
    }

    public int getSize(){
        return size;
    }

    public Music(String name, int duration, int size) {
        this.name = name;
        this.duration = duration;
        this.size = size;
    }
}
