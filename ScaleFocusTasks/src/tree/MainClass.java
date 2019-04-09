package tree;

import java.util.ArrayList;

public class MainClass {
	
	public static ArrayList<Branch> toDelete = new ArrayList<Branch>();
	static Branch root = new Branch("root", true);

	public static void main(String[] args) {
		
		createTree();
		
		visualiseTrees();

	}
	
	private static void createTree() {

		Branch br1 = root.addChild(new Branch("Branch 1", true));
		Branch br11 = br1.addChild(new Branch("Branch 11", false));
		Branch br111 = br11.addChild(new Branch("Branch 111", true));
		Branch br12 = br1.addChild(new Branch("Branch 12", true));
		Branch br121 = br12.addChild(new Branch("Branch 121", false));
		
		Branch br2 = root.addChild(new Branch("Branch 2", true));
		
		Branch br21 = br2.addChild(new Branch("Branch 21", true));
		Branch br22 = br2.addChild(new Branch("Branch 22", false));

		Branch br221 = br22.addChild(new Branch("Branch 221", true));
		Branch br211 = br21.addChild(new Branch("Branch 211", true));
		
	}
	
	private static void visualiseTrees() {
		
		System.out.println("Tree Before Cleaning: ");

		root.getChildren().forEach(each -> printBranch(each, ""));
		
		System.out.println();
	
		root.clearInvalid();
		
		toDelete.forEach(each -> each.getParent().getChildren().remove(each));
		
		System.out.println("Tree After Cleaning: ");
		
		root.getChildren().forEach(each -> printBranch(each, ""));
		
	}

	private static void printBranch(Branch br,String getSpacing) {
		String spacing = getSpacing; 
		System.out.println(getSpacing + br.toString());
		br.getChildren().forEach(each -> printBranch(each, spacing + "^" + each.getUniqueIdlen()));
	}

}
