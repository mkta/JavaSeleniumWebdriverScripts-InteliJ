package Ex;

public class Square2 extends Quad implements IGeom {
    @Override
    public int arie() {
        return a*a;
    }

    @Override
    public int perimetru() {
        return 4*a;
    }

    @Override
    void Setxya(int x, int y, int a) {
        this.x=x;
        this.y=y;
        this.a=a;
    }
}
