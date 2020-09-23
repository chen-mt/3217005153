import java.util.*;

/**
 * 论文比较类
 */
public class PaperComparator {

    private static int count = 0;

    /**
     * 将原始论文和抄袭论文的文本特征进行比较，
     * 如果抄袭论文中的文本特征和原始论文的文本特征有相同的，则count加一
     *
     * @param originPaper 原始论文
     * @param copyPaper   抄袭论文
     * @return 抄袭论文的文本特征的重复数
     */
    @SuppressWarnings(value = "unchecked")
    public int compare(Paper originPaper, Paper copyPaper) {
        Set<String> originFeatures = (HashSet<String>) originPaper.getFeatures();
        List<String> copyFeatures = (ArrayList) copyPaper.getFeatures();
        for (String s : copyFeatures) {
            if (originFeatures.contains(s)) {
                count++;
            }
        }
        return count;
    }
}