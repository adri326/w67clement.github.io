/*
 * Field of your plugin's instance.
 */
protected Plugin plugin;

/*
 * Constructor of Config abstract class, it's include your plugin instance and the file of configuration.
 */
public Config(Plugin plugin, File file);

/*
 * The method who initialize the Configuration when you create a new instance of this.
 */
public abstract void init();

/*
 * Load method was used for load the configuration's file.
 * It's can be rewrite for get data with super.load(); to call the parent method.
 * In the config class, the method isn't abstract because we save resource if isn't exists.
 */
public void load();

/*
 * Save method was used for save the configuration's file.
 * It's abstract in Config because the methods isn't same in YamlConfig and JsonConfig.
 */
public abstract void save();

/*
 * Gets the file of configuration.
 */
public File getFile();

/*
 * The method is same of save(String resourcePath, File dataFolder, boolean replace); but the data folder is your plugin's data folder.
 */
public void saveResource(String resourcePath, boolean replace);

/*
 * Saves an resource from the Plugin's Jar.
 * resourcePath: Path in jar to the resource. If include a folder, the folder will be create in the dataFolder.
 * dataFolder: Folder where the resource will be saved.
 * replace: Replace if already exists.
 */
public void saveResource(String resourcePath, File dataFolder, boolean replace);
