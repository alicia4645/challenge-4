import java.io.*;  
import java.net.*;  

public class client{
   

    public static void main(String[]args) throws IOException{

        InputStreamReader input=new InputStreamReader(System.in);  
        BufferedReader br=new BufferedReader(input);
       			
	    System.out.println("Enter your name");
	    String name = br.readLine();

        Socket clientSocket =new Socket("localhost",4999); 
      
	    System.out.println("type your message");
	

        while(true){
            try{
                String message = br.readLine();
                DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());

                if(message.equals("stop")){
                    output.writeUTF("stop"); 
                    break;
                }
                else{ output.writeUTF("["+name+"]:"+message);}
            }
            catch(Exception e){ 
                clientSocket.close();
            }  
        }

        clientSocket.close();
    }

    
}


