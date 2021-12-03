package a5;

import java.util.List;

/**
 * This class produces similar results as its superclass except that
 * each line of wrapped text is padded with a padding character so
 * that the length of each wrapped line is exactly equal to the
 * desired wrapped line length. 
 */
public class WrapAtSpacesAndPadWrapper extends WrapAtSpacesWrapper {

	private char padding;
	
	/**
	 * Initializes this wrapper with the string to wrap and the
	 * desired maximum wrapped line width. The padding character is
	 * set to the space character.
	 * 
	 * @param toWrap the string to wrap
	 * @param targetWidth the desired maximum wrapped line width
	 */
	public WrapAtSpacesAndPadWrapper(String toWrap, int targetWidth) {
		// IMPLEMENT THIS
		this(toWrap, targetWidth, ' ');
	}
	
	/**
	 * Initializes this wrapper with the string to wrap, the
	 * desired maximum wrapped line width, and the character to pad
	 * the end of the wrapped lines with.
	 * 
	 * @param toWrap the string to wrap
	 * @param targetWidth the desired maximum wrapped line width
	 * @param padding the padding character
	 */
	public WrapAtSpacesAndPadWrapper(String toWrap, int targetWidth, char padding) {
		// IMPLEMENT THIS
		super(toWrap, targetWidth);
		this.padding = padding;
	}
	
	/**
	 * Returns the padding character.
	 * 
	 * @return the padding character
	 */
	public char paddingChar() {
		return this.padding;
	}
	
	/**
	 * Sets the padding character to the specified padding character.
	 * The string is not re-wrapped by this method. The user should call
	 * {@code wrap()} to re-wrap the string to use the new padding character.
	 * 
	 * @param padding the new padding character
	 */
	public void paddingChar(char padding) {
		this.padding = padding;
	}
	
	
	/**
	 * Wraps the string into separate lines of text.
	 */
	@Override
	public void wrap() {
		// IMPLEMENT THIS
		
		super.wrap();
		
		for (int i = 0; i < this.lines.size(); i++) {
			if (this.lines.get(i).length() != this.maxWidth) {
				int amount =  this.maxWidth - this.lines.get(i).length();
				String addPadding = "";
				for (int j = 0; j < amount; j++) {
					addPadding += this.padding;
			}
				this.lines.set(i, this.lines.get(i) + addPadding);
			}
		}
		
	}
	
	public static void main(String[] args) {
		int width = 30;
		WrapAtSpacesAndPadWrapper w = new WrapAtSpacesAndPadWrapper("ABC DEFGH I JKLMNOPQ RSTUVWXYZ", width, '*');
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
		w.paddingChar('#');
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 1;
		w.width(width);
		w.paddingChar('.');
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
	}
}
