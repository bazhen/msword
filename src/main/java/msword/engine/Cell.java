package msword.engine;

class Cell {

    private final String pattern;
    private final String value;

    Cell(String pattern, String value) {
        this.pattern = pattern;
        this.value = value;
    }

    String getPattern() {
        return pattern;
    }

    String getValue() {
        return value;
    }
    
}