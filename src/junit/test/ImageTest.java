package junit.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.unclewoo.utils.ImageSizer;

public class ImageTest {
	@Test
	public void createImage(){
		try {
			ImageSizer.resize(new File("C:\\Users\\King\\Desktop\\1.jpg"), new File("C:\\Users\\King\\Desktop\\1.jpg"), 150 , "jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
