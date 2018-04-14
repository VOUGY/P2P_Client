import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author guillaume,gabriel
 *
 * @version 0.1
 * 
 * Manage file
 */
public class Files {

	private String path;
	private ArrayList<File> lstFiles = new ArrayList<File>();
	/**
	 * 
	 * @param path Folder contains the shared files 
	 */
	public Files(String path)
	{
		this.path = path;
		createList();
	}
	/**
	 * 
	 */
	public void createList()
	{
		File folder = new File(path);
		File[] lstFilesTemp = folder.listFiles();
		for (int i = 0; i < lstFilesTemp.length; i++) {
			if(lstFilesTemp[i].isFile())
			{
				//System.out.println(lstFilesTemp[i].getAbsolutePath());
				lstFiles.add(new File(lstFilesTemp[i].getAbsolutePath()));
			}
		}
		System.out.println("finish");
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<File> getLstFiles() {
		return lstFiles;
	}
	public void getEachNameFile() {
		for (File file : lstFiles) {
		//	System.out.println(file.getName() +"\t" +path+"/"+ file.getAbsoluteFile());
		}
	}
}
