import java.util.*;
public class InvoiceGenerator {
    Menu menu;
    Total total;
    StringBuilder invoice;
    String invId;
    int invoiceSeq = 1000;
    public InvoiceGenerator(Menu menu, Total total) {
        invoice = new StringBuilder(); 
        this.total = total;
        this.menu = menu; 
        invId = "";
    }  

    public void generate(List<OrderLine> lines) {
        invId = "INV-" + (++invoiceSeq);
        // StringBuilder out = new StringBuilder();
        invoice.append("Invoice# ").append(invId).append("\n");

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            invoice.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }

        invoice.append(String.format("Subtotal: %.2f\n", total.subtotal));
        invoice.append(String.format("Tax(%.0f%%): %.2f\n", total.taxPct, total.tax));
        invoice.append(String.format("Discount: -%.2f\n", total.discount));
        invoice.append(String.format("TOTAL: %.2f\n", total.total));
    }
    public void print() {
        String printable = InvoiceFormatter.identityFormat(invoice.toString());
        System.out.print(printable);        
    }
}
