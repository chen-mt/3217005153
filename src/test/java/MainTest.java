import java.io.IOException;

public class MainTest {

    @org.junit.Test
    public void testMain(){
        String[] paths = {
                "E:\\test\\orig.txt",
                "E:\\test\\orig_0.8_dis_15.txt",
                "E:\\test\\ans.txt"
        };
        try {
            PaperPass.main(paths);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO流异常");
        }
    }
}
