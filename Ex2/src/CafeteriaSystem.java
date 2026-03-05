import java.util.*;

public class CafeteriaSystem {
    private final Repository repo;
    private final Total total;
    private final InvoiceGenerator invoiceGenerator;

    public CafeteriaSystem(
        Repository repo, 
        Total total, 
        InvoiceGenerator invoiceGenerator
    ) {
        this.repo = repo;
        this.total = total;
        this.invoiceGenerator = invoiceGenerator;
    }
    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        total.calculate(lines);
        invoiceGenerator.generate(lines);

        String printable = InvoiceFormatter.identityFormat(invoiceGenerator.invoice.toString());
        System.out.print(printable);
        // invoiceGenerator.print();

        repo.save(invoiceGenerator.invId, printable);
        System.out.println("Saved invoice: " + invoiceGenerator.invId + " (lines=" + repo.countLines(invoiceGenerator.invId) + ")");
    }
}
