package org.dynaresume.admin.eclipse.ui.graphics.skill.editors.commands;

import org.dynaresume.admin.eclipse.ui.graphics.skill.editors.model.TreeNode;
import org.dynaresume.admin.eclipse.ui.graphics.skill.editors.model.TreeNode;
import org.eclipse.gef.commands.Command;

public class CreateCommand extends Command {

	private TreeNode parent;
	private TreeNode child;
	private int index = -1;

	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if (index > 0)
			parent.addChild(child, index);
		else
			parent.addChild(child);
	}

	/**
	 * Sets the index to the passed value
	 * 
	 * @param i
	 *            the index
	 */
	public void setIndex(int i) {
		index = i;
	}

	/**
	 * Sets the parent ActivityDiagram
	 * 
	 * @param sa
	 *            the parent
	 */
	public void setParent(TreeNode sa) {
		parent = sa;
	}

	/**
	 * Sets the Activity to create
	 * 
	 * @param activity
	 *            the Activity to create
	 */
	public void setChild(TreeNode activity) {
		child = activity;
		child.setLabel("Skill " + (parent.getChildren().size() + 1));
	}

	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		parent.removeChild(child);
	}

}