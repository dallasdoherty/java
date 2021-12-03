package a5;

import java.util.List;

/**
 * A class that wraps a string by breaking the string into lines
 * of length equal to the desired wrapped line length (except
 * for possibly the last wrapped line which may be shorter
 * than the desired wrapped line length).
 *
 */
public class WrapAtWidthWrapper extends AbstractStringWrapper {

	/**
	 * Initializes this wrapper with the string to wrap and the
	 * desired maximum wrapped line width.
	 * 
	 * @param toWrap the string to wrap
	 * @param targetWidth the desired maximum wrapped line width
	 */
	public WrapAtWidthWrapper(String toWrap, int targetWidth) {
		// IMPLEMENT THIS
		super(toWrap, targetWidth);
	}
	
	
	/**
	 * Wraps the string into separate lines of text.
	 */
	@Override
	public void wrap() {
		// IMPLEMENT THIS
		this.lines.clear();
		int start = 0;
		int n = this.toWrap.length()/this.maxWidth;
		String chunk = toWrap.substring(start,toWrap.length());
		
		if(chunk.length() <= maxWidth) {
			this.lines.add(chunk);
		}
		
		else{
			
			for(int i = 0; i < n;i++) {
		
				int end = start + this.maxWidth;
				String chunkIt = toWrap.substring(start,end);
				this.lines.add(chunkIt);
				start = start + maxWidth;
		}
			if(start < this.toWrap.length()) {
			this.lines.add(toWrap.substring(start));
		}
			}
	}


	public static void main(String[] args) {
		int width = 30;
		AbstractStringWrapper w = new WrapAtWidthWrapper("ABCDEFGHIJKLMNOPQRSTUVWXYZ", width);
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
