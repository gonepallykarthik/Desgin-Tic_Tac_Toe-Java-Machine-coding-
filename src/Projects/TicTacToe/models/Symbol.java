package src.Projects.TicTacToe.models;

public class Symbol {
    private char sym;
    private String color;

    public Symbol(char Sym, String color) {
        this.sym = Sym;
        this.color = color;
    }
    public char getSym() {
        return sym;
    }

    public void setSym(char sym) {
        this.sym = sym;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.valueOf(sym);
    }
}
