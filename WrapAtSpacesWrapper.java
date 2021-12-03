package a5;

import java.util.List;

/**
 * A class that wraps a string by breaking the string into lines
 * of length equal to or less than the desired wrapped line length.
 * The breaking occurs at spaces in the string where possible. If
 * a wrapped line contains no strings before the desired wrapped
 * line length, then the line is broken at the desired wrapped
 * line length.
 *
 */
public class WrapAtSpacesWrapper extends AbstractStringWrapper {

	/**
	 * Initializes this wrapper with the string to wrap and the
	 * desired maximum wrapped line width.
	 * 
	 * @param toWrap the string to wrap
	 * @param targetWidth the desired maximum wrapped line width
	 */
	public WrapAtSpacesWrapper(String toWrap, int targetWidth) {
		// IMPLEMENT THIS
		super(toWrap,targetWidth);
	}

	public int findSpaceBrk(String subStr) {
		int end = this.maxWidth;
		if(subStr.charAt(subStr.length()-1) == ' ' ||
				(subStr.length() == this.maxWidth) && 
				subStr.charAt(subStr.length()-1) != ' ')
		{
			return end;
		}
		else{
		end = subStr.lastIndexOf(" ");
		if (end < 0) {
			end = this.maxWidth;
		}
		return end;
		}
	}
	
	/**
	 * Wraps the string into separate lines of text.
	 */
	public void wrap() {
		// IMPLEMENT THIS
		this.lines.clear();
		int i = this.maxWidth;
		int start = 0;
		int end = this.maxWidth;
		if (toWrap.length() <= this.maxWidth) {
			this.lines.add(toWrap);
		}
		else {
			while (start <= toWrap.length()) {
				if ((start + this.maxWidth) >= toWrap.length()) {
					this.lines.add(toWrap.substring(start));
					break;
				}
				String check = toWrap.substring(start, i);
				
				if(check.isBlank() == true) {
					start = start + this.maxWidth;
					i = start + this.maxWidth;
					end = findSpaceBrk(check);
					this.lines.add(toWrap.substring(start, start + end));
					start = start + end;
					i = start + this.maxWidth;
				}
				
				else if(this.maxWidth > 2 && check.charAt(check.length() - 2) == ' ' &&
						check.charAt(check.length()-1) != ' ') {
					i = start + (this.maxWidth - 2);
					end = i;
					this.lines.add(toWrap.substring(start, start + end));
					start = start + end;
					i = start + this.maxWidth;
				}
				
				else if(this.maxWidth >= 3 && check.charAt(2) == ' ' &&
						check.charAt(0) == ' ' ) {
					start = start + 1;
					end = start + 1;
					this.lines.add(toWrap.substring(start,end));
					start = end + 1;
					i = start + end + this.maxWidth;
				}
				
				else if(check.charAt(0) == ' ') {
					start = start + 1;
					end = findSpaceBrk(check);
					this.lines.add(toWrap.substring(start, start + end));
					start = start + end;
					i = start + this.maxWidth;
				}
				else {
					end = findSpaceBrk(check);
					this.lines.add(toWrap.substring(start, start + end));
					start = start + end;
					i = start + this.maxWidth;
				}
				
			}
			}
		}

	public static void main(String[] args) {
		int width = 30;
		AbstractStringWrapper w = new WrapAtSpacesWrapper("ABC DEFGH I JKLMNOPQ RSTUVWXYZ", width);
		w.wrap();
		List<String> wrapped = w.getLines();
		String out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 20;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 5;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 1;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");

	}
}
