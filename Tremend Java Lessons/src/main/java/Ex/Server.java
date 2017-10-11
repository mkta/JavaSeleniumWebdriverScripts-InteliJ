package Ex;

public class Server {
    public int id;
    public String name;
    public ServerStatus status;

    public enum ServerStatus {Stopped, Running, Unknown}


    public Server(String param) {

        String[] params = param.split("&");
        id = Integer.parseInt(params[0].split("=")[1]);
        name = params[1].split("=")[1];
        status = getStatus(params[2].split("=")[1]);
    }

    public ServerStatus getStatus(String status) {
        ServerStatus statusState = ServerStatus.Unknown;

        try {
            statusState = ServerStatus.valueOf(status);

        } catch (Exception exc) {
            System.out.println(exc);
        }

        return statusState;
    }

    @Override
    public String toString() {
        return "Server id: " + id + " Server name: " + name + " Server status: " + status;
    }
}

