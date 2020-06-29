package swing;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class FileJTree extends JTree {
	private static final long serialVersionUID = 1L;
	private String rootPath;
	private DefaultMutableTreeNode rootNode;
	private DefaultTreeModel model;

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public FileJTree(String rootPath) {
		rootNode = new DefaultMutableTreeNode(rootPath);
		model = new DefaultTreeModel(rootNode);
		setModel(model);
		setTree(rootPath, rootNode);
		expandAllNodes(this, 0, this.getRowCount());
	}

	private void setTree(String path, DefaultMutableTreeNode node) {
		File file = new File(path);

		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				String directoryPath = f.getPath();
				DefaultMutableTreeNode folderNode = new DefaultMutableTreeNode(f.getName());
				if (!isDirEmpty(f)) {
					setTree(directoryPath, folderNode);
					node.add(folderNode);
				} else {
					continue;
				}
			} else {
				DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(f.getName());
				node.add(fileNode);
			}
		}

	}

	private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
		for (int i = startingIndex; i < rowCount; ++i) {
			tree.expandRow(i);
		}

		if (tree.getRowCount() != rowCount) {
			expandAllNodes(tree, rowCount, tree.getRowCount());
		}
	}

	synchronized public String getPath(TreePath treePath) {

		String tempPath1 = treePath.toString().replace("[", "");
//			System.out.println(tempPath1);
		String tempPath2 = tempPath1.replace("]", "");
//			System.out.println(tempPath2);
		String path = tempPath2.replace(", ", "\\");
		return path;

	}

	private boolean isDirEmpty(File file) {

		if (file.isDirectory() && file.list().length == 0) {
			System.out.println(true);
			return true;
		} else {
			return false;
		}

	}

}
