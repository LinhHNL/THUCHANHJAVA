package Repository;

import org.springframework.context.annotation.Bean;

import java.io.FileNotFoundException;

public interface TextWrite {

    void write(String filename,String text) ;
}
