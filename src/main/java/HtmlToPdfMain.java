import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import java.io.*;

public class HtmlToPdfMain {
    public static void main(String[] args) throws FileNotFoundException, IOException   {
        // IO
        File htmlSource = new File("input.html");
        File pdfDest = new File("outputHTML.pdf");
        // pdfHTML specific code
        try {
            ConverterProperties converterProperties = new ConverterProperties();
            HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
                    new FileOutputStream(pdfDest), converterProperties);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
