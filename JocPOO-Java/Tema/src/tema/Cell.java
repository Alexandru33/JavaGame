package tema;

public class Cell {

    int x;
    int y;
    enum Tip {
        START,
        EMPTY,
        ENEMY,
        SHOP,
        FINISH
    }
    Tip tip;
    boolean visited;
    CellElement tipCell;

    public Cell ( int x, int y, Tip tip, CellElement tipCell)
    {
        this.x = x;
        this.y = y;
        this.tip = tip;
        this.tipCell = tipCell;
        visited = false;
    }

    public String toString()
    {
        if ( visited == false) return " ?? ";
        else
        {
            if ( tip == Tip.EMPTY) return " em ";
            if ( tip == Tip.ENEMY) return " EN ";
            if ( tip == Tip.SHOP) return " SH ";
            if ( tip == Tip.FINISH) return " FI ";
            if ( tip == Tip.START) return  " ST ";
        }
        return " EROARE ";
    }

}
