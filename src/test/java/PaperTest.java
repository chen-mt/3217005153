import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PaperTest {

    Paper paper = new Paper(new HashSet<String>());

    /**
     * 测试Paper类的构造方法
     */
    @Test
    public void paperTest(){
        String path = "E://test//origin.txt";
        try {
            new Paper(path, new HashSet<String>());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e1){
            e1.printStackTrace();
            System.out.println("IO流异常");
        }
    }

    /**
     * 测试文本分词
     */
    @Test
    public void testSplit(){
        String s = "一位真正的作家永远只为内心写作";
        paper.split(s);
        Set<String> features = (HashSet<String>) paper.getFeatures();
        for(String feature: features){
            System.out.println(feature);
        }
    }

    /**
     * 测试是否为标点符号
     */
    @Test
    public void testIsPunctuation(){
        String s = "，。符号尖酸刻薄？！测试";
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(paper.isPunctuation(c)){
                System.out.print(c);
            }
        }
    }
}
