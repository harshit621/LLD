import java.util.ArrayList;
import java.util.List;

public class Validator {
    List<String> errors;

    public Validator() {
        errors = new ArrayList<>();
    }

    public boolean valid(Student std) {
        // validation inline, printing inline
        if (std.name.isBlank()) errors.add("name is required");
        if (std.email.isBlank() || !std.email.contains("@")) errors.add("email is invalid");
        if (std.phone.isBlank() || !std.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(std.program.equals("CSE") || std.program.equals("AI") || std.program.equals("SWE"))) errors.add("program is invalid");
        if (!errors.isEmpty()) {
            isError();
            return false;
        }
        return true;  
    }

    public void isError() {
        System.out.println("ERROR: cannot register");
        for (String e : errors) System.out.println("- " + e);
    }
    




    
}
