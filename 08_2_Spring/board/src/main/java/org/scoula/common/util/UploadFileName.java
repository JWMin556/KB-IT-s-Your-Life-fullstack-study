package org.scoula.common.util;

public class UploadFileName {
    public static String getUniqueName(String fileName) {
        int ix = fileName.lastIndexOf(".");
        String name = fileName.substring(0, ix);  //파일명 추출
        String ext = fileName.substring(ix + 1); // 확장자 추출
        return String.format("%s-%d.%s", name, System.currentTimeMillis(), ext);
    }
}
