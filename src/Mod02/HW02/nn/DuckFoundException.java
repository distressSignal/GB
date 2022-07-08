package Mod02.HW02.nn;

public class DuckFoundException extends Exception{
    public DuckFoundException(int index, String name) {
        super(String.format("Утка %s под номером  %s попыталась проникнуть на вечеринку",
                name, index + 1));
    }
}
