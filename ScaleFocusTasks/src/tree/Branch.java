package tree;

import java.util.ArrayList;

public class Branch {
	
	private String uniqueId;
	private Branch parentId = null;
	private boolean status;
	private ArrayList<Branch> children = new ArrayList<Branch>();
	
	public Branch(String uniqueId,  boolean valid) {
		this.uniqueId = uniqueId;
		this.parentId = this;
		this.status = valid;
	}
	
//	public Branch(String uniqueId, boolean valid) {
//		this.uniqueId = uniqueId;
//		this.status = valid;
//	}

	@Override
	public String toString() {
		return "" + uniqueId + "(" + status + ")";
	}
	
	public Branch addChild(Branch child) {
		child.setParent(this);
		children.add(child);
		return child;
	}

	public ArrayList<Branch> getChildren() {
		return this.children;
	}
	
	public void setParent(Branch parent) {
		this.parentId = parent;
	}
	
	public Branch getParent() {
		return this.parentId;
	}

	public String getUniqueIdlen() {
		int len = this.uniqueId.length()-2;
		String output = "";
		for(int i = 0; i < len; i++) {
			output += "-";
		}
		return output;
	}
	
	public void clearInvalid() {
		if(this.status==false) {
			this.getChildren().clear();
//			this.parentId.getChildren().remove(this);
			MainClass.toDelete.add(this);
		}else {
			this.getChildren().forEach(each -> each.clearInvalid());
		}
	}
	
}
