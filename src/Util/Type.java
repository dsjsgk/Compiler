package Util;

public abstract class Type {
    public boolean is_boolean() {
        return false;
    }
    public boolean is_int() {
        return false;
    }
    public boolean is_string() {
        return false;
    }
    public boolean is_void() {
        return false;
    }
    public boolean is_null() {
        return false;
    }
    public boolean equal(Type tp) {
        return false;
    }
}
