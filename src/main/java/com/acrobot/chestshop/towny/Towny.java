package com.acrobot.chestshop.towny;

import com.Acrobot.Breeze.Configuration.Configuration;
import com.acrobot.chestshop.towny.properties.Properties;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static java.util.logging.Level.SEVERE;

/**
 * @author Acrobot
 */
public class Towny extends JavaPlugin {
    private File dataFolder;

    @Override
    public void onEnable() {
        dataFolder = getDataFolder();

        Optional<File> config = loadFile("config.yml");
        if (config.isPresent()) {
            Configuration.pairFileAndClass(config.get(), Properties.class);
        } else {
            getLogger().log(SEVERE, "Config File Not Present or Loaded. Disabling.");
            onDisable();
            return;
        }

        if (Properties.BUILDING_INSIDE_PLOTS) {
            getServer().getPluginManager().registerEvents(new PlotListener(), this);
        }
    }

    @Override
    public void onDisable() {
        dataFolder = null;
    }

    /**
     * Ensures that a {@link File} exists, and tries to create the file if it does not.
     * <br> This method assumes that the File is a child of the {@link #dataFolder}.
     * @param string String representing a {@link File}.
     * @return An {@link Optional}&lt;{@link File}&gt; for the supplied String.
     */
    public Optional<File> loadFile(String string) {
        File file = new File(dataFolder, string);
        return loadFile(file);
    }

    private static Optional<File> loadFile(File file) {
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    boolean parentCreated = file.getParentFile().mkdirs();
                    if (!parentCreated) {
                        // Alternatively, could throw NoSuchFileException.
                        throw new IOException(file.getParent());
                    }
                }
                return createFile(file);
            } catch (IOException e) {
                return Optional.empty();
            }
        }
        return Optional.of(file);
    }

    private static Optional<File> createFile(File file) throws IOException {
        boolean fileCreated = file.createNewFile();
        if (fileCreated) {
            return Optional.of(file);
        }
        return Optional.empty();
    }
}
