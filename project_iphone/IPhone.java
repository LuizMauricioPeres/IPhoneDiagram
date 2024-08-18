package project_iphone;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import exceptions.InCallExection;
import exceptions.PowerExcption;
import project.*;

public class IPhone implements Celular, Browse, DiskJockey {

    private boolean power = false;

    private boolean inCall = false;

    private boolean inMusic = false;

    private boolean isMute = false;
    private int volume = 6;

    static private String dot = ".";
    private List<Tab> tabs = new ArrayList<Tab>();
    private Tab actualTab = new Tab();
    private List<Music> musics = new ArrayList<Music>();
    private int actualTrack = 0;
    private final String myNumber;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public IPhone() {
        this.myNumber = utilsTest.generateRandomNumberPhone();
    }

    static int getSignal() {
        int signal = (int) (Math.random()*5);
        return signal;
    }

    @Override
    public void power() {
        power = !power;
    }

    @Override
    public void VolumeDown() {
        if (!power){
            throw new PowerExcption();
        }
        if (volume > 0) {
            volume--;
        }
    }

    @Override
    public void volumeUp() {
        if (!power){
            throw new PowerExcption();
        }
        if (volume < 10) {
            volume++;
        }
        setMuteOFF();
    }

    @Override
    public void mute() {
        if (!power){
            throw new PowerExcption();
        }
        isMute = !isMute;
    }

    public void setMuteOFF() {
        if (!power){
            throw new PowerExcption();
        }
        isMute = false;
    }

    public void setPauseOFF() {
        if (!power){
            throw new PowerExcption();
        }
        isMute = false;
    }

    @Override
    public void call(String number) {
        if (!power){
            throw new PowerExcption();
        }
        if (inCall) {
            throw new InCallExection("Already in call");
        }
        boolean walkingInMusic = musicInPlay();
        if (walkingInMusic) {
            pause();
        }

        if (simulateAction(number) ){
            System.out.println("Hello " + number);
        };

        try {
            Thread.sleep( (int) Math.max( Math.random()*1000, 3000) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (walkingInMusic) {
            setPauseOFF();
        }

    }

    @Override
    public void receiveCall(String number) {
        if (!power){
            throw new PowerExcption();
        }
        if(Math.random()*20 > 15-getSignal()) {
            if (simulateAction(number)) {
                System.out.println("Hello " + this.myNumber);
            }
        }
    }


    @Override
    public void browse() {
        if (!power){
            throw new PowerExcption();
        }
        String url = "";
        System.out.println("Enter URL: ");
        try{
            url=br.readLine();
        }catch (Exception e){
            url="";
        }

        if (tabs.isEmpty()) {
            newTab();
        }
        actualTab.openPage(url);
    }

    @Override
    public void download(String url) {
        if (!power){
            throw new PowerExcption();
        }
        try{
            InputStream in = new URL(url).openStream();
            Files.copy(in, Paths.get(url), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void newTab() {
        if (!power){
            throw new PowerExcption();
        }
        actualTab = new Tab();
        tabs.add(actualTab);
    }

    @Override
    public void openPage(String url) {
        if (!power){
            throw new PowerExcption();
        }
        actualTab.openPage(url);
    }

    @Override
    public void refresh() {
        if (!power){
            throw new PowerExcption();
        }
        openPage("");
    }

    @Override
    public void search(String word) {
        if (!power){
            throw new PowerExcption();
        }
        actualTab.openPage("https://www.google.com.br/search?q=" + word);
    }

    @Override
    public void pause() {
        if (!power){
            throw new PowerExcption();
        }
        inMusic = !inMusic;
    }

    @Override
    public void play() {
        if (!power){
            throw new PowerExcption();
        }
        selectTrack(actualTrack);
        inMusic = true;
    }

    @Override
    public void next() {
        if (!power){
            throw new PowerExcption();
        }
        selectTrack(actualTrack+1);
    }

    @Override
    public void previous() {
        if (!power){
            throw new PowerExcption();
        }
        selectTrack(actualTrack-1);
    }

    @Override
    public void selectMusic() {
        if (!power){
            throw new PowerExcption();
        }
        String music;
        System.out.println("Select music: ");
        try{
            music=br.readLine();
        }catch (Exception e){
            music="";
        }

        for (int i = 0; i < musics.size(); i++) {
            if (musics.get(i).getName().equals(music)) {
                selectTrack(i);
                break;
            }
        }
    }

    @Override
    public void selectTrack(int trackNumber) {
        if (!power){
            throw new PowerExcption();
        }
        if ( trackNumber > 0 && trackNumber <= musics.size() ) {
            actualTrack = trackNumber-1;
            play();
        }
    }

    @Override
    public void stop() {
        if (!power){
            throw new PowerExcption();
        }
        if (inMusic) {
            inMusic = false;
        }
    }

    private boolean musicInPlay() {
        return inMusic;
    }

    private boolean simulateAction(String number) {
        int i = 0;
        int signal;
        for ( i = 0; i < 10; i++ ) {
            signal = getSignal();
            if (signal > 0) {
                System.out.println("Calling " + number + dot.repeat(i));
                System.out.println("tone");
                if (Math.random()*20 > 15-signal) {
                    break;
                }
            }
        }
        return (i<10);
     }

}