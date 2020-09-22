import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Pattern;

public class Paper<T extends Collection> {

    private T features;

    public Paper(String path, T features) throws IOException {
        this.features = features;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null){
                split(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } finally {
            br.close();
        }
    }

    /**
     * 获取文本特征
     */
    public T getFeatures(){
        return features;
    }

    /**
     * 将字符串以两个字符为单元有重叠地进行切割，切割的结果存入HashSet中。
     * 例如：“一位真正的作家”分词后的结果：一位、位真、真正、正的、的作、作家。
     */
    public void split(String s){
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length - 1; i++){
            if(isPunctuation(chars[i]) || isPunctuation(chars[i + 1]))
                continue;
            features.add(new String(chars, i, 2));
        }
    }

    /**
     * 判断字符是否为标点符号
     */
    public Boolean isPunctuation(char c){
        // 中文标点符号的正则表达式
        Pattern pattern = Pattern.compile("[\\u3002\\uff1f\\uff01\\uff0c\\u3001\\uff1b\\uff1a\\u201c\\u201d\\u2018" +
                "\\u2019\\uff08\\uff09\\u300a\\u300b\\u3008\\u3009\\u3010\\u3011\\u300e\\u300f\\u300c\\u300d\\ufe4" +
                "3\\ufe44\\u3014\\u3015\\u2026\\u2014\\uff5e\\ufe4f\\uffe5]");
        return pattern.matcher(String.valueOf(c)).find();
    }

}
