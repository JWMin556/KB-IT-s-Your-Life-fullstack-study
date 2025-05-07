package ch16.practice.ex4;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        PhotoAlbum album = new PhotoAlbum();

        //출력용 consumer
        Consumer<Photo> printer = System.out::println;

        System.out.println("[📸 사진 촬영 중...]");
        album.addPhoto(new Photo("지우", "브이✌️"), printer);
        album.addPhoto(new Photo("이슬이", "하트❤\uFE0F"), printer);
        album.addPhoto(new Photo("웅이", "'메타몽 모자\uD83C\uDFA9"), printer);

        Predicate<Photo> heartPoseFilter = (p -> p.getPose().equals("하트❤\uFE0F"));
        System.out.println("[\uD83D\uDCE4 SNS에 업로드된 사진 목록]");
        album.printFiltered(heartPoseFilter, printer);
    }
}
