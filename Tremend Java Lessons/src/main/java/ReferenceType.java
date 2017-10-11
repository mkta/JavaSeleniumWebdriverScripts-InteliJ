public class ReferenceType {
    public int xrt = 5;

    public void main(String[] args) {
        ReferenceType rt = new ReferenceType();

        System.out.println("This is initial value: " + rt.xrt);
        passMethodrt(rt);
        System.out.println("This is the value after the completion of the method: " + rt.xrt);
    }

    public void passMethodrt(ReferenceType rt) {
        rt.xrt = 10;
        System.out.println("This is the value from method: " + rt.xrt);


    }
}


