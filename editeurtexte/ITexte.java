package editeurtexte;

/**
 * @author gautier - UHP
 * @version 2014
 */
public interface ITexte {

    public void addLine(String ligne);

    public void clear();

    public int getSize();

    public String getLine(int index);

    public int getLineCount();

    public void setLine(int i, String ligne);
}
