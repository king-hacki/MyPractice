package item_16_accessor_methods_over_fields;

public class TestProvider {
    public String p = "public ";
    public final String f = "final";
    private String m = "method accesso";

    public void setM(String m) {
        this.m = m;
    }

    public String getM() {
        return m;
    }
}
