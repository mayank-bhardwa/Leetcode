public class Pair<__tp1, __tp2> {
    __tp1 first;
    __tp2 second;

    Pair(__tp1 l, __tp2 r) {
        this.first = l;
        this.second = r;
    }

    Pair() {
    }

    public String toString() {
        return this.first + ": " + this.second;
    }
}