import java.util.*;
public class Total {
    Menu menu;
    TaxRules rules;
    DiscountRules discountRules;
    double subtotal, tax, taxPct, total, discount;

    public Total(Menu menu, TaxRules rules, DiscountRules discountRules) {
        this.discountRules = discountRules;
        this.menu = menu;
        this. rules = rules;
        this.subtotal = 0.0;
        this.tax = 0.0;
        this.taxPct = 0.0;
        this.total = 0.0;
        this.discount = 0.0; 
    }

    public void calculate(List<OrderLine> lines) {
        // subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }

        taxPct = rules.taxPercent();
        tax = subtotal * (taxPct / 100.0);

        discount = discountRules.discountAmount(subtotal, lines.size());

        total = subtotal + tax - discount;

        // return total;
    }
    
    
}
