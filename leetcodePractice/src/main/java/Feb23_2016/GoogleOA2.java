package Feb23_2016;
import java.util.ArrayList;

public class GoogleOA2 {


	
	public static int check (String file) {
		String[] lines = file.split("\\n");
		TreeNode root = new TreeNode("");
		root.numOfSpc = -1;
		TreeNode curr = root;
		int totalLen = 0;
		int currPathLen = 0;
		for (String line : lines) {
			TreeNode node = new TreeNode(line);
			
			while (curr.numOfSpc != node.numOfSpc - 1) {
				currPathLen -= (curr.name.length() + 1);
				curr = curr.parent;
			}
			curr.children.add(node);
			node.parent = curr;
			currPathLen += (node.name.length() + 1); 			
			curr = node;
			//System.out.println(node.name);
			//System.out.println(node.name.length());
			//System.out.println(node.numOfSpc);
			if (curr.isImage) {
				totalLen += (currPathLen - curr.name.length() - 1);
				System.out.println((currPathLen - curr.name.length() - 1));
			}
		}
		return totalLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String file = "dict1\n dict11\n  pict1.png\n dict21\n  pict2.jpeg";
		//System.out.println(file);
		//System.out.println();
		//System.out.println(check(file));

		String file2 = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		System.out.println(file2);
		System.out.println();
		System.out.println(check(file2));
	}

}

class TreeNode {
	int numOfSpc = 0;
	String name = "";
	TreeNode parent = null;
	boolean isImage = false;
	ArrayList<TreeNode> children = new ArrayList<TreeNode>();
	
	TreeNode(String line){
		String[] formats = {"gif", "jpg", "jpeg", "png"};
		this.numOfSpc = line.lastIndexOf(" ") + 1;
		this.name = line.substring(this.numOfSpc, line.length());
		for (String format : formats) {
			if (this.name.contains(".") && this.name.split("\\.")[1].contains(format)) {
				isImage = true;
			}
		}
	}
}