import java.io.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class TextToPdfMain {
    public static void main(String[] args) {
        Document document = new Document();
        FileInputStream fis = null;
        DataInputStream dis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        File sourceFile = new File("input.txt");
        File destFile = new File("output.pdf");
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destFile));
            writer.setPdfVersion(PdfWriter.VERSION_1_7);
            document.open();
            document.setMarginMirroring(true);
            document.setMargins(40, 70, 110, 180);
            document.topMargin();

            BaseFont bf = BaseFont.createFont("Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 20);
            document.add(new Paragraph("\n"));
            if (sourceFile.exists()) {
                fis = new FileInputStream(sourceFile);
                dis = new DataInputStream(fis);
                isr = new InputStreamReader(dis);
                br = new BufferedReader(isr);
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    Paragraph paragraph = new Paragraph(strLine + "\n", font);
                    paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
                    document.add(paragraph);
                }
                System.out.println("file convertred");
            } else {
                System.out.println("file not found");
            }
            document.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (dis != null) {
                    dis.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
