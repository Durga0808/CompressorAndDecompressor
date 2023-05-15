package Compress_Decompress;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file) throws IOException{

        String fileDirectory=file.getParent();
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzip=new GZIPInputStream(fis);
        FileOutputStream fos=new FileOutputStream(fileDirectory+"/DecompressedFile");

        byte[]buffer=new byte[1024];
        int length;
        while((length=gzip.read(buffer))!=-1){
            fos.write(buffer, 0, length);
        }

        gzip.close();
        fis.close();
        fos.close();

    }

    public static void main(String[] args) throws IOException {
        File path=new File("/Users/Ideapad/Desktop/java_mini_projects/compressed.gz");
        method(path);
    }
}