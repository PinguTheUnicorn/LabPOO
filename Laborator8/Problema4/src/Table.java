import java.awt.*;
import java.awt.print.*;

public class Table implements Printable {
    private Object[][] toPrint;
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return 0;
    }

    public Table(Object[][] obj) {
        toPrint = obj;
    }

    private class CsvPrinter extends PrinterGraphics{

    }
}
