package cn.vitco.sr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Sterling on 2018/1/31.
 */
@Component
@ConfigurationProperties(prefix = "lucene")
public class LuceneConfig {
    private static String indexPath;
    private static String runMode;


    public static String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        LuceneConfig.indexPath = indexPath;
    }

    public static String getRunMode() {
        return runMode;
    }

    public void setRunMode(String runMode) {
        LuceneConfig.runMode = runMode;
    }
}
