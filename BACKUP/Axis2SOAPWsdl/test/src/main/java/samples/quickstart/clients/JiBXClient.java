package samples.quickstart.clients;


public class JiBXClient{
    public static void main(java.lang.String args[]){

        try{
            MavenAxis2WebServiceStub stub =
                new MavenAxis2WebServiceStub
                ("http://localhost:8080/test/services/MavenAxis2WebService");

            ping(stub);


        } catch(Exception e){
            e.printStackTrace();
            System.err.println("\n\n\n");
        }
    }


    /* two way call/receive */
    public static void ping(MavenAxis2WebServiceStub stub){
        try{
            System.err.println(stub.ping("Bob", "Smith", "48 Westview Ln", "Apt 739", "Dallas", "TX", "73895"));
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("\n\n\n");
        }
    }

}