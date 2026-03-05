import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");
        Menu menu = new Menu();
        Repository repo = new FileStore();
        TaxRules rules = new StudentTax();
        DiscountRules discount = new StudentDiscount();
        Total total = new Total(menu, rules, discount);
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(menu, total);

        menu.add(new MenuItem("M1", "Veg Thali", 80.00));
        menu.add(new MenuItem("C1", "Coffee", 30.00));
        menu.add(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        CafeteriaSystem sys = new CafeteriaSystem(repo, total, invoiceGenerator);

        sys.checkout("student", order);
    }
}
