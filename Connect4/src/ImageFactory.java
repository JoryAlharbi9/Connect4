import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class ImageFactory {
    // Map to store shared icons (Flyweight Pool)
    private static final Map<String, Icon> iconCache = new HashMap<>();

    // Method to get the icon, returning it directly from cache if it already exists to avoid reloading
    public static Icon getScaledIcon(String imageName, int width, int height) {
        String key = imageName + "_" + width + "_" + height;
        
        if (!iconCache.containsKey(key)) {
            java.net.URL imgURL = ImageFactory.class.getResource(imageName);
            if (imgURL != null) {
                Icon icon = new ImageIcon(
                    new ImageIcon(imgURL)
                        .getImage()
                        .getScaledInstance(width, height, Image.SCALE_SMOOTH)
                );
                iconCache.put(key, icon);
            }
        }
        return iconCache.get(key);
    }
}