import redis.clients.jedis.Jedis;

public class MainClass {
    public static void main(String[] args) {
        System.out.println(" my complete hello world");
        System.out.println(" a small change");
        System.out.println(" another change to the manin class");
        System.out.println("commit to jj branch");

        Calculator calc = new Calculator();
        System.out.println("using calculator class to add 2+ 5 = " + calc.add(2, 5));
        System.out.println(" yet another change 16/05/2021");
        System.out.println(" try to build from Jenkins 23/05 trigger automatic xx");

        try{

            //in the following code i'm running two different redis containers on my mac , then open redis-cli
            //insert key/value pairs and read it in the following code
            //verify in the docker client app on this machine that both container are up after you are
            // running the docker run  command

            // connecting to redis docker container to the external port of the container  6379
            //open terminal and  paste the command       docker run --name rdb -p 6379:6379 redis
            //then open another terminal for the redis-cli by putting the command  docker exec -it rdb redis-cli
            //then put something in the database key/value pair  like   set dog  Zuk
            //read the value of the key in the code below
            Jedis jedis= new Jedis("127.0.0.1",6379);//the external port of the docker container
            System.out.println(jedis.ping());
            System.out.println(jedis.get("dog"));

            //----------------------------------------

            // connecting to another redis docker container to the external port of the container  8888
            //open terminal and  paste the command       docker run --name jeckyRedis -p 8888:6379 redis
            //then open another terminal for the redis-cli by putting the command  docker exec -it jeckyRedis redis-cli
            //then put something in the database key/value pair  like   set cat  Miao
            //read the value of the key in the code below
            Jedis jedis2= new Jedis("127.0.0.1",8888);//the external port of the docker container
            System.out.println(jedis2.ping());
            System.out.println(jedis2.get("cat"));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}