/*******************************************************************************
 * Copyright (c) 2008 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package com.aptana.formatter;

import com.aptana.formatter.nodes.IFormatterNode;

public interface IFormatterContext
{

	int getIndent();

	void incIndent();

	void decIndent();

	void resetIndent();

	IFormatterContext copy();

	boolean isIndenting();

	void setIndenting(boolean value);

	boolean isComment();

	void setComment(boolean value);

	int getBlankLines();

	void setBlankLines(int value);

	void resetBlankLines();

	/**
	 * @param node
	 */
	void enter(IFormatterNode node);

	/**
	 * @param node
	 */
	void leave(IFormatterNode node);

	IFormatterNode getParent();

	int getChildIndex();

	boolean isWrapping();

	void setWrapping(boolean value);

	/**
	 * Returns the length of the comment start in the offset position. In case there is no comment starting at the given
	 * offset, return 0. Example: For Ruby, the comment is starting with '#', so it there is a '#' in the offset, this
	 * method returns 1. For HTML, the comment start can be '&lt!' or '&lt!--', and in that case the return value can be
	 * 2 or 4.
	 * 
	 * @param chars
	 * @param offset
	 * @return The comment start length. Returns zero in case a comment does not start at the given position.
	 */
	int getCommentStartLength(CharSequence chars, int offset);

	/**
	 * Returns a string that will be appended as a comment prefix when the formatter wrapps long comments.
	 * 
	 * @return A comment prefix to append when wrapping a long comment (may be empty).
	 */
	String getWrappingCommentPrefix();

	/**
	 * Set the context to indicate it's in a foreign node.
	 * 
	 * @param isForeign
	 * @see #isInForeignNode()
	 */
	void setInForeignNode(boolean isForeign);

	/**
	 * Returns true is the context is in a foreign node at the moment. This will be true when a master formetter is
	 * writing nodes that should be processed by a slave formatter.
	 * 
	 * @return True if the current context is of a special node which should not be processed by this formatter.
	 * @see #setInForeignNode(boolean)
	 */
	boolean isInForeignNode();
}
