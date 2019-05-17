package Quiz;

public class ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (ty > tx) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }
        return (tx == sx && sy <= ty && (ty - sy) % sx == 0)
                || (ty == sy && sx <= tx && (tx - sx) % ty == 0);
    }
}
