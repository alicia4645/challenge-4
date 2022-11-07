import java.io.*;  
import java.net.*;  

public class server{
    public static void main(String[]args) throws IOException{
        //create server connection
        ServerSocket server=new ServerSocket(4999);  
        //accept client request
        Socket clientSocket = server.accept();
        System.out.println("client connected");

        while(true){
            try{
       
                DataInputStream input =new DataInputStream(clientSocket.getInputStream());
               
                String str=(String)input.readUTF();
              
                if(str.equals("stop")){
                    break;
                }
                else{
                    System.out.println(str);
                }
            }
            catch(Exception e){ 
                server.close();
            }
        }
         server.close();
         
    }
}




