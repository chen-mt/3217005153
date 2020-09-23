import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 论文查重类
 */
public class PaperPass {

    /**
     * 示例中传入三个参数，其中args[0]代表原始论文存储路径，
     * args[1]代表抄袭论文存储路径，args[2]代表论文查重后结果文件的存储路径
     * @param args 传入的参数
     */
    public static void main(String[] args) throws IOException{
        PaperComparator comparator = new PaperComparator();
        // 初始化原始论文和抄袭论文
        Paper originPaper = new Paper<>(args[0], new HashSet<String>());
        Paper copyPaper = new Paper<>(args[1], new ArrayList<String>());
        int repeatCount = comparator.compare(originPaper, copyPaper);

        // 计算重复率
        double rate = (double) repeatCount / copyPaper.getFeatures().size();

        // 将重复率写入答案文件
        File file = new File(args[2]);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        fw.write("原文论文路径：" + args[0] + "\n");
        fw.write("抄袭论文路径：" + args[1] + "\n");
        fw.write("重复率：" + String.format("%.2f", rate) + "\n\n");
        fw.close();
    }

}
