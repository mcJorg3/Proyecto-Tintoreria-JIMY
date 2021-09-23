package programa;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.DatatypeConverter;

/**
 * Static class
 *
 * @author Ing.Jorge Carlos Mancera Méndez
 *
 */
public final class Globales {

    private Globales() {

    }

    /**
     * XX/XX/XXX
     * @return 
     */
    public static String getDate() {
        String standardFormatt;
        Date date = new Date();
        String s = "dd/MM/yyyy";

        DateFormat dateFormat = new SimpleDateFormat(s);
        standardFormatt = dateFormat.format(date);
        return standardFormatt;
    }

    /**
     * Return actual date of system. Format options:
     * <p>
     * 0 - yyyy-MM-dd</br>
     * 1 - dd-MM-yyyy
     * </p>
     *
     * @param option
     * @return
     */
    public static String getDate(int option) {
        String actualDate;
        Date date = new Date();
        String s = "";
        if (option == 0) {
            s = "yyyy-MM-dd";
        } else {
            s = "dd-MM-yyyy";
        }
        DateFormat dateFormat = new SimpleDateFormat(s);
        actualDate = dateFormat.format(date);
        return actualDate;
    }

    /**
     * Parsed date to String
     *
     * @param date
     * @return
     */
    public static String getDate(Date date) {
        String s = "";
        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            s = dateFormat.format(date);
        }
        return s;
    }

    /**
     * Method for save date in Database
     *
     * @param date
     * @return Object sql date
     * @throws java.text.ParseException
     */
    public static java.sql.Date sqlDate(String date) throws ParseException {
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		java.sql.Date data = null;
		try {
			Date parsed = dateFormat.parse(date);
			data = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}*/
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date fd = formatter.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(fd.getTime());

        return sqlDate;
    }
    
    public static java.sql.Date toSQLDate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = null;
        try {
            Date parsed = formato.parse(fecha);
            data = new java.sql.Date(parsed.getTime());

        } catch (ParseException e) {
            System.out.println(e);
        }
        return data;
    }
    

    /**
     * @return
     */
    public static String getStringDate() {
        String date, d, m;
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (day <= 9) {
            d = "0" + day;
        } else {
            d = String.valueOf(day);
        }
        if (month <= 9) {
            m = "0" + month;
        } else {
            m = String.valueOf(month);
        }
        date = String.valueOf(anio);
        date += m + d;
        return date;
    }

    /**
     * Output Format:000,00.00
     *
     * @param quantity
     * @return
     */
    public static String getQuantyFormat(double quantity) {
        String pattern = " ###,###.## ";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(quantity);
        return output;
    }

    /**
     * Only admit upper case letters in the field
     *
     * @param e
     */
    public static void fieldToUppercase(java.awt.event.KeyEvent e) {
        Character c = e.getKeyChar();
        if (Character.isLetter(c)) {
            e.setKeyChar(Character.toUpperCase(c));
        }
    }

   /**
    * 
    * @param e
    * @param field
    * @param LIMIT 
    */
    public static void fieldLimit(java.awt.event.KeyEvent e, javax.swing.JTextField field, int LIMIT) {
        
        String text=field.getText();
        if (text.length() == LIMIT) {
            e.consume();
        }
    }

    /**
     * Admit only numbers and decimal point
     *
     * @param e
     */
    public static void fieldNumber(javax.swing.JTextField txtField, java.awt.event.KeyEvent e) {
        int ASCII = (int) e.getKeyChar();
        if (ASCII >= 48 && ASCII <= 57 || ASCII == 46) {
            if (ASCII == 46) {
                String text = txtField.getText();
                for (int i = 0; i < text.length(); i++) {
                    if (text.contains(".")) {
                        e.setKeyChar((char) KeyEvent.VK_CLEAR);
                    }
                }
            }

        } else {
            e.consume();
        }
    }

    /**
     * @param e
     */
    public static void fieldOnlyNumber(java.awt.event.KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isLetter(c)) {
            e.consume();
        }
    }

    /**
     * @param s
     * @return
     */
    public static boolean validateNumberString(String s) {
        boolean st = false;
        // [0-9]*
        // [0-9]+(\.[0-9][0-9]?)?
        // ^[0-9]+([,][0-9]+)?$
        String patron = "^[0-9]+([.][0-9]+)?$";
        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(s);
        if (mat.matches()) {
            System.out.println("SI");
            st = true;
        } else {
            st = false;
            System.out.println("NO");
        }
        return st;
    }

    /**
     * Round number two digit before decimal point Format:0.00
     *
     * @param number
     * @return
     */
    public static double formatToDecimal(double number) {
        double roundNUmber;
        DecimalFormat format = new DecimalFormat("#.##");
        format.setRoundingMode(RoundingMode.UP);
        format.format(number);
        roundNUmber = number;
        return roundNUmber;
    }

    /**
     *
     * @param n
     * @return
     */
    public static String stringFormatToDecimal(double n) {
        String s = String.format("%.2f", n);
        return s;
    }

    /**
     *
     * @param table
     */
    public static void clearTable(javax.swing.JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public static void removeRow(javax.swing.JTable table) {
        DefaultTableModel modelo1 = (DefaultTableModel) table.getModel();
        int reg = table.getSelectedRow();
        if (reg < 0) {
            JOptionPane.showMessageDialog(null, "Please,You must select a row from the table");
        } else {
            modelo1.removeRow(reg);
        }
    }

    /**
     * Format:HH:mm:ss dd/MM/yyyy
     *
     * @return
     */
    public static String getHourDate() {
        String s;
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        s = String.valueOf(hourdateFormat.format(date));
        return s;
    }

    /**
     * Search application for Open file
     *
     * @param path
     */
    public static void open(String path) {
        try {
            File file = new File(path);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File not found" + e, "Error" + e,
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,
                    "The specified path is not correct or the name contains special characters...." + e, "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * Save text in memory transfer content of clipboard to string
     *
     * @return
     */
    public static String copyText() {
        String text = "";
        try {
            Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            text = (String) t.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            JOptionPane.showMessageDialog(null, "Message:Unsopported error: " + e, "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
        return text;
    }

    /**
     * Print text file with default printer
     *
     * @param text_doc
     */
    public static void print(String text_doc) {
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(text_doc);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Message:Unsopported error: " + e, "Runtime Exception", JOptionPane.ERROR_MESSAGE);
        }
        if (inputStream == null) {
            return;
        }
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        attributeSet.add(new Copies(2));
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {

            DocPrintJob printJob = defaultPrintService.createPrintJob();
            attributeSet.add(new Copies(2));
            try {
                printJob.print(document, attributeSet);
            } catch (PrintException e) {
                JOptionPane.showMessageDialog(null, "Message:Error printing file: " + e, "Print Exception", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No printer installed... ", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            inputStream.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Message:Error while reading file: " + ex, "Input Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
	 * public static void imprimirPDF(String path) throws IOException {
	 * FileInputStream inputStream = null;
	 * 
	 * File file = new File(path); file.getAbsolutePath(); try { inputStream = new
	 * FileInputStream(path); } catch (FileNotFoundException e) {
	 * JOptionPane.showMessageDialog(null, "No se encontro archivo " + e); } if
	 * (inputStream == null) { return; } Path pdfPath = Paths.get(path); byte[] pdf
	 * = Files.readAllBytes(pdfPath);
	 * 
	 * DocFlavor docFormat = DocFlavor.BYTE_ARRAY.AUTOSENSE; Doc document = new
	 * SimpleDoc(pdf, docFormat, null); PrintRequestAttributeSet attributeSet = new
	 * HashPrintRequestAttributeSet(); PrintService defaultPrintService =
	 * PrintServiceLookup.lookupDefaultPrintService(); if (defaultPrintService !=
	 * null) { DocPrintJob printJob = defaultPrintService.createPrintJob(); try {
	 * printJob.print(document, attributeSet); } catch (PrintException e) {
	 * JOptionPane.showMessageDialog(null,
	 * "Ocurrio un error al imprimir el archivo " + e); } } else {
	 * JOptionPane.showMessageDialog(null, "Ocurrio un error al leer archivo... ",
	 * "Error Printer", JOptionPane.ERROR_MESSAGE); } inputStream.close(); }
     */
 
}

