package com.aptana.ui.s3;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class S3UIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.aptana.ui.s3"; //$NON-NLS-1$

	// The shared instance
	private static S3UIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public S3UIPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static S3UIPlugin getDefault() {
		return plugin;
	}

	public static void logImportant(CoreException e)
	{
		getDefault().getLog().log(e.getStatus());
	}

	public static void logError(String msg, CoreException e)
	{
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, e));
	}

	public static ImageDescriptor getImageDescriptor(String string)
	{
		return imageDescriptorFromPlugin(PLUGIN_ID, string);
	}

}
