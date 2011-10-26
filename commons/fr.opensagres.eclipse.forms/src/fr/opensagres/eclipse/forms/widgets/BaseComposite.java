package fr.opensagres.eclipse.forms.widgets;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class BaseComposite extends Composite {

	private FormToolkit toolkit;

	public BaseComposite(Composite parent, int style, FormToolkit toolkit) {
		super(parent, style);
		if (toolkit != null) {
			toolkit.adapt(this);
		}
		this.toolkit = toolkit;
	}

	protected Text createText(Composite parent, int style) {
		FormToolkit toolkit = getToolkit();
		if (toolkit != null) {
			return toolkit.createText(parent, "", style);
		}
		return new Text(parent, style);
	}

	protected Button createButton(Composite parent, int style) {
		FormToolkit toolkit = getToolkit();
		if (toolkit != null) {
			return toolkit.createButton(parent, "", style);
		}
		return new Button(parent, style);
	}

	protected Label createLabel(Composite parent, int style) {
		FormToolkit toolkit = getToolkit();
		if (toolkit != null) {
			return toolkit.createLabel(parent, "", style);
		}
		return new Label(parent, style);
	}
	public FormToolkit getToolkit() {
		return toolkit;
	}

}