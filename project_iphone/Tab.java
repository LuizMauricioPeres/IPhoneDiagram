package project_iphone;

public class Tab {
    private String url = "https://www.google.com.br";

    public void openPage(String url) {
        if (!url.isEmpty()) {
            this.url = url;
        }
        int i = 0;
        String dot = ".";

        // not considering internet connection and cache page
        while ( i < 100) {
            i+= Math.random()*10; // simulate loading time of a page
            System.out.println("Opening " + this.url + dot.repeat(i/10));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
