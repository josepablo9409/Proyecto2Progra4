package Modelo;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.IOException;
import java.io.OutputStream;

public class Pdf {

    private final String namePDF = "factura.pdf";

    public void render(OutputStream os, Factura factura) throws IOException {
        PdfWriter writer = new PdfWriter(os);
        PdfDocument pdf = new PdfDocument(writer);
        try (Document doc = new Document(pdf, PageSize.A4.rotate())) {
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

            doc.setMargins(20, 20, 20, 20);
            doc.add(new Paragraph(""));
            doc.add(new Paragraph(factura.getEmisor().getTradename()).setFont(font).setBold().setFontSize(20f));
            doc.add(new Paragraph(""));
            doc.add(new Paragraph("Emisor").setFont(font).setBold().setFontSize(13f));
            Table table = new Table(8);
            Cell c;
//			Color bkg = ColorConstants.RED;
//			Color frg = ColorConstants.WHITE;
            c = new Cell();
            c.add(new Paragraph("Nombre del comercio"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Número de identificación"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Número de teléfono"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("E-Mail"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Provincia"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Cantón"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Distrito"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Dirección"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);

//			table.addHeaderCell(factura.getEmisor().getId_type() == 1 ? "Fisico" : "Juridico").setFontSize(11f);
            table.addHeaderCell(factura.getEmisor().getTradename()).setFontSize(11f);
            table.addHeaderCell(factura.getEmisor().getDni());
            table.addHeaderCell(factura.getEmisor().getTelephone());
            table.addHeaderCell(factura.getEmisor().getE_mail());
            table.addHeaderCell(factura.getEmisor().getLocation().getProvince());
            table.addHeaderCell(factura.getEmisor().getLocation().getCanton());
            table.addHeaderCell(factura.getCliente().getLocation().getDistrito());
            table.addHeaderCell(factura.getCliente().getLocation().getAddress());

//			c = new Cell(1, 4);
//
//			c.add(new Paragraph("SubTotal"));//.setBackgroundColor(bkg).setFontColor(frg).setTextAlignment(TextAlignment.RIGHT);
//			table.addHeaderCell(c);
//			c = new Cell();
//
//			c.add(new Paragraph("50000"));//.setBackgroundColor(bkg).setFontColor(frg);
//			table.addHeaderCell(c);
            doc.add(table);
            doc.add(new Paragraph(""));
            doc.add(new Paragraph("Cliente").setFont(font).setBold().setFontSize(13f));
            table = new Table(9);
//			Cell c;
//			Color bkg = ColorConstants.RED;
//			Color frg = ColorConstants.WHITE;
            c = new Cell();
            c.add(new Paragraph("Tipo de identificación"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Número de cédula"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Nombre completo"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Número de teléfono"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("E-Mail"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Provincia"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Cantón"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Distrito"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Dirección"));//.setBackgroundColor(bkg).setFontColor(frg);
            table.addHeaderCell(c);

            table.addHeaderCell(factura.getCliente().getId_type() == 1 ? "Fisico" : "Juridico").setFontSize(11f);
            table.addHeaderCell(factura.getCliente().getDni());
            table.addHeaderCell(factura.getCliente().getName());
            table.addHeaderCell(factura.getCliente().getTelephone());
            table.addHeaderCell(factura.getCliente().getE_mail());
            table.addHeaderCell(factura.getCliente().getLocation().getProvince());
            table.addHeaderCell(factura.getCliente().getLocation().getCanton());
            table.addHeaderCell(factura.getCliente().getLocation().getDistrito());
            table.addHeaderCell(factura.getCliente().getLocation().getAddress());

//			c = new Cell(1, 4);
//
//			c.add(new Paragraph("SubTotal"));//.setBackgroundColor(bkg).setFontColor(frg).setTextAlignment(TextAlignment.RIGHT);
//			table.addHeaderCell(c);
//			c = new Cell();
//
//			c.add(new Paragraph("50000"));//.setBackgroundColor(bkg).setFontColor(frg);
//			table.addHeaderCell(c);
            doc.add(table);

            doc.add(new Paragraph(""));
            doc.add(new Paragraph("Productos").setFont(font).setBold().setFontSize(13f));
            table = new Table(6);
            ListProduct productos = factura.getProductos();
            c = new Cell();
            c.add(new Paragraph(" "));
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Detalle"));
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Precio"));
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("I.V.A."));
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Cantidad"));
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph("Sub-Total"));
            table.addHeaderCell(c);

            for (int i = 0; i < productos.size(); i++) {
                c = new Cell();
                c.add(new Paragraph(String.valueOf(i + 1)));//.setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c = new Cell();
                c.add(new Paragraph(productos.get(i).getDetail()));
                table.addHeaderCell(c);
                c = new Cell();
                c.add(new Paragraph(String.valueOf(productos.get(i).getPrice())));
                table.addHeaderCell(c);
                c = new Cell();
                float iva = productos.get(i).getCategory().getIva() * 100;
                c.add(new Paragraph(String.valueOf(iva) + "%"));
                table.addHeaderCell(c);
                c = new Cell();
                c.add(new Paragraph(String.valueOf(productos.get(i).getCantidad())));
                table.addHeaderCell(c);
                c = new Cell();
                c.add(new Paragraph(String.valueOf(productos.get(i).getTotal())));
                table.addHeaderCell(c);
            }
            c = new Cell(1, 5);
            c.add(new Paragraph("Total")).setFontColor(ColorConstants.RED).setTextAlignment(TextAlignment.RIGHT).setFontSize(12f);
            table.addHeaderCell(c);
            c = new Cell();
            c.add(new Paragraph(String.valueOf(factura.getTotal())));
            table.addHeaderCell(c);

            doc.add(table);
        }
    }
}
