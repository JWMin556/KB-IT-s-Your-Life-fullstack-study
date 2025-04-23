package ch09.practice.exercise5;

public class PlaybackLogger {
    public void log(String title, String artist) {
        class RecentLog {
            private String title;
            private String artist;
            public RecentLog(String title, String artist) {
                this.title = title;
                this.artist = artist;
            }

            void printLog() {
                if (this.title.length() >= 10 || this.artist.length() >= 10) {
                    System.out.println("\uD83C\uDFBC 최근 재생: " + this.title + " - " + this.artist + "(인기곡)");
                } else {
                    System.out.println("\uD83C\uDFBC 최근 재생: " + this.title + " - " + this.artist);
                }
            }
        }
        RecentLog recentLog = new RecentLog(title, artist);
        recentLog.printLog();
    }
}
