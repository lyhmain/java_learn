import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo1 {
    public static void main(String[] args) throws IOException {
        //1 创建ServerSocket对象，设置开放端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待连接....");

        //2 监听8888端口是否请求过来
        Socket socket = serverSocket.accept();
        System.out.println("一个客户端连接成功！！");
        //3 接收客户端发送过来的数据
        InputStream inputStream = socket.getInputStream();
        //接收数据
        byte[] data = new byte[1024];
        StringBuilder s = new StringBuilder();
        int len;
        while ((len = inputStream.read(data)) != -1) {
            s.append(new String(data, 0, len));
        }
        System.out.println("客户端发送的消息是：" + s);

        //4 发送数据到客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("欢迎登录".getBytes());
        outputStream.flush();

        //5 关闭
        socket.close();
        serverSocket.close();

    }
}
