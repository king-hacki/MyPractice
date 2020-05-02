package item_36_enumSet_instead_bitField;

import java.util.EnumSet;
import java.util.Set;

public class SimpleExample {

    public static void main(String[] args) {

        BitUse.applyStyles(BitUse.STYLE_ITALIC | BitUse.STYLE_STRIKETHROUGH);
        EnumSetUse.applyStyles(EnumSet.of(EnumSetUse.Styles.STYLE_ITALIC, EnumSetUse.Styles.STYLE_STRIKETHROUGH));

    }

}

// Bit field enumeration constants - OBSOLETE!
class BitUse {

    public static final int STYLE_BOLD = 1;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    public static void applyStyles (int styles) {
        System.out.println(styles);
    }
}

// EnumSet - a modern replacement for bit fields
class EnumSetUse {
    public enum Styles { STYLE_BOLD, STYLE_ITALIC, STYLE_UNDERLINE, STYLE_STRIKETHROUGH }

    public static void applyStyles (Set<Styles> styles) {
        System.out.println(styles);
    }
}
